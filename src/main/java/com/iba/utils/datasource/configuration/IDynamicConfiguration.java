package com.iba.utils.datasource.configuration;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
import com.iba.utils.datasource.IDynamicDataSource;


/**
 * springboot整合数据源
 * @author huangxincheng
 */
@SpringBootConfiguration
@ConditionalOnClass(value = {IDynamicDataSource.class})
@ConditionalOnProperty(name="spring.datasource.type",  havingValue = "com.iba.utils.datasource.IDynamicDataSource", matchIfMissing = true)
public class IDynamicConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(IDynamicConfiguration.class);
	
	
	
	
	/**
	 * 整合自定义动态数据源
	 * 
	 * 	缺陷 暂时不能调整druid数据源 只能使用默认配置
	 * @author huangxincheng
	 *
	 */
	static class IDynamic extends IDynamicConfiguration {
		
		@Bean
		@Primary
		public IDynamicDataSource dataSource() throws SQLException {
			Map<Object,Object> sourceMap = new HashMap<>();
			{
				DruidDataSource u6 = new DruidDataSource();
				u6.setUrl("jdbc:mysql://mailou.com:3306/springcloud?characterEncoding=utf-8");
				u6.setUsername("hxc");
				u6.setPassword("hxc");
				u6.setDriverClassName("com.mysql.jdbc.Driver");
				u6.setInitialSize(5);
				u6.setMaxActive(50);
				u6.setMinIdle(1);
				u6.setMaxWait(60000);
				u6.setPoolPreparedStatements(true);
				u6.setMaxPoolPreparedStatementPerConnectionSize(33);
				u6.setValidationQuery("select 1");
				u6.setTestOnBorrow(false);
				u6.setTestOnReturn(false);
				u6.setTestWhileIdle(true);
				u6.setTimeBetweenEvictionRunsMillis(60000);
				u6.setMinEvictableIdleTimeMillis(25200000);
				u6.setRemoveAbandoned(true);
				u6.setRemoveAbandonedTimeout(1800);
				u6.setLogAbandoned(true);
				u6.addFilters("stat");
				u6.setConnectionProperties("druid.stat.slowSqlMillis=10");
				sourceMap.put("u6", u6);
			}
			{
				DruidDataSource localhost = new DruidDataSource();
				localhost.setUrl("jdbc:mysql://localhost:3306/springcloud?characterEncoding=utf-8");
				localhost.setUsername("root");
				localhost.setPassword("sorry");
				localhost.setDriverClassName("com.mysql.jdbc.Driver");
				localhost.setInitialSize(5);
				localhost.setMaxActive(50);
				localhost.setMinIdle(1);
				localhost.setMaxWait(60000);
				localhost.setPoolPreparedStatements(true);
				localhost.setMaxPoolPreparedStatementPerConnectionSize(33);
				localhost.setValidationQuery("select 1");
				localhost.setTestOnBorrow(false);
				localhost.setTestOnReturn(false);
				localhost.setTestWhileIdle(true);
				localhost.setTimeBetweenEvictionRunsMillis(60000);
				localhost.setMinEvictableIdleTimeMillis(25200000);
				localhost.setRemoveAbandoned(true);
				localhost.setRemoveAbandonedTimeout(1800);
				localhost.setLogAbandoned(true);
				localhost.addFilters("stat");
				localhost.setConnectionProperties("druid.stat.slowSqlMillis=10");
				sourceMap.put("localhost", localhost);
			}
			IDynamicDataSource dataSource = new IDynamicDataSource();
			dataSource.setTargetDataSources(sourceMap);
			dataSource.setDefaultTargetDataSource(sourceMap.get("u6"));
			logger.info("注入动态数据源成功 dataSource:${dataSource}".replace("${dataSource}", dataSource.toString()));
			return dataSource;
		}
	}
}
