package PhoneBookLinkedList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PhonebookUI {

    protected PhonebookManager phonebookManager = new PhonebookManager();

    private String[] fields = {"First Name", "Last Name", "Address", "City", "State",
            "Zip Code","Email", "Phone Number"};
    private Scanner scan = new Scanner(System.in);

    public void runUI(){

        //add starting data
        phonebookManager.addSorted(phonebookManager.createContactNode("a", "a","a","a",
                "a","a","a","a"));
        phonebookManager.addSorted(phonebookManager.createContactNode("b", "b","b","b",
                "b","b","b","b"));
        phonebookManager.addSorted(phonebookManager.createContactNode("c", "c","c","c",
                "c","c","c","c"));
        phonebookManager.displayAll();


        boolean running = true;

        while(running){
            printMainMenu();

            int runCode = handleMainMenuInput(getUserInput(1,6));

          if (runCode == -1){
               //quit
               running = false;
           }

        }
    }

    //add a new ListNode to the list
    private void addContact(){
        String[] detailsArray = new String[fields.length];

        System.out.println("Please enter the personal details as prompted below.");

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < detailsArray.length ; i++)
        {
            System.out.print(fields[i] + ": " + "\n");
            detailsArray[i] = scan.nextLine();
        }

        phonebookManager.addSorted(phonebookManager.createContactNode(detailsArray));
    }

    public void displayContactInfo(boolean all){

        if(all){
            phonebookManager.displayAll();
        }else{
            System.out.println("What is the first and last name of the person you\n" +
                    "want to display?");
            Scanner scan = new Scanner(System.in);

            //remove spaces from the user input and convert to lowercase
            String line = scan.nextLine().toLowerCase().replaceAll(" ","");

            phonebookManager.display(line);
        }

    }

    public void editContact(){
        System.out.println("What is the first and last name of the person you\n" +
                "want to display?");
        Scanner scan = new Scanner(System.in);

        //remove spaces from the user input and convert to lowercase
        String line = scan.nextLine().toLowerCase().replaceAll(" ","");


        System.out.println("What field do you want to edit?");

        printEditMenu();

        int userInput =  getUserInput(1,8);

        System.out.println("What is the new value?");

        String newValue = scan.nextLine();

        phonebookManager.editNode(line,userInput,newValue);

    }



    private int getUserInput(int min, int max){

        boolean asking = true;
        int userInput = 0;
        while(asking){
            try{
                userInput = scan.nextInt();

                if(userInput > max || userInput < min){
                    System.out.println("Please enter a number corresponding to an option\n" +
                            "on the menu.");

                }else{
                    asking = false;
                }
            }catch(InputMismatchException im){

                System.out.println("Please enter a number corresponding to an option\n" +
                                    "on the menu.");
                scan.nextLine();
            }
        }

        return userInput;
    }

    private int handleMainMenuInput(int input){

        switch (input){
            //add contact
            case 1:
                addContact();
                break;
            //remove contact
            case 2:
                removeContact();
                break;
            //display contact
            case 3:
                displayContactInfo(false);
                break;
            case 4:
                displayContactInfo(true);
                break;
            //edit contact
            case 5:
                editContact();
                break;
            //quit
            default: return -1;
        }
        return 1;
    }

    private void printMainMenu(){
        System.out.println("What would you like to do?\n" +
                "1. Add Contact\n" +
                "2. Remove Contact\n" +
                "3. Display Contact\n" +
                "4. Display All Contacts\n" +
                "5. Edit Contact\n" +
                "6. Quit");
    }

    private void printEditMenu(){
        for(int i = 1; i <= fields.length; i++){
            System.out.println(i+": " + fields[i-1]);
        }
    }
    public void removeContact(){
        System.out.println("What is the first and last name of the person you\n" +
                "want to remove?");

        Scanner scan = new Scanner(System.in);

        //remove spaces from the user input and convert to lowercase
        String line = scan.nextLine().toLowerCase().replaceAll(" ","");

        if(phonebookManager.removeNode(line.toLowerCase()) == -1){
            System.out.println("No Entry Found");
        }

    }
}
