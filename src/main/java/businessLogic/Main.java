package businessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import userIO.ConsoleUI;
import userIO.IUserInterface;



public class Main {
	
	private static WarehouseManagement warehouse;
	private static IUserInterface ui = new ConsoleUI(System.in);

	public static void main(String[] args){
		
		Warehouse newWarehouse = new Warehouse(4,4);
		
		warehouse = new WarehouseManagement(newWarehouse);
		start();
	}
	
	private static void config(){
		Scanner sizeScanner = new Scanner(System.in);
		boolean correctInput = false;
		while(!correctInput){
			ui.displayMessage("Geben Sie ein wie viele Reihen hinzugefuegt werden sollten:");
			int row = sizeScanner.nextInt();
			ui.displayMessage("");
			ui.displayMessage("Geben Sie ein wie viele Spalten hinzugefuegt werden sollten:");
			int column = sizeScanner.nextInt();
			ui.displayMessage("");
			
			if(row < 0 || column < 0){
				ui.displayMessage("Ungueltiger Wert! ");
			}
			else{
				correctInput = true;
				warehouse.extendWarehouse(row, column);
			}
		}
		sizeScanner.close();
	}
	
	public static void start() {
		String s = "-";
		while (!s.equals("x")) {
			

			MenueAnzeigen();
			s = ui.askForString(false).toLowerCase();
			if(s.equals("1")){
				config();
			}
			else if (s.equals("2")) {
				add();
			}
			else if (s.equals("3")) {
				remove();
			}
			else if (s.equals("4")) {
				inventory();
			}
			else if (s.equals("5")) {
				position();
			}
			else if (s.equals("6")) {
				content();
			}
			
		}
			
		ui.displayMessage("");
		
}
		
	
	
	private static void MenueAnzeigen() {
		ui.displayMessage("*************** MENUE ****************");
		ui.displayMessage("1) Konfigurieren");
		ui.displayMessage("2) Einlagern");
		ui.displayMessage("3) Ausliefern");
		ui.displayMessage("4) Inventar");
		ui.displayMessage("5) Position");
		ui.displayMessage("6) Inhalt");
		ui.displayMessage("x) Beenden");
		ui.displayMessage("*************************************");
}



		private static void add(){
			
			List<String> article = new ArrayList<String>();
			ui.displayMessage("Geben Sie eine Artikelbeschreibung ein: ");
			article.add(ui.askForString(false));
			ui.displayMessage("");
			ui.displayMessage("Geben sie eine Artikelnummer ein: ");
			article.add(ui.askForString(false));
			ui.displayMessage("");
			ui.displayMessage("Geben sie eine Verpackungseinheit ein: ");
			article.add(ui.askForString(false));
			ui.displayMessage("");
			ui.displayMessage("Geben sie einen Lieferanten ein: ");
			article.add(ui.askForString(false));
			ui.displayMessage("");
			ui.displayMessage("Geben sie einen Preis ein: ");
			article.add(ui.askForString(false));
			ui.displayMessage("");
			warehouse.addArticle(new Article(article.get(0), article.get(1), article.get(2), article.get(3), Integer.parseInt(article.get(4))));
			
		}
		
		private static void remove(){
			
			ui.displayMessage("Geben Sie die Reihe des Artikels ein: ");
			int row = ui.askForNumber().intValue();
			ui.displayMessage("");
			ui.displayMessage("Geben Sie die Spalte des Artikels ein: ");
			int column = ui.askForNumber().intValue();
			ui.displayMessage("");
			Integer[] inventoryID = new Integer[] {row, column};
			warehouse.removeArticle(inventoryID);
			
		}
		
		private static void inventory(){
			ui.displayMessage(warehouse.Inventar());
		}
		
		private static void position(){
			
			ui.displayMessage("Geben Sie die Artikelnumber ein: ");
			String articleNumber = ui.askForString(false);
			warehouse.getPosition(articleNumber);
			
		}
		
		private static void content(){
			ui.displayMessage("Geben Sie die Reihe des Artikels ein: ");
			int row = ui.askForNumber().intValue();
			ui.displayMessage("");
			ui.displayMessage("Geben Sie die Spalte des Artikels ein: ");
			int column = ui.askForNumber().intValue();
			ui.displayMessage("");
			Integer[] inventoryID = new Integer[] {row, column};
			Article articel = warehouse.getArticle(inventoryID);
			ui.displayMessage(articel.toString());
		}
	
	

}
