package org.comstudy21.Saram;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.comstudy21.Saram.model.SaramDto;

public class SaramDaoTest {

	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		try (SqlSession comstudy21 = sqlSessionFactory.openSession()) {
			List<SaramDto> saramList = comstudy21.selectList("org.comstudy21.Saram.SaramMapper.selectAll");
			System.out.println(saramList);
		}
	}

	public static void selectOneTest(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		try (SqlSession comstudy21 = sqlSessionFactory.openSession()) {
			SaramDto saram = comstudy21.selectOne("org.comstudy21.Saram.SaramMapper.selectSaram", 2);
			System.out.println(saram);
		}
	}

}
