package com.anime.service;

import com.anime.bean.Ani;
import com.anime.exception.ServiceException;
import com.anime.msg.req.AniPageReq;
import com.anime.msg.rsp.AniPageRsp;

public interface AniService {
	
	public int addAni(Ani ani) throws ServiceException;
	
	public Ani queryAniById(int id) throws ServiceException;
	
	public void dropAni(Integer[] ids) throws ServiceException;
	
	public void modifyAni(Ani ani) throws ServiceException;
	
	public AniPageRsp queryAniByPage(AniPageReq aniPageReq) throws ServiceException;
	
}
