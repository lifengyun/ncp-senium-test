package com.wcs.ncp.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BillingUtils extends PublicUtils{

	public BillingUtils(WebDriver webDriver) {
		super(webDriver);
	}
	
	/**
	 * 添加结算单 
	 * @param entranceDocNo
	 */
	public static String addBillingDoc(String entranceDocNo){
		LogUtils.write("开始添加结算单");
		//进入菜单
	    initMenu("现场收购", "结算", "添加结算单(按入场单)");
	    //输入入场单号
	    setInputValueById("entranceDocNo_input",entranceDocNo); 
	    waitForElementClickable(By.cssSelector(".ui-autocomplete-query"));
	    //点击读取入场单号
	    waitForElementClickable(By.id("readEntranceNo"));
	    //点击结算
	    waitForElementClickable(By.id("doBill"));
	    //获取结算单号
	    String no = getSaveMsg(By.xpath("//*[@id='doneMsg']/div/ul/li/span"));
	    LogUtils.write(no + "\r\n");
	    no = no.substring(no.indexOf("[") + 1, no.indexOf("]"));
	    return no;
	    
	}
	
}
