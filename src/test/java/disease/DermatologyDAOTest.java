package disease;

import java.util.List;

import org.junit.Test;

import com.ufu.disease.dao.DermatologyDAO;
import com.ufu.disease.to.Chromossomo;

public class DermatologyDAOTest {

	@Test
	public void searchTeste() {
		DermatologyDAO demDAO = new DermatologyDAO();
		List<Chromossomo> list = demDAO.searchDermtology(10, 1);
		org.junit.Assert.assertNotNull(list);
	}
}
