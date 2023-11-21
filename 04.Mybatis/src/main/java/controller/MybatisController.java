package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.MybatisVO;
@WebServlet("*.my")
public class MybatisController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String resource = "mybatis/config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//		sqlSessionFactory.openSession(true); 오토커밋
		SqlSession sql = sqlSessionFactory.openSession(true);//Connection 객체를 이용해서 ps(전송)
		String path = req.getServletPath();
		if(req.getServletPath().equals("/select1.my")) {
			int result = sql.selectOne("testMapper.select1");
			System.out.println(result);
		} else if (path.equals("/select2.my")) {
			String result = sql.selectOne("testMapper.select2");
			System.out.println(result);
		} else if(path.equals("/selectVO.my")) {
			MybatisVO vo = sql.selectOne("testMapper.selectVO");
			System.out.println(vo.getParam1()+" : "+vo.getParam2());
		} else if(path.equals("/selectVOList.my")) {
			List<MybatisVO> list = sql.selectList("testMapper.selectVOList");
			System.out.println(list.size());
			System.out.println(list.get(0));
			System.out.println(list.get(1));
		} else if(path.equals("/param1.my")) {
			String param = "kmj";
			String result = sql.selectOne("testMapper.param1", param);
			System.out.println(result);
		}  else if(path.equals("/param2.my")) {
			int result = sql.selectOne("testMapper.param2", 488);
			System.out.println(result);
			
		} else if (path.equals("/params.my")){
			MybatisVO vo = new MybatisVO();
			vo.setParam1("ava");
			vo.setParam2("asqgvhbhqwea");
			MybatisVO voRtn = sql.selectOne("testMapper.params",vo);
			System.out.println(voRtn.getParam1());
			System.out.println(voRtn.getParam2());
		} else if (path.equals("/parammap.my")) {
			HashMap<String, String> paramMap = new HashMap<>();
			paramMap.put("param1", "avc");
			paramMap.put("param2", "vavwh");
			MybatisVO voRtn = sql.selectOne("testMapper.params",paramMap);
			System.out.println(voRtn.getParam1());
			System.out.println(voRtn.getParam2());
		} else if (path.equals("/insert.my")){
			int result = sql.insert("testMapper.insert");
//			sql.commit();
//			sql.rollback();
			System.out.println(result);
			
		} else if (path.equals("/update.my")){
			int result = sql.update("testMapper.update");
			System.out.println(result);
		}else if (path.equals("/delete.my")){
			int result = sql.delete("testMapper.delete");
			System.out.println(result);
		}
		
		
		
	}
}
