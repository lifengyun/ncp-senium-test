package com.wcs.ncp.test;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.wcs.ncp.util.BillingUtils;
import com.wcs.ncp.util.EntranceUtils;
import com.wcs.ncp.util.LogUtils;
import com.wcs.ncp.util.PurchaseUtils;
import com.wcs.ncp.util.QcDocUtils;
import com.wcs.ncp.util.WeightUtils;

public class 挂牌双检 {
	
	WebDriver wd = null;
	
//	public static void main(String[] args) throws IOException {
//		
//		try {
//			test();
//		} catch (Exception e) {
//			e.printStackTrace();
//			LogUtils.write("测试过程出现异常，异常信息：" + e.getMessage());
//		}finally{
//			LogUtils.closeIO();
//		}
//		
//	}
	
	public static void test(){
		try {
			//准备日志文件
			LogUtils.init("挂牌双检");
			//添加入场单
			String entranceDocNo = EntranceUtils.addGPEntrance("挂牌收购（双检）", "国产高筋白皮冬小麦优9023(6.0220304 其它)");
			//添加初检
			QcDocUtils.addQcDoc(entranceDocNo);
			//添加收购单
			PurchaseUtils.addPurchaseDoc(entranceDocNo,"9040013160");
			//添加地磅单
			WeightUtils.addFirstWeight(entranceDocNo);
			WeightUtils.addSecondWeight(entranceDocNo);
			//添加复检
			QcDocUtils.addQcDoc(entranceDocNo);
			//添加结算单
			BillingUtils.addBillingDoc(entranceDocNo);
		} catch (Exception e) {
			LogUtils.write("发生异常：" + e.getMessage());
		}
	}

}
