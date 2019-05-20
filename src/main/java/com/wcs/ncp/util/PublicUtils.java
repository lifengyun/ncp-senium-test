package com.wcs.ncp.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PublicUtils {
	
    protected static WebDriver driver =null;
    
    public PublicUtils(WebDriver webDriver) {
    	driver=webDriver;
	}
    
	/**
	 * 选择工厂
	 */
	public static void chooseCompany(){
		setSelectValueById("qwer", "系统测试");
	}
    
	/**
	 * method 初始化菜单
	 * @param lv1menu 一级菜单
	 * @param lv2menu 二级菜单
	 * @param lv3menu  三级菜单
	 */
	public static void initMenu(String lv1menu, String lv2menu, String lv3menu) {
		waitForElementClickable(By.linkText(lv1menu));
		WebElement jiage = driver.findElement(By.linkText(lv2menu));
		Actions builder = new Actions(driver);
		Actions hoverOverRgeistrar = builder.moveToElement(jiage);
		hoverOverRgeistrar.perform();
		waitForElementClickable(By.linkText(lv3menu));
	}
	
	public static void initMenuByCssSelector(String lv1menu, String lv2menu, String lv3menuId) {
		waitForElementClickable(By.linkText(lv1menu));
		WebElement jiage = driver.findElement(By.linkText(lv2menu));
		Actions builder = new Actions(driver);
		Actions hoverOverRgeistrar = builder.moveToElement(jiage);
		hoverOverRgeistrar.perform();
		waitForElementClickable(By.cssSelector(lv3menuId));
	}
	
	
	public static void waitForElementClickable(final By by) {
		int i = 0;
		while (true) {
			if (i < 50) {
				try {
					driver.findElement(by).click();
				} catch (Exception e) {
					System.out.println("未获取到元素，休眠200毫秒之后，继续获取" + i);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					i++;
					continue;
				}
				return;
			} else {
				throw new RuntimeException("10秒钟之内获取元素失败！！！" + by.toString());
			}
		}
	}
	
	/**
	 * 根据id设置输入框内容
	 * @param id
	 * @param value
	 */
	public static void setInputValueById(String id, String value) {
		waitForElementClickable(By.id(id));
		WebElement we = driver.findElement(By.id(id));
		we.clear();
		we.sendKeys(value);
	}

	/**
	 * 根据id设置下拉框选中内容
	 * @param id
	 * @param value
	 */
	public static void setSelectValueById(String id, String value) {
		waitForElementClickable(By.id(id));
		new Select(driver.findElement(By.id(id))).selectByVisibleText(value);

	}
	
	/**
	 * 设置select2下拉框选中内容
	 * @param value
	 */
	public static void setSelect2Value(String value) {
		waitForElementClickable(By.cssSelector("a.select2-choice"));
		driver.findElement(By.xpath("/html/body/div[9]/div/input")).click();
		driver.findElement(By.xpath("/html/body/div[9]/div/input")).clear();
		driver.findElement(By.xpath("/html/body/div[9]/div/input")).sendKeys(value);
		waitForElementClickable(By.xpath("//div[@class='select2-result-label']/span"));

	}
	
	/**
	 * 清空时间
	 * @param id
	 */
	public static void clearDate(String id) {
		waitForElementClickable(By.id(id));
		driver.switchTo().frame(0);
		waitForElementClickable(By.id("dpClearInput"));
		driver.switchTo().defaultContent();
	}
	
	/**
	 * 选择当前时间
	 * @param id
	 */
	public static void chooseCurrentDate(String id) {
		waitForElementClickable(By.id(id));
		driver.switchTo().frame(0);
		waitForElementClickable(By.id("dpOkInput"));
		driver.switchTo().defaultContent();
	}
	
	
	
	
	/**
	 * 获取保存之后的信息
	 * @param path
	 * @return
	 */
	public static String getSaveMsg(By by) {
		waitForElementClickable(by);
		String num = driver.findElement(by).getText();
		return num;

	}
	
	public static void setVendorById(String id,String VendorCode){
	    setInputValueById(id,VendorCode);
	    waitForElementClickable(By.cssSelector(".ui-autocomplete-query"));
	    waitForElementClickable(By.cssSelector(".ui-state-highlight"));
	    waitForElementClickable(By.cssSelector(".style1"));
	}
	
}
