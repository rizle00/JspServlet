package customer;

import java.util.List;

import common.MybatisConnection;

public class CustomerDAO extends MybatisConnection {
	
	//초기 데이터베이스 연결 테스트, 
	public void test(){
		int  result = sql.selectOne("cu.test");
		System.out.println(result);
	}
	
	
	public List<CustomerVO> select(){
		return sql.selectList("cu.select");
	}
	
	public void delete(int customer_id) {
		System.out.println(sql.delete("cu.delete", customer_id)); 
	}
	
	public void insert(CustomerVO vo) {
		System.out.println(sql.insert("cu.insert", vo));
	}
	
	public void update(CustomerVO vo) {
		System.out.println(sql.update("cu.update", vo));
	}
}
