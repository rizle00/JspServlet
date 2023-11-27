package common;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnection {
	// 싱글톤 ( static 블럭킹을 이용해서 전역적인 초기화 식 사용 : 단점. 맵퍼 변경사항이나 config.xml 변경 사항을 다시 읽지 않음
	protected SqlSession sql;
	 
	public MybatisConnection() {
		
			System.out.println("생성자");
			String resource = "mybatis/config.xml";
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream(resource);
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				sql = sqlSessionFactory.openSession(true);
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

	
	
}
