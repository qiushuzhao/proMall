package com.city.promall.controller;

import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.city.promall.annotation.log.Log;
import com.city.promall.contants.ErrorCode;
import com.city.promall.entity.TestEntity;
import com.city.promall.util.RspObjBean;

/**
 * 测试
 * @author yf
 *
 */
@RestController
public class TestController
{

	private Logger log = Logger.getLogger(TestController.class);
	
	@RequestMapping(value="/test",method=RequestMethod.POST)
	@ApiOperation(value="测试接口", notes="测试接口详细描述")
	public RspObjBean getTest(@RequestBody @Valid TestEntity testEntity,BindingResult bindingResult){
		
		RspObjBean bean=new RspObjBean();
		
		// 参数校验
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return new RspObjBean(ErrorCode.PARAM_NULL_ERROR.getCode(), fieldError.getDefaultMessage());
		}
		try
		{
			TestEntity t=new TestEntity(testEntity.getName(),testEntity.getId());
			bean.setInfo(t);
		}
		catch (Exception e)
		{
			log.error("查询失败", e);
			return new RspObjBean(ErrorCode.ERROR_SQL_DESC.getCode(), ErrorCode.ERROR_SQL_DESC.getDesc());
		}
		
		return bean;
	}
	
	@GetMapping("/qiu")
	@Log()
	@ApiOperation(value="测试接口", notes="测试接口详细描述")
	public String get(String id){
		return "Hello,world"+id;
	}
}
