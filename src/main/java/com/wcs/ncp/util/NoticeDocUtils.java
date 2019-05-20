package com.wcs.ncp.util;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NoticeDocUtils extends PublicUtils{

	public NoticeDocUtils(WebDriver webDriver) {
		super(webDriver);
	}
	
	
	public static String add(){
		
		LogUtils.write("开始添加价格通知单");
		//进入菜单
		initMenu("协议管理", "价格通知单管理", "添加价格通知单");
		//选择物料
		setSelect2Value("国产髙筋白皮冬小麦普麦(6.0220331 其它)");
		//选择币种
		setSelectValueById("currency_id", "CNY");
		//基准单价
		setInputValueById("base_price_id", "2000");
		//有效范围
		chooseCurrentDate("calendar_start_id");
		//是否参与结算
		setSelectValueById("inBilling", "不参与");
		//保存
		waitForElementClickable(By.id("notice_add_doc_id"));
		
		String no = getSaveMsg(By.cssSelector("#notice_doc_list_mess_id > span.ui-message-info-detail"));
		LogUtils.writeChangeLine(no);
		no = no.substring(no.indexOf("：") + 1);
		return no;
	}
	
	public static void view(String no){
		LogUtils.write("开始查看价格通知单详情");
		//进入菜单
		initMenuByCssSelector("协议管理", "价格通知单管理", "#M20202 > a");
		//输入价格通知单号
	    setInputValueById("notice_doc_no_id_input",no);
	    waitForElementClickable(By.cssSelector(".ui-autocomplete-query"));
	    //清空时间
	    clearDate("calendar_start_id");
	    //查询
	    waitForElementClickable(By.id("query_notice_id"));
	    //点击查看
	    waitForElementClickable(By.id("notice_list_id:0:detail_notice_id2"));
	    
	    //点击返回
	    waitForElementClickable(By.cssSelector("#notice_doc_model_id > div > div > button"));
	}
	
	public static void edit(String no){
		LogUtils.write("开始修改价格通知单");
		//进入菜单
		initMenuByCssSelector("协议管理", "价格通知单管理", "#M20202 > a");
		//输入价格通知单号
	    setInputValueById("notice_doc_no_id_input",no);
	    waitForElementClickable(By.cssSelector(".ui-autocomplete-query"));
	    //清空时间
	    clearDate("calendar_start_id");
	    //查询
	    waitForElementClickable(By.id("query_notice_id"));
	    //点击修改
	    waitForElementClickable(By.id("notice_list_id:0:edit_notice_id2"));
	    //提交审核
	    waitForElementClickable(By.id("notice_add_doc_id2"));
	    
	    String msg = getSaveMsg(By.cssSelector("#notice_doc_list_mess_id > span.ui-message-info-detail"));
	    LogUtils.writeChangeLine(msg);
	    
	}
	
	
	public static void cancelAudit(String no){
		LogUtils.write("开始修改价格通知单");
		//进入菜单
		initMenuByCssSelector("协议管理", "价格通知单管理", "#M20202 > a");
		//输入价格通知单号
	    setInputValueById("notice_doc_no_id_input",no);
	    waitForElementClickable(By.cssSelector(".ui-autocomplete-query"));
	    //清空时间
	    clearDate("calendar_start_id");
	    //查询
	    waitForElementClickable(By.id("query_notice_id"));
	    //点击撤销审核
	    waitForElementClickable(By.id("notice_list_id:0:revocation_notice_id"));
	    //确认
	    waitForElementClickable(By.id("revocationAgrId"));
	    
	    String msg = getSaveMsg(By.cssSelector("#notice_doc_list_mess_id > span.ui-message-info-detail"));
	    LogUtils.writeChangeLine(msg);
	    
	}
	
	
	public static void copy(String no){
		LogUtils.write("开始复制价格通知单");
		//进入菜单
		initMenuByCssSelector("协议管理", "价格通知单管理", "#M20202 > a");
		//输入价格通知单号
	    setInputValueById("notice_doc_no_id_input",no);
	    waitForElementClickable(By.cssSelector(".ui-autocomplete-query"));
	    //清空时间
	    clearDate("calendar_start_id");
	    //查询
	    waitForElementClickable(By.id("query_notice_id"));
	    //点击复制
	    waitForElementClickable(By.id("notice_list_id:0:copy_notice_id2"));
	    //提交确认
	    waitForElementClickable(By.id("copy_notice_id"));
	    //保存
	    waitForElementClickable(By.id("notice_edit_doc_id"));
	    
	    
	    String msg = getSaveMsg(By.cssSelector("#notice_doc_list_mess_id > span.ui-message-info-detail"));
	    LogUtils.writeChangeLine(msg);
	    
	}
	
	public static void audit(String no){
		LogUtils.write("开始审核价格通知单");
		//进入菜单
		initMenuByCssSelector("协议管理", "价格通知单管理", "#M20202 > a");
		//输入价格通知单号
	    setInputValueById("notice_doc_no_id_input",no);
	    waitForElementClickable(By.cssSelector(".ui-autocomplete-query"));
	    //清空时间
	    clearDate("calendar_start_id");
	    //查询
	    waitForElementClickable(By.id("query_notice_id"));
	    //点击修改
	    waitForElementClickable(By.id("notice_list_id:0:audit_notice_id2"));
	    //审核通过
	    waitForElementClickable(By.cssSelector("#notice_doc_model_id > div > div > button:nth-child(1)"));
	    
	    String msg = getSaveMsg(By.cssSelector("#notice_doc_list_mess_id > span.ui-message-info-detail"));
	    LogUtils.writeChangeLine(msg);
	    
	}
	
	
	public static void notAudit(String no){
		LogUtils.write("开始反审价格通知单");
		//进入菜单
		initMenuByCssSelector("协议管理", "价格通知单管理", "#M20202 > a");
		//输入价格通知单号
	    setInputValueById("notice_doc_no_id_input",no);
	    waitForElementClickable(By.cssSelector(".ui-autocomplete-query"));
	    //清空时间
	    clearDate("calendar_start_id");
	    //查询
	    waitForElementClickable(By.id("query_notice_id"));
	    //点击反审
	    waitForElementClickable(By.id("notice_list_id:0:audit_notice_id3"));
	    //反审原因
	    setInputValueById("re_audit_reason_id", "测试反审");
	    //确认反审
	    waitForElementClickable(By.id("re_audit_notice_id"));
	    
	    String msg = getSaveMsg(By.cssSelector("#notice_doc_list_mess_id > span.ui-message-info-detail"));
	    LogUtils.writeChangeLine(msg);
	    
	}
	
	public static void del(String no){
		LogUtils.write("开始删除价格通知单");
		//进入菜单
		initMenuByCssSelector("协议管理", "价格通知单管理", "#M20202 > a");
		//输入价格通知单号
	    setInputValueById("notice_doc_no_id_input",no);
	    waitForElementClickable(By.cssSelector(".ui-autocomplete-query"));
	    //清空时间
	    clearDate("calendar_start_id");
	    //查询
	    waitForElementClickable(By.id("query_notice_id"));
	    //点击删除
	    waitForElementClickable(By.id("notice_list_id:0:del_notice_id2"));
	    //确认反审
	    waitForElementClickable(By.id("del_notice_id2"));
	    
	    String msg = getSaveMsg(By.cssSelector("#notice_doc_list_mess_id > span.ui-message-info-detail"));
	    LogUtils.writeChangeLine(msg);
	    
	}
	

}
