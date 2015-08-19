package com.analysis.task;

import java.util.Date;

import com.analysis.service.TermServiceImpl;
import com.analysis.utils.DateTool;

public class TermJob {
	public void doBiz() throws Exception {
		System.out
				.println("/*********************终端数据开始更新************************/");
		try {
			TermServiceImpl serviceImpl = new TermServiceImpl();
			long start = System.currentTimeMillis();
			serviceImpl.updateSchoolLog();
			long end = System.currentTimeMillis();
			String format = "%s:终端更新任务结束,消耗时间 %d ms. [%s]";
			String info = String.format(format, DateTool.DateToString(
					new Date(), "yyyy-MM-dd HH:mm:ss"), end - start,
					TermTimerTask.class.getName());
			System.out.println(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
