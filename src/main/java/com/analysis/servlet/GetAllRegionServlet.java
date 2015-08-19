package com.analysis.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.analysis.service.RegoinServiceImpl;

public class GetAllRegionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html; charset=gbk");

		long begin = System.currentTimeMillis();
		RegoinServiceImpl serviceImpl = new RegoinServiceImpl();
		int count = serviceImpl.updateAll();
		long end = System.currentTimeMillis();
		System.out.println("更新行政区划数据花费时间：" + (end - begin) + "ms.");
		response.getWriter().write(count);
	}

}
