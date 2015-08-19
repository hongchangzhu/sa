package com.analysis;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.analysis.task.TimerManager;

public class TaskListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void contextInitialized(ServletContextEvent arg0) {
		new TimerManager();
	}

}
