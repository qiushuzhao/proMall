package com.city.promall.annotation.log;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.city.promall.util.ClientIPUtils;
import com.city.promall.util.StringTools;
import com.google.gson.Gson;

/**
 * 
 * @author yf
 *
 */
@Component
@Aspect
public class LogAop
{
	@Pointcut("@annotation(com.city.promall.annotation.log.Log)")
	private void cut() { }    
	
	@Before("cut()")
	public void advice(JoinPoint joinPoint){
		try
		{
			SysLogBean logBean=new SysLogBean();
			MethodSignature signature = (MethodSignature) joinPoint.getSignature();
			// 请求的方法名
			String className = joinPoint.getTarget().getClass().getName();
			String methodName = signature.getName();
			logBean.setMethod(className + "." + methodName + "()");
			// 请求的参数
			Object[] args = joinPoint.getArgs();
			if(!StringTools.isArrayEmpty(args)){
				Gson gson = new Gson();
				String params = gson.toJson(args[0]);
				logBean.setParams(params);
			}
			//获取request
			HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			String clientIp = ClientIPUtils.getClientIp(request);
			logBean.setIp(clientIp);
			logBean.setCreateDate(new Date());
			System.out.println(logBean.toString());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	} 
}
