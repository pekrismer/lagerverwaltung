package businessLogic;

import userIO.CLI;

public class Main {

	public static void main(String[] args){
		
		Warehouse testWarehouse = new Warehouse(4,4);
		
		WarehouseManagement testManagement = new WarehouseManagement(testWarehouse);
		
		
		CLI test = new CLI(testManagement);
		test.start();
	}

}
