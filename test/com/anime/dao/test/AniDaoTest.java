package com.anime.dao.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.anime.bean.Ani;
import com.anime.dao.AniDao;
import com.anime.msg.req.AniPageReq;

public class AniDaoTest {
	public SqlSession session;
	
	@Before
	public void beforeTest() throws Exception{
		String source = "mybatis-config.xml";
		InputStream is = Resources.getResourceAsStream(source);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		session = factory.openSession();
	}
	
	@Test
	//succeed
	public void testInsert(){
		session.insert("insertAni", "name");
		session.commit();
	}
	
	@Test
	//failed
	public void testReflect() throws Exception{
		AniDao aniDao = (AniDao) Class.forName("com.anime.dao.AniDao").newInstance();
		Ani ani = new Ani();
		ani.setId(1);
		aniDao.insertAni(ani);
	}
	
	@Test
	//succeed
	public void testMapper() throws Exception{
		AniDao aniDao = session.getMapper(AniDao.class);
		Ani ani = new Ani();
		//ani.setId(1);
		aniDao.insertAni(ani);
		//session.commit();
	}
	
	@Test
	public void testDelete() throws Exception{
		AniDao aniDao = session.getMapper(AniDao.class);
		aniDao.deleteAni(new Integer[]{2,4,5});
		session.commit();
	}
	
	@Test
	public void testUpdate() throws Exception{
		AniDao aniDao = session.getMapper(AniDao.class);
		Ani ani = new Ani();
		ani.setId(7);
		ani.setName("abc");
		ani.setCreateTime(new Date());
		ani.setFlag(0);
		aniDao.updateAni(ani);
		session.commit();
	}
	
	@After
	public void afterTest(){
		session.close();
	}
	
	@Test
	public void testPage() throws Exception{
		AniDao aniDao = session.getMapper(AniDao.class);
		AniPageReq req = new AniPageReq();
		req.setPageNum(0);
		req.setPageSize(10);
		Ani ani = new Ani();
		ani.setName("a");
		req.setAni(ani);
		List<Ani> aniList = aniDao.selectAniByPage(req);
		System.out.println(aniList);
	}
}
