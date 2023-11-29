package sg;

import java.util.List;

import common.MybatisConnection;

public class SgDAO extends MybatisConnection {
	public SgDAO() {
		super(DataResource.SG);
	}

	public List<SgVO> select() {
		return sql.selectList("sg.select");
	}
	
	public void insert(SgVO vo) {
		sql.insert("sg.insert",vo);
	}
}
