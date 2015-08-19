package com.analysis.task;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class TimerManager {

	public TimerManager() {
		// �賿2��ִ��
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 2);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date time = calendar.getTime();

		long period = 24 * 60 * 60 * 1000;// ���24Сʱִ��

		Timer timer = new Timer();
		TermTimerTask task = new TermTimerTask();
		// ����ָ����������ָ����ʱ�俪ʼ�����ظ��Ĺ̶��ӳ�ִ�С�
		timer.schedule(task, time, period);
	}

}
