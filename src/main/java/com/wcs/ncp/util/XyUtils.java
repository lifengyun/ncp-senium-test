package com.wcs.ncp.util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XyUtils extends PublicUtils{

	public XyUtils(WebDriver webDriver) {
		super(webDriver);
	}
	

	public static String add(){
		
		LogUtils.write("开始添加协议");
		//进入菜单
		initMenu("协议管理", "收购协议管理", "添加收购协议");
		//供应商
	    setInputValueById("VendorId_input","9040013557");
	    waitForElementClickable(By.cssSelector(".ui-autocomplete-query"));
		//协议类型
		setSelectValueById("agreementType", "普通协议");
		//采购组类型
		setSelectValueById("purchaseGroupType", "协议不导入");
		//采购组
		setSelectValueById("purchaseGroup", "SZC---协议不导入");
		//多单合并计算
		waitForElementClickable(By.id("qcResultId"));
		//票据类型
		setSelectValueById("notyTypeId", "增票");
		//保存
		waitForElementClickable(By.id("purchaseArgAdd"));
	    //获取协议号
	    String no = getSaveMsg(By.cssSelector("#phurseAgedit > span.ui-message-info-detail"));
	    LogUtils.write(no + "\r\n");
	    no = no.substring(no.indexOf("为 ") + 1);
	    return no;
	}
	
	public static void addItem(){
		LogUtils.write("开始添加协议项目");
		//添加协议项目
		waitForElementClickable(By.id("addagreeitenByAdd"));
		//saveagItemByEdit
		//物料
//		setSelect2Value("国产髙筋白皮冬小麦普麦(6.0220331 其它)");
//		
		waitForElementClickable(By.cssSelector("#agreeItemAddEdit > div.style1 > table:nth-child(1) > tbody > tr > td.column2 > div"));
		waitForElementClickable(By.cssSelector("body > div.select2-drop.select2-drop-active.select2-with-searchbox > div > input"));
		driver.findElement(By.cssSelector("body > div.select2-drop.select2-drop-active.select2-with-searchbox > div > input")).sendKeys("国产髙筋白皮冬小麦普麦(6.0220331 其它)");
		waitForElementClickable(By.cssSelector("body > div.select2-drop.select2-drop-active.select2-with-searchbox > ul > li > div"));
		
		//数量
		setInputValueById("Itemquantity", "10000");
		//税码
		setSelectValueById("taxCode", "D3-进项税(免税项目)");
		//合同基准单价
		setInputValueById("contractBasePrice", "2000");
		//何方为准
		waitForElementClickable(By.id("whois:0"));
		//结算方式
		waitForElementClickable(By.id("qcResult:0"));
		//应付条款
		setSelectValueById("zterm", "D000--立即付款");
		//交货日期
		chooseCurrentDate("date");
		//装运类型
		setSelectValueById("shipmentType", "A 送到");
		//运输方式
		setSelectValueById("transportType", "B 汽车");
		//采购渠道
		setSelectValueById("purchaseType", "GN 国内采购");
		//支付方式
		setSelectValueById("payType", "A  支票");
		//保存
		waitForElementClickable(By.id("btn_agreementItem_Save"));
		
		//保存信息
	    String no = getSaveMsg(By.cssSelector("#phurseAgedit > span.ui-message-info-detail"));
	    LogUtils.write(no + "\r\n");
	}
	
	public static void addNotice(){
		LogUtils.write("开始添加协议价格通知单");
		//价格通知单
		waitForElementClickable(By.linkText("价格通知单"));
		//添加
		waitForElementClickable(By.cssSelector("#agreeItemTabviewId > div > div:nth-child(4) > div > div > button:nth-child(1)"));
		
		//有效范围
		chooseCurrentDate("calendar_start_id");
		//抽检参与结算
		setSelectValueById("inBilling", "不参与");
		//价格单提交审核
		waitForElementClickable(By.id("notice_add_doc_id2"));
		//协议提交审核
		waitForElementClickable(By.id("purchaseSubmitAudit"));
		
		//保存信息
	    String no = getSaveMsg(By.cssSelector("#reviewSumit > span.ui-message-info-detail"));
	    LogUtils.write(no + "\r\n");
	}
	
	
	
}
