package com.anime.service.test;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.anime.bean.Ani;
import com.anime.exception.ServiceException;
import com.anime.msg.req.AniPageReq;
import com.anime.msg.rsp.AniPageRsp;
import com.anime.service.AniService;
import com.anime.service.impl.AniServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring.xml")
@WebAppConfiguration
public class TestAniService {
	@Resource
	AniService aniService;
	
	@Before
	public void before(){
		
	}
	
	
	@Test
	public void testAdd() throws ServiceException{
		Ani ani = new Ani();
		ani.setName("nn");
		Integer id = aniService.addAni(ani);
		System.out.println(id);
	}
	
	@Test
	public void TestQuery() throws ServiceException{
		Ani ani = aniService.queryAniById(7);
		System.out.println(ani);
	}
	
	@Test
	public void TestQuerypage() throws ServiceException{
		AniPageReq req = new AniPageReq();
		req.setPageNum(1);
		req.setPageSize(10);
		AniPageRsp rsp = aniService.queryAniByPage(req);
		System.out.println(rsp);
	}

}
