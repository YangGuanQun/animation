package com.anime.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.anime.bean.Ani;
import com.anime.dao.AniDao;
import com.anime.exception.ServiceException;
import com.anime.msg.req.AniPageReq;
import com.anime.msg.rsp.AniPageRsp;
import com.anime.service.AniService;

public class AniServiceImpl implements AniService{
	@Autowired
	private AniDao aniDao;
	
	public int addAni(Ani ani) throws ServiceException {
		Integer id = null;
		try {
			id = aniDao.selectNextId();
			ani.setId(id);
			if(null == ani.getState()){
				ani.setState(0);
			}
			aniDao.insertAni(ani);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return id;
	}

	public void dropAni(Integer[] ids) throws ServiceException{
		try {
			aniDao.deleteAni(ids);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
	}
	

	public Ani queryAniById(int id) throws ServiceException {
		Ani ani = null;
		try{
			ani = aniDao.selectAniById(id);
		}catch(SQLException e){
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ani;
	}

	public void modifyAni(Ani ani) throws ServiceException {
		try {
			aniDao.updateAni(ani);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		
	}

	public AniPageRsp queryAniByPage(AniPageReq aniPageReq) throws ServiceException {
		List<Ani> aniList = null;
		AniPageRsp rsp = new AniPageRsp();
		try {
			aniList = aniDao.selectAniByPage(aniPageReq);
			rsp.setResultList(aniList);
			int totalCount = aniDao.selectTotalCount();
			int pageSize = aniPageReq.getPageSize();
			int totalPage = (totalCount+pageSize-1)/pageSize;
			rsp.setTotalCount(totalCount);
			rsp.setTotalPage(totalPage);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return rsp;
	}

	
}
