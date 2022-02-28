package org.comstudy21.Saram.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SaramDao {
	   private String resource;
	   private InputStream inputStream;
	   private SqlSessionFactory sqlSessionFactory;
	   private SqlSession comstudy21;
	   private String ns = "org.comstudy21.Saram.SaramMapper";

	   public SaramDao(){
	      try {
	         resource = "mybatis-config.xml";
	         inputStream = Resources.getResourceAsStream(resource);
	         sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	         comstudy21 = sqlSessionFactory.openSession(true);
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }

	   public List<SaramDto> selectAll() throws IOException {
	      List<SaramDto> saramList = comstudy21.selectList(ns + ".selectAll");
	      return saramList;
	   }

	   public SaramDto selectOne(int no) throws IOException {
	      SaramDto saram = comstudy21.selectOne(ns + ".selectSaram", 2);
	      return saram;
	   }

	   public void insert(SaramDto dto) {
		   comstudy21.selectOne(ns + ".insertSaram", dto);
	   }

	   public void update(SaramDto dto) {
		   comstudy21.selectOne(ns + ".updateSaram", dto);
	   }

	   public void delete(SaramDto dto) {
		   comstudy21.selectOne(ns + ".deleteSaram", dto);
	   }

	}