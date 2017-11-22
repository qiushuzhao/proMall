package com.city.promall.annotation.log;

import java.util.Date;

/**
 * 日志类
 * @author yf
 *
 */
public class SysLogBean
{
	/**
	 * 请求方法
	 */
	private String method;
	/**
	 * 请求参数
	 */
	private String params;
	/**
	 * 返回结果
	 */
	private String rsp;
	/**
	 * ip
	 */
	private String ip;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	public Date getCreateDate()
	{
		return createDate;
	}
	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}
	public String getMethod()
	{
		return method;
	}
	public void setMethod(String method)
	{
		this.method = method;
	}
	public String getParams()
	{
		return params;
	}
	public void setParams(String params)
	{
		this.params = params;
	}
	public String getRsp()
	{
		return rsp;
	}
	public void setRsp(String rsp)
	{
		this.rsp = rsp;
	}
	public String getIp()
	{
		return ip;
	}
	public void setIp(String ip)
	{
		this.ip = ip;
	}
	@Override
	public String toString()
	{
		return "SysLogBean [method=" + method + ", params=" + params + ", rsp="
				+ rsp + ", ip=" + ip + ", createDate=" + createDate + "]";
	}
	
}
