package com.analysis.task;

import java.util.Date;

import com.analysis.service.RegoinServiceImpl;
import com.analysis.utils.DateTool;

public class RegionJob {

	private RegoinServiceImpl regoinService;

	public RegoinServiceImpl getRegoinService() {
		return regoinService;
	}

	public void setRegoinService(RegoinServiceImpl regoinService) {
		this.regoinService = regoinService;
	}

	public void doBiz() throws Exception {
		System.out.println("/*********************行政区划数据开始更新************************/");

		try {
			long start = System.currentTimeMillis();
			// RegoinServiceImpl serviceImpl = new RegoinServiceImpl();
			regoinService.updateRegionLog();
			long end = System.currentTimeMillis();
			String format = "%s:行政区划数据更新任务结束,消耗时间 %d ms. [%s]";
			String info = String.format(format, DateTool.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"), end - start,
					TermTimerTask.class.getName());
			System.out.println(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
