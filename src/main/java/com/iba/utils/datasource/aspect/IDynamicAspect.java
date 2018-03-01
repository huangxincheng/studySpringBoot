package com.iba.utils.datasource.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.iba.utils.datasource.IDynamicDataSource;
import com.iba.utils.datasource.annotation.IDynamicAnnotation;


@Aspect
@Order(-9999)
@Component
public class IDynamicAspect {

	private static final Logger logger = LoggerFactory.getLogger(IDynamicAspect.class);
	
	@Pointcut("execution(* com.iba.service.*.*(..))")
	public void aspectMethod() {}
	
	/**
     * 在进入Service方法之前执行
     * @param point 切面对象
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     */
	@Before(value = "aspectMethod()")
    public void before(JoinPoint point) throws NoSuchMethodException, SecurityException {
    	MethodSignature methodSignature = (MethodSignature) point.getSignature();  
    	Method method = methodSignature.getMethod(); 
    	handler(method, point.getTarget().getClass());
    }
    
    
    private void handler(Method method, Class<?> clazz) throws NoSuchMethodException, SecurityException {
    	String key = null;
    	//判断被代理的对象是否有 DynamicDataSourceRouting注解
    	method = clazz.getDeclaredMethod(method.getName(), method.getParameterTypes());
    	if (method.isAnnotationPresent(IDynamicAnnotation.class)) {
    		key = method.getAnnotation(IDynamicAnnotation.class).value();
    	} else {
    		if(clazz.isAnnotationPresent(IDynamicAnnotation.class)) {
    			key = clazz.getAnnotation(IDynamicAnnotation.class).value();
    		} 
    	}
    	logger.info("当前使用数据源别名:{}", key);
    	IDynamicDataSource.putDataSourceKey(key);
    }
}
