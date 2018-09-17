package com.tianwen.core.backstage.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tianwen.base.util.Pager;
import com.tianwen.common.util.JsonResponseResult;
import com.tianwen.common.util.RegistCodeUtil;
import com.tianwen.common.util.SysUtil;
import com.tianwen.common.util.SysUtils;
import com.tianwen.core.backstage.dao.BackDao;
import com.tianwen.core.backstage.dto.CategoryDto;
import com.tianwen.core.backstage.dto.OfflineOrderCondition;
import com.tianwen.core.backstage.dto.OnlineOrderCondition;
import com.tianwen.core.backstage.dto.OnlineOrderDetail;
import com.tianwen.core.backstage.dto.OnlineOrderDto;
import com.tianwen.core.backstage.dto.ProductCondition;
import com.tianwen.core.backstage.dto.RegistCodeCondition;
import com.tianwen.core.backstage.entity.Banner;
import com.tianwen.core.backstage.entity.Product;
import com.tianwen.core.backstage.entity.RegistCode;
import com.tianwen.core.backstage.entity.TOfflineOrder;
import com.tianwen.core.backstage.service.BackService;

@Service
public class BackServiceImpl implements BackService{
	
	@Autowired
	private BackDao backDao;

	@Override
	public JsonResponseResult addNewCategory(CategoryDto dto) {
		
		int maxSort = backDao.findCategoryMaxSort();
		
		if(SysUtil.isEmpty(maxSort)) {
			maxSort = 1; 
		}else{
			if(dto.getSort() <= maxSort) return JsonResponseResult.createFalied("排序序号必须大于现有的最大序号");
		}
		
		dto.setCreatetime(SysUtil.getTime());
		
		backDao.addNewCategory(dto);
		
		return JsonResponseResult.createSuccess();
	}

	@Override
	public List<CategoryDto> findAllCategories() {
		return backDao.findAllCategories();
	}
	
	
	@Override
	public JsonResponseResult addNewProduct(Product product) {
		product.setCreateTime(SysUtil.getTime());
		backDao.addNewProduct(product);
		
		return JsonResponseResult.createSuccess();
	}

	@Override
	public Pager findAllProducts(ProductCondition condition, String pageNo) {
		Pager pager = new Pager();
		HashMap<String, Object> param = SysUtils.transBean2Map(condition);
		pager.setPageNo(pageNo);
		pager.setPageSize(8);
		pager.setTotalRows(param, backDao.countAllProducts(param));
		List<Product> list = backDao.findAllProducts(param);
		pager.setList(list);
		return pager;
	}

	public List<Banner> findAllBanners() {
		return backDao.findAllBanners();
	}
	
	@Override
	public JsonResponseResult addNewBanner(Banner banner) {
		
		int maxSort = backDao.findBannerMaxSort();
		
		if(SysUtil.isEmpty(maxSort)) {
			maxSort = 1; 
		}else{
			if(banner.getSort() <= maxSort) return JsonResponseResult.createFalied("排序序号必须大于现有的最大序号");
		}
		
		
		backDao.addNewBanner(banner);
		
		return JsonResponseResult.createSuccess();
	}

	@Override
	public JsonResponseResult updCategorySort(List<CategoryDto> categories) {
		backDao.updCategorySort(categories);
		return JsonResponseResult.createSuccess();
	}

	@Override
	public JsonResponseResult updCategory(CategoryDto dto) {
		backDao.updCategory(dto);
		return JsonResponseResult.createSuccess();
	}

	@Override
	public JsonResponseResult updBannerSort(List<Banner> banners) {
		backDao.updBannerSort(banners);
		return JsonResponseResult.createSuccess();
	}

	@Override
	public JsonResponseResult updBanner(Banner banner) {
		backDao.updBanner(banner);
		return JsonResponseResult.createSuccess();
	}

	@Override
	public JsonResponseResult findAllRegistCode(String pageNo, RegistCodeCondition condition) {
		Pager pager = new Pager();
		HashMap<String, Object> param = SysUtils.transBean2Map(condition);
		pager.setPageNo(pageNo);
		pager.setPageSize(8);
		pager.setTotalRows(param, backDao.countAllRegistCode(param));
		List<RegistCode> list = backDao.findAllRegistCode(param);
		pager.setList(list);
		
		String ajaxPage = pager.getSiAjaxPageHtml();
		JsonResponseResult result = JsonResponseResult.createSuccess();
		result.addData(pager);
		result.addData(ajaxPage);
		
		return result;
	}

	@Override
	public JsonResponseResult addRegistCode(Integer codeCount) {
		List<RegistCode> registCodes = RegistCodeUtil.genRegistCode(codeCount);
		backDao.addRegistCode(registCodes);
		return JsonResponseResult.createSuccess();
	}

