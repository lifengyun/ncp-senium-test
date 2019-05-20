package com.wcs.ncp.util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WeightUtils extends PublicUtils {

	public WeightUtils(WebDriver webDriver) {
		super(webDriver);
	}

	public static void setSelect2Value(String value) {
		waitForElementClickable(By.cssSelector("a.select2-choice"));
		driver.findElement(By.xpath("/html/body/div[10]/div/input")).click();
		driver.findElement(By.xpath("/html/body/div[10]/div/input")).clear();
		driver.findElement(By.xpath("/html/body/div[10]/div/input")).sendKeys(value);
		waitForElementClickable(By.xpath("//div[@class='select2-result-label']/span"));

	}
	
	/**
	 * 添加重磅
	 * @param entranceDocNo
	 * @throws InterruptedException 
	 */
	public static void addFirstWeight(String entranceDocNo) {
		LogUtils.write("开始添加重磅");
		//进入菜单
		initMenu("现场收购", "地磅单管理", "添加地磅单(按入场单)");
		//输入场单号
		setInputValueById("inputWeightBridegeEnteranNo_input", entranceDocNo);
		waitForElementClickable(By.cssSelector(".ui-autocomplete-query"));
		//选择库存地
		setSelect2Value("0060");
		//输入重磅磅重
		setInputValueById("weightRead", "2050");
		//保存
		waitForElementClickable(By.id("btn_weightBridgeDoc_Save"));
		
		//获取地磅单号
	    String no = getSaveMsg(By.xpath("//*[@id='listMessage']/div/ul/li[2]/span"));
	    LogUtils.write(no + "\r\n");
	}
	
	/**
	 * 添加轻磅
	 * @param entranceDocNo
	 */
	public static String addSecondWeight(String entranceDocNo) {
		LogUtils.write("开始添加轻磅");
		//进入菜单
		initMenu("现场收购", "地磅单管理", "添加地磅单(按入场单)");
		//输入场单号
		setInputValueById("inputWeightBridegeEnteranNo_input", entranceDocNo);
		waitForElementClickable(By.cssSelector(".ui-autocomplete-query"));
		//选择库存地
		setSelect2Value("0060");
		//选择收购单
		waitForElementClickable(By.cssSelector(".style1 > div"));
		waitForElementClickable(By.xpath("//*[@id='sgNo']/option[2]"));
		//是否最后一次卸货
		setSelectValueById("isfinishedXh", "是");
		//输入轻磅磅重
		setInputValueById("weightRead", "50");
		//保存
		waitForElementClickable(By.id("btn_weightBridgeDoc_Save"));
		//获取地磅单号
	    String no = getSaveMsg(By.xpath("//*[@id='listMessage']/div/ul/li[2]/span"));
	    LogUtils.write(no + "\r\n");
	    no = no.substring(no.indexOf("：") + 1);
	    return no;
	}

	
	public static String addSecondWeightWithOhterWeight(String entranceDocNo) {
		LogUtils.write("开始添加轻磅");
		//进入菜单
		initMenu("现场收购", "地磅单管理", "添加地磅单(按入场单)");
		//输入场单号
		setInputValueById("inputWeightBridegeEnteranNo_input", entranceDocNo);
		waitForElementClickable(By.cssSelector(".ui-autocomplete-query"));
		//选择库存地
		setSelect2Value("0060");
		//选择收购单
		waitForElementClickable(By.cssSelector(".style1 > div"));
		waitForElementClickable(By.xpath("//*[@id='sgNo']/option[2]"));
		//是否最后一次卸货
		setSelectValueById("isfinishedXh", "是");
		//对方磅重
		setInputValueById("dbOtherWeight", "2000");
		//输入轻磅磅重
		setInputValueById("weightRead", "50");
		//保存
		waitForElementClickable(By.id("btn_weightBridgeDoc_Save"));
		//获取地磅单号
	    String no = getSaveMsg(By.xpath("//*[@id='listMessage']/div/ul/li[2]/span"));
	    LogUtils.write(no + "\r\n");
	    no = no.substring(no.indexOf("：") + 1);
	    return no;
	}
	
	public static String addSecondWeightWithOhterWeightYCDD(String entranceDocNo,String weight,String sgNo,String lastWeight) {
		LogUtils.write("开始添加轻磅");
		//进入菜单
		initMenu("现场收购", "地磅单管理", "添加地磅单(按入场单)");
		//输入场单号
		setInputValueById("inputWeightBridegeEnteranNo_input", entranceDocNo);
		waitForElementClickable(By.cssSelector(".ui-autocomplete-query"));
		//选择库存地
		setSelect2Value("0060");
		//选择收购单
		waitForElementClickable(By.cssSelector(".style1 > div"));
		waitForElementClickable(By.xpath("//*[@id='sgNo']/option["+sgNo+"]"));
		//是否最后一次卸货
		setSelectValueById("isfinishedXh", lastWeight);
		//对方磅重
		setInputValueById("dbOtherWeight", "1000");
		//输入轻磅磅重
		setInputValueById("weightRead", weight);
		//保存
		waitForElementClickable(By.id("btn_weightBridgeDoc_Save"));
		//获取地磅单号
	    String no = getSaveMsg(By.xpath("//*[@id='listMessage']/div/ul/li[2]/span"));
	    LogUtils.write(no + "\r\n");
	    no = no.substring(no.indexOf("：") + 1);
	    return no;
	}
}
