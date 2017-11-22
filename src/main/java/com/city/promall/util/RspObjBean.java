package com.city.promall.util;

import com.city.promall.contants.ErrorCode;
/**
 * 
 * @author 邱述照
 *
 */
public class RspObjBean
{
	private String code = "";

	private String desc = "";

	private Object info = null;

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public Object getInfo()
	{
		return info;
	}

	public void setInfo(Object info)
	{
		this.info = info;
	}

	public RspObjBean()
	{
		this.code = ErrorCode.SUCCESS.getCode();
		this.desc = ErrorCode.SUCCESS.getDesc();
	}

	public RspObjBean(String code, String desc)
	{
		this.code = code;
		this.desc = desc;
	}
}