	@Override
	public JsonResponseResult listOfflineOrder(String pageNo, OfflineOrderCondition condition) {
		Pager pager = new Pager();
		HashMap<String, Object> param = SysUtils.transBean2Map(condition);
		pager.setPageNo(pageNo);
		pager.setPageSize(8);
		pager.setTotalRows(param, backDao.countOfflineOrder(param));
		List<TOfflineOrder> list = backDao.listOfflineOrder(param);
		pager.setList(list);
		
		String ajaxPage = pager.getSiAjaxPageHtml();
		JsonResponseResult result = JsonResponseResult.createSuccess();
		result.addData(pager);
		result.addData(ajaxPage);
		
		return result;
	}

	@Override
	public JsonResponseResult addOfflineOrderList(MultipartFile excel) throws IOException {
		List<TOfflineOrder> orders = getOfflineOrdersFromExcel(excel);
		if (orders == null || orders.size() == 0) {
			return JsonResponseResult.createFalied("数据为空");
		}
		backDao.addOfflineOrderList(orders);
		return JsonResponseResult.createSuccess();
	}

	@SuppressWarnings("resource")
	private List<TOfflineOrder> getOfflineOrdersFromExcel(MultipartFile excel) throws IOException {
		File orderExcel = getOrderExcel(excel);
		Workbook wb = null;
		Sheet sheet = null;
		if (orderExcel.getName().endsWith(".xls")) {
			wb = new HSSFWorkbook(new FileInputStream(orderExcel));
		} else {
			wb = new XSSFWorkbook(new FileInputStream(orderExcel));
		}
		sheet = wb.getSheetAt(0);
		
		List<TOfflineOrder> orders = new ArrayList<>();
		Iterator<Row> rowIt = sheet.rowIterator();

		while (rowIt.hasNext()) {
			Row row = rowIt.next();
			if (row.getRowNum() < 1) {
				continue;
			}
			boolean overFlag = true;
			for (int i = 0; i <= 6; i++) {
				Cell cell = row.getCell(i);
				if (cell != null && cell.getCellType() != CellType.BLANK) {
					overFlag = false;
				}
			}
			if (overFlag) {
				break;
			}
			TOfflineOrder order = new TOfflineOrder();
			order.setDate(row.getCell(0).getStringCellValue());
			row.getCell(1).setCellType(CellType.STRING); 
			order.setMemberNo(row.getCell(1).getStringCellValue());
			order.setProductName(row.getCell(2).getStringCellValue());
			order.setOrignalPrice(row.getCell(3).getNumericCellValue());
			order.setMemberPrice(row.getCell(4).getNumericCellValue());
			order.setPreferentialPrice(row.getCell(5).getNumericCellValue());
			order.setNum(row.getCell(6).getNumericCellValue());
			orders.add(order);
		}
		
		return orders;
	}

	private File getOrderExcel(MultipartFile excel) throws IOException {
		File orderExcel = new File(excel.getOriginalFilename());
		orderExcel.createNewFile(); 
	    FileOutputStream fos = new FileOutputStream(orderExcel); 
	    fos.write(excel.getBytes());
	    fos.close(); 
		return orderExcel;
	}

	@Override
	public JsonResponseResult updOfflineOrder(TOfflineOrder order) {
		backDao.updOfflineOrder(order);
		return JsonResponseResult.createSuccess();
	}

	@Override
	public JsonResponseResult listOnlineOrder(String pageNo, OnlineOrderCondition condition) {
		Pager pager = new Pager();
		HashMap<String, Object> param = SysUtils.transBean2Map(condition);
		pager.setPageNo(pageNo);
		pager.setPageSize(8);
		pager.setTotalRows(param, backDao.countOnlineOrder(param));
		List<OnlineOrderDto> list = backDao.listOnlineOrder(param);
		pager.setList(list);
		
		String ajaxPage = pager.getSiAjaxPageHtml();
		JsonResponseResult result = JsonResponseResult.createSuccess();
		result.addData(pager);
		result.addData(ajaxPage);
		
		return result;
	}

	@Override
	public JsonResponseResult delOfflineOrderById(Integer id) {
		backDao.delOfflineOrderById(id);
		return JsonResponseResult.createSuccess();
	}

	@Override
	public JsonResponseResult listOnlineOrderDetailByOid(Integer oid) {
		OnlineOrderDetail orderDetail = backDao.findOnlineOrderDetailByOid(oid);
		JsonResponseResult result = JsonResponseResult.createSuccess();
		result.addData(orderDetail);
		return result;
	}


}
