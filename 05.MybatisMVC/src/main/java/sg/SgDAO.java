package sg;

import java.util.HashMap;
import java.util.List;

import common.MybatisConnection;
import customer.CustomerVO;

public class SgDAO extends MybatisConnection {
	public SgDAO() {
		super(DataResource.SG);
	}
	
	public int parse(String param) {
		int temp;
		if(param.equals("")) {
			temp = 0;
		} else {
			temp = Integer.parseInt(param);
		}
		
		return temp;
	}

	public double parseD(String param) {
		double temp;
		if(param.equals("")) {
			temp = 0;
		} else {
			temp = Double.parseDouble(param);
		}
		
		return temp;
	}

	public List<SgVO> select(HashMap<String, String> map) {
		return sql.selectList("sg.select", map);
	}
	
	public List<SgVO> depart() {
		return sql.selectList("sg.depart");
	}
	
	public void insert(SgVO vo) {
		sql.insert("sg.insert",vo);
	}
	public void delete(int employee_id) {
		sql.delete("sg.delete", employee_id);
	}
	
	public void update(SgVO vo) {
		System.out.println(sql.update("sg.update", vo));
	}
}
