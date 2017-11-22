package com.city.promall.entity;
/**
 * 测试entity
 * @author yf
 *
 */
public class TestEntity
{

	private String name;

	private String id;

	public TestEntity(String name, String id)
	{
		super();
		this.name = name;
		this.id = id;
	}

	public TestEntity()
	{
		super();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	@Override
	public String toString()
	{
		return "TestEntity [name=" + name + ", id=" + id + "]";
	}

}
