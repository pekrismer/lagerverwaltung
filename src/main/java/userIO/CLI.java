package userIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




import businessLogic.Article;
import businessLogic.WarehouseManagement;
/**
 * Receives and parses the User input.
 * @author Peter
 *
 */
public class CLI {

	
	private WarehouseManagement warehouse;
	private Scanner scan;
	
	
	 
	
	 
	public CLI(WarehouseManagement warehouse){
		this.scan = new Scanner(System.in);
		this.warehouse = warehouse;
	}
			
			

		public void start() {
				String s = "-";
				while (!s.equals("x")) {
					

					MenueAnzeigen();
					s = scan.nextLine().toLowerCase();
					
					if(s.equals("1")){
						this.config();
					}
					else if (s.equals("2")) {
						this.add();
					}
					else if (s.equals("3")) {
						this.remove();
					}
					else if (s.equals("4")) {
						this.inventory();
					}
					else if (s.equals("5")) {
						this.position();
					}
					else if (s.equals("6")) {
						this.content();
					}
				}
					
				System.out.println();
				scan.close();
		}
				
			
			
			private void MenueAnzeigen() {
				System.out.println("*************** MENUE ****************");
				System.out.println("1) Konfigurieren");
				System.out.println("2) Einlagern");
				System.out.println("3) Ausliefern");
				System.out.println("4) Inventar");
				System.out.println("5) Position");
				System.out.println("6) Inhalt");
				System.out.println("x) Beenden");
				System.out.println("*************************************");
		}
		
		private void config(){
			Scanner sizeScanner = new Scanner(System.in);
			boolean correctInput = false;
			while(!correctInput){
				System.out.print("Geben Sie ein wie viele Reihen hinzugefuegt werden sollten:");
				int row = sizeScanner.nextInt();
				System.out.println();
				System.out.print("Geben Sie ein wie viele Spalten hinzugefuegt werden sollten:");
				int column = sizeScanner.nextInt();
				System.out.println();
				
				if(row < 0 || column < 0){
					System.out.println("Ungueltiger Wert! ");
				}
				else{
					correctInput = true;
					warehouse.extendWarehouse(row, column);
				}
			}
			sizeScanner.close();
		}
		
		private void add(){
			Scanner articleScanner = new Scanner(System.in);
			List<String> article = new ArrayList<String>();
			System.out.print("Geben Sie eine Artikelbeschreibung ein: ");
			article.add(articleScanner.nextLine());
			System.out.println();
			System.out.print("Geben sie eine Artikelnummer ein: ");
			article.add(articleScanner.nextLine());
			System.out.println();
			System.out.print("Geben sie eine Verpackungseinheit ein: ");
			article.add(articleScanner.nextLine());
			System.out.println();
			System.out.print("Geben sie einen Lieferanten ein: ");
			article.add(articleScanner.nextLine());
			System.out.println();
			System.out.print("Geben sie einen Preis ein: ");
			article.add(articleScanner.nextLine());
			System.out.println();
			warehouse.addArticle(new Article(article.get(0), article.get(1), article.get(2), article.get(3), Integer.parseInt(article.get(4))));
			articleScanner.close();
		}
		
		private void remove(){
			Scanner idScanner = new Scanner(System.in);
			System.out.print("Geben Sie die Reihe des Artikels ein: ");
			int row = idScanner.nextInt();
			System.out.println();
			System.out.print("Geben Sie die Spalte des Artikels ein: ");
			int column = idScanner.nextInt();
			System.out.println();
			Integer[] inventoryID = new Integer[] {row, column};
			warehouse.removeArticle(inventoryID);
			idScanner.close();
		}
		
		private void inventory(){
			System.out.println(warehouse.Inventar());
		}
		
		private void position(){
			Scanner nuScanner = new Scanner(System.in);
			System.out.print("Geben Sie die Artikelnumber ein: ");
			String articleNumber = nuScanner.nextLine();
			warehouse.getPosition(articleNumber);
			nuScanner.close();
		}
		
		private void content(){
			Scanner idScanner = new Scanner(System.in);
			System.out.print("Geben Sie die Reihe des Artikels ein: ");
			int row = idScanner.nextInt();
			System.out.println();
			System.out.print("Geben Sie die Spalte des Artikels ein: ");
			int column = idScanner.nextInt();
			System.out.println();
			Integer[] inventoryID = new Integer[] {row, column};
			Article articel = warehouse.getArticle(inventoryID);
			System.out.println(articel.toString());
			idScanner.close();
		}


}
