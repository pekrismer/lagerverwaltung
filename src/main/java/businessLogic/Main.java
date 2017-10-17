package businessLogic;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Warehouse testWarehouse = new Warehouse(4,2);
		
		WarehouseManagement testManagement = new WarehouseManagement(testWarehouse);
		testManagement.addArticle(new Article("Artikel 1", "1", "20er Packung", "obi", 200));
		testManagement.addArticle(new Article("Artikel 2", "2", "40er Packung", "obi", 20));
		testManagement.addArticle(new Article("Artikel 3", "3", "20er Packung", "obi", 200));
		testManagement.addArticle(new Article("Artikel 4", "4", "20er Packung", "obi", 20));
		testManagement.addArticle(new Article("Artikel 5", "5", "70er Packung", "obi", 300));
		testManagement.addArticle(new Article("Artikel 6", "6", "20er Packung", "obi", 200));
		testManagement.addArticle(new Article("Artikel 7", "7", "100er Packung", "obi", 400));
		testManagement.addArticle(new Article("Artikel 8", "8", "100er Packung", "obi", 400));
		
		testManagement.extendWarehouse(1, 0);
		testManagement.addArticle(new Article("Artikel 9", "9", "100er Packung", "obi", 400));
		for (Integer string : testManagement.getPosition("9")) {
			System.out.println(string);
		}
		System.out.println(testManagement.Inventar());

	}

}
