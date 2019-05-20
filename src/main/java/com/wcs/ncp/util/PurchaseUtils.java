package com.wcs.ncp.util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PurchaseUtils extends PublicUtils{

	public PurchaseUtils(WebDriver webDriver) {
		super(webDriver);
	}
	
	/**
	 * 添加收购单
	 * @param entranceDocNo
	 * @throws InterruptedException 
	 */
	public static String addPurchaseDoc(String entranceDocNo,String vendorCode){
		LogUtils.write("开始添加收购单");
		//进入菜单
	    initMenu("现场收购", "收购单管理", "添加收购单(按入场单)");
	    //输入入场单号
	    setInputValueById("entranceDocNo_input",entranceDocNo);
	    waitForElementClickable(By.cssSelector(".ui-autocomplete-query"));
	    
	    //查询入场单
	    waitForElementClickable(By.id("search_id"));
	    //点击添加收购单按钮
	    waitForElementClickable(By.id("j_idt125:0:j_idt147"));
	    
	    //选择供应商
	    setVendorById("vendor_id_input",vendorCode);

	    //点击保存
	    waitForElementClickable(By.id("save_doc_link_id"));
	    
	    //获取收购单号  
	    String no = getSaveMsg(By.xpath("//*[@id='globalMess']/div/ul/li[2]/span"));
	    LogUtils.write(no + "\r\n");
	    no = no.substring(no.indexOf(":") + 1);
	    return no;
	    
	}

	
}
