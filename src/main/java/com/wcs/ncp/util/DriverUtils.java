package com.wcs.ncp.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverUtils {
	
	public static WebDriver getWebDriver(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/lifengyun/Desktop/chromeDriver/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","/opt/chromedriver");
		// 声明chrome options，添加配置
		ChromeOptions options = new ChromeOptions();
		//设置浏览器最大化
		options.addArguments("--start-maximized");
		//options.addArguments("--headless");
		//options.setHeadless(true);
		// 实例化时加上配置
		WebDriver driver = new ChromeDriver(options); 
		return driver;
	}

}
