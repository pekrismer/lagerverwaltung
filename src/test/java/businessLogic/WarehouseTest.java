package businessLogic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WarehouseTest {

	private Warehouse test;
	private Article[][] newTest;
	@Before
	public void setUp() throws Exception {
		test = new Warehouse(4,4);
		test.getWarehouse()[0][0] = new Article(null, null, null, null, 0);
		
		
	}

	@Test
	public void testExtendWarehouse() {
		assertNotEquals(test.extendWarehouse(test.getWarehouse(), 5, 5), test);
	}
	@Test
	public void testAddRow(){
		newTest = test.extendWarehouse(test.getWarehouse(), 2, 0);
		assertEquals(test.getWarehouse()[0][0], newTest[0][0]);
		assertNotEquals(test.getWarehouse()[0][0], newTest[1][1]);
	}
	
	@Test
	public void testAddColumn(){
		newTest = test.extendWarehouse(test.getWarehouse(), 0, 2);
		assertEquals(test.getWarehouse()[0][0], newTest[0][0]);
		assertNotEquals(test.getWarehouse()[0][0], newTest[1][1]);
	}

}
