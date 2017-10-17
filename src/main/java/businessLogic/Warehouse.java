package businessLogic;

public class Warehouse {
	private Article[][] warehouse;
	
	public Warehouse(int row, int column){
		warehouse = new Article[row][column];
	}
	
	

	public Article[][] getWarehouse() {
		return warehouse;
	}
	
	public Article[][] extendWarehouse(Article[][] previousWarehouse, int rows, int columns){
		Article[][] newWarehouse = previousWarehouse;
		for (int i = 0; i < rows; i++) {
			newWarehouse = addRow(previousWarehouse);
		}
		
		for (int i = 0; i < columns; i++) {
			newWarehouse = addColumn(previousWarehouse);
		}
		return newWarehouse;
	}
	
	public void setWarehouse(Article[][] warehouse) {
		this.warehouse = warehouse;
	}



	private Article[][] addRow(Article[][] previousWarehouse){
		int prevRowCount = previousWarehouse.length;

        Article[][] withExtraRow = new Article[prevRowCount + 1][];
        System.arraycopy(previousWarehouse, 0, withExtraRow, 0, previousWarehouse.length);
        withExtraRow[prevRowCount] = new Article[withExtraRow[1].length];
        return withExtraRow;
	}
	
	private Article[][] addColumn(Article[][] previousWarehouse){
		int prevColumnCount = previousWarehouse[1].length;

        Article[][] withExtraColumn = new Article[prevColumnCount + 1][];
        System.arraycopy(previousWarehouse, 0, withExtraColumn, 0, previousWarehouse[1].length);
        withExtraColumn[prevColumnCount] = new Article[withExtraColumn[0].length];
        return withExtraColumn;
	}
	
	public String toString() {
		StringBuilder items = new StringBuilder("Inventar:" + System.lineSeparator());
		for (int i = 0; i<warehouse.length; i++){
		    for (int j = 0; j<warehouse[i].length; j++){
		        if(warehouse[i][j] != null ){
		        	items.append(warehouse[i][j].toString());
		        }
		        
		    } 
		}
		return items.toString();
	}
	

}
