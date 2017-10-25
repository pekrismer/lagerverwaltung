package userIO;



import java.io.InputStream;
import java.util.Scanner;

public class ConsoleUI implements IUserInterface {

    private static Scanner scanner;
    private static InputStream istream;

    public ConsoleUI(InputStream inputStream) {
    	istream = inputStream;
    	openScanner();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public int displayDialog(String message) {
    	openScanner();
        displayMessage(message);
        String input = String.valueOf(scanner.next().toLowerCase().charAt(0));
        closeScanner();
        if (input.equals("y")) {
            return MENU_YES;
        } else if (input.equals("n")) {
            return MENU_NO;
        } else {
            return MENU_CANCEL;
        }
    }

    @Override
    public Number askForNumber() {
    	openScanner();
        double returnValue = scanner.nextDouble();
        closeScanner();
        return returnValue;
    }

    public String askForString(boolean scanWholeLine) {
    	String scan = null;
    	openScanner();
    	if	(scanWholeLine) {
    		scan = scanner.nextLine();
    	}
    	else{
    		scan = scanner.next();
    	}
    	closeScanner();
        return scan;
        
    }

	private void openScanner() {
		scanner = new Scanner(istream);
	}
	
	private void closeScanner() {
		scanner = null;
	}
}
