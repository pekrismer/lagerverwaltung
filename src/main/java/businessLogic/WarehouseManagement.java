package businessLogic;
/**
 * 
 * @author Peter
 *Offers methods for managing the warehouse
 */
public class WarehouseManagement {
	private Warehouse warehouse;
	
	public WarehouseManagement(Warehouse warehouse){
		this.warehouse = warehouse;
	}
	
	public void addArticle(Article articel){
		boolean finished = false;
		for (int i = 0; i<warehouse.getWarehouse().length && !finished; i++  ){
		    for (int j = 0; j<warehouse.getWarehouse()[i].length; j++){
		        if(warehouse.getWarehouse()[i][j] == null){
		        	warehouse.getWarehouse()[i][j] = articel;
		        	articel.setInventoryID(i, j);
		        	finished = true;
		        	break;
		        }
		       
		    } 
		}
		if(articel.getInventoryID()[0] == null){
			System.out.println("Fehler: Lager ist voll!");
			System.out.println("Benutzen Sie den Befehl 'konfigurieren' um das Lager zu erweitern");
			System.out.println();
		}
	}
	
	public Article getArticle(Integer[] position) {
		Article article = warehouse.getWarehouse()[position[0]][position[1]];
		return article;
	}

	public void removeArticle(Integer[] inventoryID){
		warehouse.getWarehouse()[inventoryID[0]][inventoryID[1]] = null;
	}
	
	public Integer[] getPosition(String itemNumber){
		boolean finished = false;
		Integer[] inventoryID = new Integer[2];
		for (int i = 0; i<warehouse.getWarehouse().length && !finished; i++){
		    for (int j = 0; j<warehouse.getWarehouse()[i].length; j++){
		        if(warehouse.getWarehouse()[i][j].getItemNumber().equals(itemNumber)){
		        	inventoryID = warehouse.getWarehouse()[i][j].getInventoryID();
		        	finished = true;
		        	break;
		        }
		       
		    } 
		}
		return inventoryID;
	}
	
	public void extendWarehouse(int row, int column){
		warehouse.setWarehouse(warehouse.extendWarehouse(warehouse.getWarehouse(), row, column));
	}
	
	public String Inventar(){
		return warehouse.toString();
	}
	
	public Article[][] getWarehouseContent(){
		return warehouse.getWarehouse();
	}
	
	
	
	
	
	

}
