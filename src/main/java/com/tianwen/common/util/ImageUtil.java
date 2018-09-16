package com.tianwen.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageUtil {
	
	private String basePath;
	public ImageUtil() {
		try {
			Properties properties = new Properties();
			ClassPathResource cp = new ClassPathResource("upload_path.properties");
			InputStream in = cp.getInputStream();
			properties.load(in);
			basePath = properties.getProperty("basePath");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *
	 * 功能描述 保存图片
	 *
	 * @param filedata
	 *            文件数据 返回图片位置
	 */
	public String saveFile(MultipartFile filedata, String category) {
		// TODO Auto-generated method stub
		//String pathval = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/";
		String categoryPath = category + "/";
		String saveFilePath = basePath + categoryPath;
		// String pathval = "F:\\work\\";
		// 根据配置文件获取服务器图片存放路径
		String newFileName = String.valueOf(System.currentTimeMillis());
		//String saveFilePath = "images/uploadFile/" + category + "/";
		/* 构建文件目录 */
		File fileDir = new File(saveFilePath);
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}
		// 上传的文件名
		String filename = filedata.getOriginalFilename();
		// 文件的扩张名
		String extensionName = filename.substring(filename.lastIndexOf(".") + 1);
		try {
			String imgPath = saveFilePath + newFileName + "." + extensionName;
			// System.out.println(pathval + imgPath);打印图片位置
			FileOutputStream out = new FileOutputStream(imgPath);
			// 写入文件
			out.write(filedata.getBytes());
			out.flush();
			out.close();
			return categoryPath + newFileName + "." + extensionName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 *
	 * 功能描述：删除图片
	 *
	 * @param oldPic
	 *
	 */
	private void deleteFile(String oldPic) {
		// TODO Auto-generated method stub

		/* 构建文件目录 */
		File fileDir = new File(oldPic);
		if (fileDir.exists()) {
			// 把修改之前的图片删除 以免太多没用的图片占据空间
			fileDir.delete();
		}

	}
}
