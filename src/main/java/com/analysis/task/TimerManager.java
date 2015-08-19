package com.analysis.task;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class TimerManager {

	public TimerManager() {
		// 凌晨2点执行
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 2);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date time = calendar.getTime();

		long period = 24 * 60 * 60 * 1000;// 间隔24小时执行

		Timer timer = new Timer();
		TermTimerTask task = new TermTimerTask();
		// 安排指定的任务在指定的时间开始进行重复的固定延迟执行。
		timer.schedule(task, time, period);
	}

}
