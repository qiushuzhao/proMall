package com.city.promall.contants;

public enum ErrorCode
{
	//请求参数为空
	PARAM_NULL_ERROR("00001","请求参数为空"),
	//成功
	SUCCESS("0","success"),
	//数据库异常
	ERROR_SQL_DESC("000002","网络不给力，请稍后重试");
	
	//错误码
	private String code;
	
	//错误描述
	private String desc;
	
	private ErrorCode(String code,String desc){
		this.code=code;
		this.desc=desc;
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
}
