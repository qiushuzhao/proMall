package com.city.promall.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

public class StringTools
{
	/**
	 * 字符串去首尾空格
	 */
	public static String removeSpace(String str)
	{
		if (StringTools.isNullOrEmpty(str))
		{
			return "";
		}
		return str.trim();
	}

	/**
	 * 判断字符串非空
	 * 
	 * @Description:当字符串为空返回true
	 */
	public static boolean isNullOrEmpty(String str)
	{
		if (null == str || "".equals(str.trim()) || "null".equals(str.trim()))
		{
			return true;
		}
		return false;
	}

	/**
	 * 判断对象是否为空
	 * 
	 * @Description:当字符串为空返回true
	 */
	public static boolean isNullOrEmpty(Object obj)
	{
		if (null == obj || "".equals(obj))
		{
			return true;
		}
		return false;
	}

	/**
	 * 将字符串转换成Integer
	 * 
	 * @Description: 字符串为空或非数字返回0
	 */
	public static int parseStr2Int(String str)
	{
		int num = 0;
		try
		{
			if (StringTools.isNullOrEmpty(str))
			{
				return 0;
			}
			num = Integer.parseInt(StringTools.removeSpace(str));
		}
		catch (NumberFormatException e)
		{
			return 0;
		}
		return num;
	}

	/**
	 * 截取字符串
	 * @Description:按规定的长度截取字符串，过长部分用“...”表示
	 * @param str
	 *            需要截取的字符串
	 * @param length
	 *            需要被截取的长度
	 */
	public static String cutOutString(String str, int length)
	{
		str = StringTools.removeSpace(str);
		String newStr = str;
		if (StringTools.isNullOrEmpty(str))
		{
			return "";
		}

		if (str.length() > length)
		{
			newStr = str.substring(0, length) + "...";
		}
		return newStr;
	}

	/**
	 * 字符串编码转换的实现方法
	 */
	public String changeCharset(String str, String newCharset)
			throws UnsupportedEncodingException
	{
		if (str != null)
		{
			// 用默认字符编码解码字符串。
			byte[] bs = str.getBytes();
			// 用新的字符编码生成字符串
			return new String(bs, newCharset);
		}
		return null;
	}

	/**
	 * 元转换成分
	 * @Description:把元转换成分，保留两位小数
	 */
	public static String yuanToFen(String yuan)
	{
		String yuanStr = "";

		String currency = yuan.replaceAll("\\$|\\￥|\\,", ""); // 处理包含, ￥ 或者$的金额
		int index = currency.indexOf(".");
		int length = currency.length();
		BigDecimal amBig = null;
		if (index == -1)
		{
			amBig = new BigDecimal(currency + "00");
		}
		else if (length - index >= 3)
		{
			amBig = new BigDecimal((currency.substring(0, index + 3)).replace(
					".", ""));
		}
		else if (length - index == 2)
		{
			amBig = new BigDecimal((currency.substring(0, index + 2)).replace(
					".", "") + 0);
		}
		else
		{
			amBig = new BigDecimal((currency.substring(0, index + 1)).replace(
					".", "") + "00");
		}
		yuanStr = amBig.toString();
		return yuanStr;
	}

	/**
	 * @Description:将分转化为元
	 */
	public static String changeFToY(String amount)
	{
		if (StringTools.isNullOrEmpty(amount))
		{
			amount = "0";
		}
		int sz = amount.length();
		for (int i = 0; i < sz; i++)
		{
			if (Character.isDigit(amount.charAt(i)) == false)
			{
				return amount = new BigDecimal(amount)
						.divide(new BigDecimal(100)).setScale(4).toString();
			}
		}
		return amount = new BigDecimal(amount).divide(new BigDecimal(100))
				.setScale(2).toString();
	}

	/**
	 * @Description: 过滤特殊有问题字符，转换成*
	 */
	public static String checkString(String str)
	{
		return str
				.replaceAll(
						"[^a-zA-Z0-9_\u4E00-\u9FA5 `\\-=~!@#$&*()_+,.!?，。、？！;'{}:：；‘’、“”\\[\\]\"/\\\\……《》<>·【】——°]",
						"*");
	}

	/**
	 * 校验图片是否以http开头，是则不需要拼接服务器地址
	 */
	public static String checkBeginWith(String pic, String parameter)
	{
		if (StringTools.isNullOrEmpty(pic))
		{
			return "";
		}

		int index = pic.indexOf("http://");
		int index1 = pic.indexOf("HTTP://");
		if (index == 0)
		{
			return pic;
		}
		else if (index1 == 0)
		{
			return pic;
		}
		else
		{
			return parameter + pic;

		}

	}
	/**
	 * 判断数组是否为空
	 * @param array
	 * @return
	 */
	public static boolean isArrayEmpty(Object[] array) {
        return (array == null || array.length == 0);
    }
}
