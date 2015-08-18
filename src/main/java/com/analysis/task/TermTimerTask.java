package com.analysis.task;

import java.util.Date;
import java.util.TimerTask;

import com.analysis.service.TermServiceImpl;
import com.analysis.utils.DateTool;

public class TermTimerTask extends TimerTask {
	@Override
	public void run() {
		System.out.println("/*********************终端数据开始更新************************/");
		try {
			TermServiceImpl serviceImpl = new TermServiceImpl();
			long start = System.currentTimeMillis();
			serviceImpl.updateSchoolLog();
			long end = System.currentTimeMillis();
			String format = "%s:终端更新任务结束,消耗时间 %d ms. [%s]";
			String info = String.format(format, DateTool.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"),
					TermTimerTask.class.getName(), end - start);
			System.out.println(info);
		} catch (Exception e) {

		}
	}
}
