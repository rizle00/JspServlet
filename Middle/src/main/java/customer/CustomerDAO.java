package customer;

import java.util.List;

import common.MybatisConnection;

public class CustomerDAO extends MybatisConnection {
	
	public CustomerDAO() {
		super(DataResource.HANUL);
	}


	//초기 데이터베이스 연결 테스트, 
	public void test(){
		int  result = sql.selectOne("cu.test");
		System.out.println(result);
	}
	
	
	public List<CustomerVO> select(String query){
		return sql.selectList("cu.select",query);
	}
	
	public void delete(int customer_id) {
		System.out.println(sql.delete("cu.delete", customer_id)); 
	}
	
	public void insert(CustomerVO vo) {
		System.out.println(sql.insert("cu.insert", vo));
	}
	
	public int update(CustomerVO vo) {
		return sql.update("cu.update", vo);
	}
}
