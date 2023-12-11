package member;

import common.MybatisConnection;

public class MemberDAO_id extends MybatisConnection implements MemberService{

	public MemberDAO_id() {
		super(DataResource.HANUL);
	}

	@Override
	public int member_join(MemberVO vo) {
		return 0;
	}

	@Override
	public int member_idCheck(String user_id) {
		return sql.selectOne("me.idCheck", user_id);
	}

	@Override
	public MemberVO member_login(MemberVO vo) {
		
		return null;
	}

	@Override
	public int member_update(MemberVO vo) {
		return 0;
	}

	@Override
	public int member_delete(MemberVO vo) {
		return 0;
	}

	@Override
	public void findPassWord(MemberVO vo) {
		
	}
	
	
}
