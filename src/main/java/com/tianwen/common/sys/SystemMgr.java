package com.tianwen.common.sys;

import org.springframework.stereotype.Component;


@Component
public class SystemMgr {
	
	private static int i=0;
	
//	@Autowired
//	private DictService dictService;
//	
//	@Autowired
//	private CacheService cacheService;

	 /**
     * 系统初始化
     */
//    @PostConstruct
//	public void init(){
//    	if(i==0){
//			new Thread() {
//				@Override
//				public void run() {
//					try{
//						i++;
//						Thread.sleep(10*1000);
//		            		
//					}catch (Exception e) {
//						LogUtils.info(SystemMgr.class,e.getMessage());
//					}
//					LogUtils.info(SystemMgr.class,"his系统初始化缓存reids服务开始");
//					initDatas();
//					LogUtils.info(SystemMgr.class,"his系统初始化缓存reids服务结束");
//				}
//			}.start();
//		}
//	}
//    
    
    
}
