package businessLogic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WarehouseManagementTest {

	private Warehouse testWarehouse;
	private WarehouseManagement testWarehouseManagement;
	private Article testArticle;
	@Before
	public void setUp() throws Exception {
		testWarehouse = new Warehouse(4,4);
		testWarehouseManagement = new WarehouseManagement(testWarehouse);
		testArticle = new Article(null, null, null, null, 0);
	}

	@Test
	public void testAddGetArticle() {
		Integer[] testPos = new Integer[] {0,0};
		testWarehouseManagement.addArticle(testArticle);
		assertEquals(testArticle, testWarehouseManagement.getArticle(testPos));
	}


}
