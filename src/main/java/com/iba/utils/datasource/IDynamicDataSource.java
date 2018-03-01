package com.iba.utils.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class IDynamicDataSource extends AbstractRoutingDataSource {

	 //使用ThreadLocal记录当前线程的数据源key
    private static final ThreadLocal<String> SOURCE_LOCAL = new ThreadLocal<String>();

    /**
     * 设置数据源key
     */
    public static void putDataSourceKey(String key) {
    	SOURCE_LOCAL.set(key);
    }
    
    /**
     * 获取数据源key
     */
    public static String getDataSourceKey() {
        return SOURCE_LOCAL.get();
    }
	
	@Override
	protected Object determineCurrentLookupKey() {
		//使用DynamicDataSourceHolder保证线程安全，并且得到当前线程中的数据源key
        return getDataSourceKey();
	}
}
