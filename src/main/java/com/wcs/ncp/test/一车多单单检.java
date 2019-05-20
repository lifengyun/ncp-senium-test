package com.wcs.ncp.test;

import java.io.IOException;
import com.wcs.ncp.util.BillingUtils;
import com.wcs.ncp.util.EntranceUtils;
import com.wcs.ncp.util.LogUtils;
import com.wcs.ncp.util.QcDocUtils;
import com.wcs.ncp.util.WeightUtils;

public class 一车多单单检 {
	
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
	
	public static void test(){
		try {
			//准备日志文件
			LogUtils.init("一车多单单检");
			//添加入场单
			String entranceDocNo = EntranceUtils.addXYEntranceYCDD("协议不导入（单检）");
			//添加质检单
			QcDocUtils.addQcDoc(entranceDocNo);
			//添加地磅单
			WeightUtils.addFirstWeight(entranceDocNo);
			WeightUtils.addSecondWeightWithOhterWeightYCDD(entranceDocNo,"1050","2","否");
			WeightUtils.addSecondWeightWithOhterWeightYCDD(entranceDocNo,"50","3","是");
			//添加结算单
			BillingUtils.addBillingDoc(entranceDocNo);
		} catch (Exception e) {
			LogUtils.write("发生异常：" + e.getMessage());
		}
	}

}
