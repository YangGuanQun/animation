package com.anime.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BaseDao {
	
	//private static BaseDao instance;
	
	
	
	private static String source = "mybatis-config.xml";
	private static InputStream is;
	static{
		try {
			is = Resources.getResourceAsStream(source);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
	private SqlSession session = factory.openSession(); 
	
	public BaseDao(){
		
	}
	
	/*public static BaseDao getInstance(){
		if(null == instance){
			synchronized (Object.class) {
				if(null == instance){
					instance = new BaseDao();
				}
			}
		}
		return instance;
	}*/
	
	@SuppressWarnings("unchecked")
	public Object getDao(@SuppressWarnings("rawtypes") Class clazz){
		return session.getMapper(clazz);
	}
	
	public void commit(){
		session.commit();
		session.close();
	}
	
	public void rollback(){
		session.rollback();
		session.close();
	}
}
