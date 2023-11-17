import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import usertbl.UserTblDAO;

public class UserTblDAOTest {
	
	@Disabled
	@Test
	public void delete() {
		UserTblDAO dao = new UserTblDAO();
		dao.delete("이승기T");//  이승기T -> request.getParam
	}
}
