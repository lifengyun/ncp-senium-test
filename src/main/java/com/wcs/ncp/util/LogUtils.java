package com.wcs.ncp.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

public class LogUtils {
	
	static BufferedWriter bw = null;
	static FileWriter fw = null;
	static WebDriver wd = null;
	
	public static void init(String testName) throws IOException{
		
		if(wd == null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HH-mm-ss");
	        String path = "C:\\Users\\lifengyun\\Desktop\\Ncp-Selenium-Log\\" + testName + "" + sdf.format(new Date()) + ".txt";
	        //String path = "/opt/selenium/logs/" + testName + "" + sdf.format(new Date()) + ".txt";
	        File file = new File(path);
	        if(!file.exists()){
	            file.getParentFile().mkdirs();          
	        }
	        file.createNewFile();
	        fw = new FileWriter(file, true);
	        bw = new BufferedWriter(fw);
	        //获取浏览器驱动
			wd = DriverUtils.getWebDriver();
			//登录
			SelenimuManager.loginWithUser(wd);
			//选择工厂
			PublicUtils.chooseCompany();
		}
		if(!"测试日志".equals(testName)){
			write("---------------------------------" + testName + "------------------------------------" );
		}
	}
	
	
	public static void write(String str){
		try {
			bw.write(str + "\r\n");
		} catch (IOException e) {
		}
	}
	
	public static void writeChangeLine(String str){
		try {
			bw.write(str + "\r\n\r\n");
		} catch (IOException e) {
		}
	}
	
	public static void closeIO(){
		try {
			LogUtils.write("---------------------------------测试结束------------------------------------" );
			if(bw != null){
			    bw.flush();
			    bw.close();
			}
			
			if(fw != null ){
			    fw.close();
			}
			
			if(wd != null){
				wd.quit();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
