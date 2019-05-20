package com.wcs.ncp.util;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class EntranceUtils extends PublicUtils{

	public EntranceUtils(WebDriver webDriver) {
		super(webDriver);
	}
	
	/**
	 * 添加挂牌入场单
	 * @return 入场单号
	 * @throws InterruptedException 
	 */
	public static String addGPEntrance(String flow,String material){
		LogUtils.write("开始添加挂牌入场单");
		//进入菜单
		System.out.println("进入菜单");
		initMenu("现场收购", "出/入场登记", "添加入场单");
		// 输入司机姓名
		System.out.println("输入司机姓名");
		setInputValueById("entranceDoc_driverName", "司机1");
		// 输入手机号码
		setInputValueById("entranceDoc_driverTelephoneNo","18888888888");
		// 输入车号
		setInputValueById("entranceDoc_vehicleNo", "沪A9527");
		// 选择农产品收购类型
		setSelectValueById("entranceDoc_purchaseFlow", flow);
		// 选取物料
		setSelect2Value(material);
		// 添加物料
		waitForElementClickable(By.id("org_matierial_id"));
		// 保存
		waitForElementClickable(By.id("btn_entranceDoc_Save"));
		//获取生成的入场单号
	    String entranceDocNo = getSaveMsg(By.xpath("//*[@id='msgs']/div/ul/li/span"));
	    //打印添加入场单信息
	    LogUtils.write(entranceDocNo + "\r\n");
	    entranceDocNo = entranceDocNo.substring(entranceDocNo.indexOf("【") + 1, entranceDocNo.indexOf("】"));
	    return entranceDocNo;
	}
	
	/**
	 * 添加协议入场单
	 * @return
	 */
	public static String addXYEntranceSingleTest(String flow){
		LogUtils.write("开始添加协议入场单");
		//进入菜单
		initMenu("现场收购", "出/入场登记", "添加入场单");
		// 输入司机姓名
		setInputValueById("entranceDoc_driverName", "测试");
		// 输入手机号码
		setInputValueById("entranceDoc_driverTelephoneNo","18888888888");
		// 输入车号
		setInputValueById("entranceDoc_vehicleNo", "沪A9527");
		// 选择农产品收购类型
		setSelectValueById("entranceDoc_purchaseFlow", flow);
		//保存入场单
		waitForElementClickable(By.id("btn_entranceDoc_Save"));
		//关联收购单
		waitForElementClickable(By.id("purchaseDocItem_Id"));
		//选择物料
		setSelectValueById("orgMaterialId", "国产髙筋白皮冬小麦普麦(6.0220331 其它)");
		//清空开始时间
		clearDate("startDate");
		//点击查询
		waitForElementClickable(By.cssSelector("#purchaseDocItemDlg > div.ui-dialog-content.ui-widget-content > div > div > button:nth-child(2)"));
		
		//选中第一行
		waitForElementClickable(By.cssSelector("#purchaseDocItemTable > div > table > tbody > tr:nth-child(1)"));
		//保存
		waitForElementClickable(By.cssSelector("button[id $='btn_purchaseDocItem_save']"));
		
		//获取生成的入场单号
	    String entranceDocNo = getSaveMsg(By.cssSelector("#msgs > div > ul > li:nth-child(2) > span"));
	    //打印添加入场单信息
	    LogUtils.write(entranceDocNo + "\r\n");
	    entranceDocNo = entranceDocNo.substring(entranceDocNo.indexOf("RC"), entranceDocNo.indexOf("步骤"));
	    System.out.println(entranceDocNo);
	    return entranceDocNo;
	}
	
	public static String addXYEntranceYCDD(String flow){
		LogUtils.write("开始添加一车多单入场单");
		//进入菜单
		initMenu("现场收购", "出/入场登记", "添加入场单");
		// 输入司机姓名
		setInputValueById("entranceDoc_driverName", "测试");
		// 输入手机号码
		setInputValueById("entranceDoc_driverTelephoneNo","18888888888");
		// 输入车号
		setInputValueById("entranceDoc_vehicleNo", "沪A9527");
		// 选择农产品收购类型
		setSelectValueById("entranceDoc_purchaseFlow", flow);
		//保存入场单
		waitForElementClickable(By.id("btn_entranceDoc_Save"));
		//关联收购单
		waitForElementClickable(By.id("purchaseDocItem_Id"));
		//选择物料
		setSelectValueById("orgMaterialId", "国产髙筋白皮冬小麦普麦(6.0220331 其它)");
		//清空开始时间
		clearDate("startDate");
		//点击查询
		waitForElementClickable(By.cssSelector("#purchaseDocItemDlg > div.ui-dialog-content.ui-widget-content > div > div > button:nth-child(2)"));
		//选中前两个
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).perform();
		waitForElementClickable(By.cssSelector("#purchaseDocItemTable > div > table > tbody > tr:nth-child(1)"));
		waitForElementClickable(By.cssSelector("#purchaseDocItemTable > div > table > tbody > tr:nth-child(2)"));
		actions.keyUp(Keys.CONTROL).perform();
		//保存
		waitForElementClickable(By.cssSelector("button[id $='btn_purchaseDocItem_save']"));
		
		//获取生成的入场单号
	    String entranceDocNo = getSaveMsg(By.cssSelector("#msgs > div > ul > li:nth-child(2) > span"));
	    //打印添加入场单信息
	    LogUtils.write(entranceDocNo + "\r\n");
	    entranceDocNo = entranceDocNo.substring(entranceDocNo.indexOf("RC"), entranceDocNo.indexOf("步骤"));
	    System.out.println(entranceDocNo);
	    return entranceDocNo;
	}
	
	public static String addXYEntranceDoubleTest(String flow){
		LogUtils.write("开始添加协议入场单");
		//进入菜单
		initMenu("现场收购", "出/入场登记", "添加入场单");
		// 输入司机姓名
		setInputValueById("entranceDoc_driverName", "测试");
		// 输入手机号码
		setInputValueById("entranceDoc_driverTelephoneNo","18888888888");
		// 输入车号
		setInputValueById("entranceDoc_vehicleNo", "沪A9527");
		// 选择农产品收购类型
		setSelectValueById("entranceDoc_purchaseFlow", flow);
		//保存入场单
		waitForElementClickable(By.id("btn_entranceDoc_Save"));
		//关联收购单
		waitForElementClickable(By.id("purchaseDocItem_Id"));
		//选择物料
		setSelectValueById("orgMaterialId", "国产高筋白皮冬小麦优9023(6.0220304 其它)");
		//清空开始时间
		clearDate("startDate");
		//点击查询
		waitForElementClickable(By.cssSelector("#purchaseDocItemDlg > div.ui-dialog-content.ui-widget-content > div > div > button:nth-child(2)"));
		//选中第一行
		waitForElementClickable(By.cssSelector("#purchaseDocItemTable > div > table > tbody > tr:nth-child(1)"));
		//保存
		waitForElementClickable(By.cssSelector("button[id $='btn_purchaseDocItem_save']"));
		
		//获取生成的入场单号
	    String entranceDocNo = getSaveMsg(By.cssSelector("#msgs > div > ul > li:nth-child(2) > span"));
	    //打印添加入场单信息
	    LogUtils.write(entranceDocNo + "\r\n");
	    entranceDocNo = entranceDocNo.substring(entranceDocNo.indexOf("RC"), entranceDocNo.indexOf("步骤"));
	    System.out.println(entranceDocNo);
	    return entranceDocNo;
	}
	
	

	
}
