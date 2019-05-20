package com.wcs.ncp.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelenimuManager {

	public static void loginWithUser(WebDriver driver) {
		new PublicUtils(driver);
		// 登录
		driver.get("https://cmdpmstest.wilmar.cn/cmdpms/");
		PublicUtils.setInputValueById("username", "lifengyun");
		PublicUtils.setInputValueById("password", "Cas.qas");
		PublicUtils.waitForElementClickable(By.name("submit"));
	}
}
