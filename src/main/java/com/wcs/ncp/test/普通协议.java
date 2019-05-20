package com.wcs.ncp.test;

import java.io.IOException;

import com.wcs.ncp.util.LogUtils;
import com.wcs.ncp.util.XyUtils;

public class 普通协议 {
	
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
	
	public static void  test() throws IOException{
		LogUtils.init("添加普通协议");
		XyUtils.add();
		XyUtils.addItem();
		XyUtils.addNotice();
	}

}
