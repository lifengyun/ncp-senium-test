package com.wcs.ncp.util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QcDocUtils extends PublicUtils{

	public QcDocUtils(WebDriver webDriver) {
		super(webDriver);
	}
	
	/**
	 * 添加质检单
	 * @param entranceDocNo
	 * @throws InterruptedException 
	 */
	public static String addQcDoc(String entranceDocNo) {
		LogUtils.write("开始添加质检单");
		//进入菜单
	    initMenu("现场收购", "抽样/质检", "添加质检单(按入场单)");
	    //输入入场单号
	    setInputValueById("enteranNo_input",entranceDocNo);
	    waitForElementClickable(By.cssSelector(".ui-autocomplete-query"));
	    //点击读取入场单按钮
	    waitForElementClickable(By.id("btn_qcDoc_searchItem"));
	    //设置抽样员
	    setInputValueById("labInspector","抽样员");
	    //设置样品来源
	    setSelectValueById("sampleFrom", "汽车");
	    
	    //设置指标检验结果
	    setInputValueById("indMaterialTable:0:resultVal","1");
	    setInputValueById("indMaterialTable:1:resultVal","1");
	    setInputValueById("indMaterialTable:2:resultVal","800");
	    setSelectValueById("indMaterialTable:3:resultValText", "大");
	    
	    //点击保存按钮
	    waitForElementClickable(By.id("add_qc_save_before_lock"));	 
	    //获取质检单号
	    String qcDocNo = getSaveMsg(By.xpath("//*[@id='addErrs']/div/ul/li[3]/span"));
	    LogUtils.write(qcDocNo + "\r\n");
	    qcDocNo = qcDocNo.substring(qcDocNo.indexOf("：") + 1);
	    return qcDocNo;
	}
	
}
