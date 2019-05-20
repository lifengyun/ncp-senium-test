package com.wcs.ncp.test;

import java.io.IOException;

import com.wcs.ncp.util.LogUtils;

public class Test {

	
	public static void main(String[] args) throws IOException {
		try {	
			LogUtils.init("测试日志");
			挂牌单检.test();
			挂牌双检.test();
			协议单检.test();
			协议双检.test();
			一车多单单检.test();
			普通协议.test();
			价格通知单.test();
		} catch (Exception e) {
			LogUtils.write("测试过程出现异常，测试结束：" + e.getMessage());
		}finally{
			LogUtils.closeIO();
		}
	}
	
}
