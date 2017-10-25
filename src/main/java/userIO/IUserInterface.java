package userIO;



/**
 * Interface for a general User Interface
 */
public interface IUserInterface {

    int INVALID_NUMBER = -1, MENU_CANCEL = 0, MENU_YES = 1, MENU_NO = 2;

    /**
     * Outputs given Message
     *
     * @param message
     *
     */
    void displayMessage(String message);

    /**
     * Displays a Dialog and defines Menu options (yes and no)
     *
     * @param message: Message displayed in Dialog
     * @returns integer the User provided or a negative Number if a wrong Input was given
     * -1 - if no valid number was provided
     * 0 - for cancelling the menu
     * 1 - for yes
     * 2 - for no
     */
    int displayDialog(String message);

    /**
     * Asks the User for a Number
     *
     * @returns integer the User provided or a negative Number if a wrong Input was given
     */
    Number askForNumber();


    /**
     * Asks the User for an Input
     *
     * @param scanWholeLine: - true: returns whole input
     *                       - false: only returns first word
     * @returns the line or the word the User provided
     */
    String askForString(boolean scanWholeLine);


}
