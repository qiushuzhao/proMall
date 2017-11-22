package com.city.promall.util;

import java.util.List;

import com.city.promall.contants.ErrorCode;

public class RspListBean
{
	private String count = "";

	private String code = "";
	private String desc = "";

	private List<?> listInfo = null;

	public String getCount()
	{
		return count;
	}

	public void setCount(String count)
	{
		this.count = count;
	}

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

	public List<?> getListInfo()
	{
		return listInfo;
	}

	public void setListInfo(List<?> listInfo)
	{
		this.listInfo = listInfo;
	}

	public RspListBean()
	{
		this.code = ErrorCode.SUCCESS.getCode();
		this.desc = ErrorCode.SUCCESS.getDesc();
	}

	public RspListBean(String code, String desc)
	{
		this.code = code;
		this.desc = desc;
	}
}
