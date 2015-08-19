package com.analysis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analysis.dao.RegionDaoImpl;
import com.analysis.po.Regoin;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service("regoinService")
public class RegoinServiceImpl {
	@Autowired
	private RegionDaoImpl regionDao;

	/**
	 * 
	 * @功能：获取默认行政区划id
	 * 
	 * @return
	 */
	public String getDefaultRegoinId() {
		// RegionDaoImpl daoImpl = new RegionDaoImpl();
		Regoin regoin = regionDao.getDefaultRegoin();
		if (regoin == null || regoin.getId() == null)
			return "";
		return regoin.getId();
	}

	/**
	 * 
	 * @功能：更新行政区划表的数据，先删除再插入
	 * 
	 */
	public int updateAll() {
		// RegionDaoImpl daoImpl = new RegionDaoImpl();
		// 先删除再插入全部
		regionDao.deleteAll();
		return regionDao.saveAll();
	}

	public void updateRegionLog() {
		this.updateAll();
	}

	/**
	 * 
	 * @功能：对象转化为json
	 * 
	 * @param pid
	 * @return
	 */
	public String fromObject2Json(String pid) {
		// RegionDaoImpl daoImpl = new RegionDaoImpl();
		List<Regoin> list = regionDao.getUnderline(pid);
		Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String jsonData = g.toJson(list);
		return jsonData;
	}
}
