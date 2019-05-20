package com.wcs.ncp.test;

import java.io.IOException;
import com.wcs.ncp.util.LogUtils;
import com.wcs.ncp.util.NoticeDocUtils;

public class 价格通知单 {
	
	public static void main(String[] args) throws IOException {
		
		try {
			test();
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.write("测试过程出现异常，异常信息：" + e.getMessage());
		}finally{
			LogUtils.closeIO();
		}
		
	}
	
	public static void test() throws IOException{
		//准备日志文件
		LogUtils.init("添加价格通知单");
		//添加价格通知单
		String no = NoticeDocUtils.add();
	
		//查看价格通知单详情
		NoticeDocUtils.view(no);
		
		//修改价格通知单，提交审核
		NoticeDocUtils.edit(no);
		
		//撤销提交审核
		NoticeDocUtils.cancelAudit(no);
		
		//修改价格通知单，提交审核
		NoticeDocUtils.edit(no);
		
		//审核价格单
		NoticeDocUtils.audit(no);
		
		//反审价格单
		NoticeDocUtils.notAudit(no);
		
		//删除价格单
		NoticeDocUtils.del(no);
	}

}
