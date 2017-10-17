package businessLogic;

import userIO.CLI;

public class Main {

	public static void main(String[] args){
		
		Warehouse testWarehouse = new Warehouse(4,4);
		
		WarehouseManagement testManagement = new WarehouseManagement(testWarehouse);
		
		
		/*testManagement.extendWarehouse(1, 0);
		testManagement.addArticle(new Article("Artikel 9", "9", "100er Packung", "obi", 400));
		for (Integer string : testManagement.getPosition("9")) {
			System.out.println(string);
		}
		System.out.println(testManagement.Inventar());
		
		CLI test = new CLI(args, testManagement);
		test.parse();*/
		
		CLI test = new CLI(testManagement);
		test.start();
	}

}
