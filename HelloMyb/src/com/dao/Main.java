package com.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.b.User;

public class Main {
public static void main(String[] args) throws IOException {
	String resource = "com/dao/mybatis-config.xml";
	InputStream inputStream = Resources.getResourceAsStream(resource);
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	
	SqlSession session = sqlSessionFactory.openSession();
	try {
		User user = (User) session.selectOne("org.mybatis.example.UserMapper.selectUser", 1);
		System.out.println(user);
	} finally {
	  session.close();
	}
}
}
