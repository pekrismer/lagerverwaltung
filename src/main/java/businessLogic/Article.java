package businessLogic;

public class Article {
	private String articleDescription;
	private String itemNumber;
	private String packageUnit;
	private String supplier;
	private int price;
	private Integer[] inventoryID;
	
	public Article(String articleDescription, String itemNumber, String packageUnit, String supplier, int price) {
		super();
		this.articleDescription = articleDescription;
		this.itemNumber = itemNumber;
		this.packageUnit = packageUnit;
		this.supplier = supplier;
		this.price = price;
		this.inventoryID = new Integer[] {null, null};
	}
	
	public String getArticleDescription() {
		return articleDescription;
	}


	public void setArticleDescription(String articleDescription) {
		this.articleDescription = articleDescription;
	}


	public String getItemNumber() {
		return itemNumber;
	}


	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}


	public String getPackageUnit() {
		return packageUnit;
	}


	public void setPackageUnit(String packageUnit) {
		this.packageUnit = packageUnit;
	}


	public String getSupplier() {
		return supplier;
	}


	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}

	public Integer[] getInventoryID() {
		return inventoryID;
	}

	public void setInventoryID(int row, int column) {
		this.inventoryID = new Integer[] {row, column};
	}
	
	public String toString(){
		return "Aktikel:" + System.lineSeparator() + articleDescription  + System.lineSeparator() + "Artikelnummer: " + itemNumber + System.lineSeparator() + "Verpackungseinheit: " + packageUnit + 
				System.lineSeparator() + "Lieferant: " + supplier + System.lineSeparator() + 
				"Preis: " + price + System.lineSeparator() + "Lagerposition: Reihe(" + inventoryID[0] + ") Spalte (" + inventoryID[1] +")"; 
	}

}
