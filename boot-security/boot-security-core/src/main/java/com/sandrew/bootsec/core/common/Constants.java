package com.sandrew.bootsec.core.common;

public interface Constants
{
	public static String LOGIN_USER = "loginUser"; // 登录用户
	public static String APP_KEY = "authc.appKey"; // appKey

	public static Integer STATUS_ENABLE = new Integer("10011001"); //有效
	public static Integer STATUS_DISABLE = new Integer("10011002"); //无效
	public static Integer SEX_MALE = new Integer("10021001"); //男
	public static Integer SEX_FEMALE = new Integer("10021002"); //女
	public static Integer SEX_UNKNOW = new Integer("10021003"); //未知
	public static Integer IF_TYPE_YES = new Integer("10031001"); //是
	public static Integer IF_TYPE_NO = new Integer("10031002"); //否
	public static Integer ACCESS_TYPE_LOGIN = new Integer("10041001"); //登录
	public static Integer ACCESS_TYPE_LOGOUT = new Integer("10041002"); //登出
	public static Integer PROJECT_STATUS_OPENED = new Integer("20011001"); //开放期
	public static Integer PROJECT_STATUS_CLOSED = new Integer("20011002"); //关闭期
	public static Integer SALE_STATUS_UNCONFIRM = new Integer("20021001"); //未确认
	public static Integer SALE_STATUS_CONFIRM = new Integer("20021002"); //已确认
	public static Integer SALE_STATUS_CANCEL = new Integer("20021003"); //已取消
	public static Integer CARD_TYPE_ID = new Integer("20031001"); //身份证
	public static Integer CARD_TYPE_PASSPORT = new Integer("20031002"); //护照
	public static Integer CARD_TYPE_OFFICER = new Integer("20031003"); //军官证
	Integer UPDATE_TYPE_YES= new Integer("30011001");//需要升级
	Integer UPDATE_TYPE_NO= new Integer("30011002");//不需要升级
}
