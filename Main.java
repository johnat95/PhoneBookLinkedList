import PhoneBookLinkedList.PhonebookManager;
import PhoneBookLinkedList.PhonebookUI;

public class Main {

    public static void main(String[] args) {

        PhonebookUI ui = new PhonebookUI();

        Demo demo = new Demo();

        //change false to true to run demo
        if(false){
            demo.run();
        }else{
            ui.runUI();
        }

    }

    private static class Demo{

        public void run(){
            PhonebookManager contactNodeManager = new PhonebookManager();

            //contactNodeManager.displayAll();
            contactNodeManager.addSorted(contactNodeManager.createContactNode("aathan", "Johnston","1","a",
                    "a","a","a","a"));

            //contactNodeManager.displayAll();
            contactNodeManager.addSorted(contactNodeManager.createContactNode("caan", "Johnston","a","a",
                    "a","a","a","a"));

            //contactNodeManager.displayAll();
            contactNodeManager.addSorted(contactNodeManager.createContactNode("b", "Johnston","a","a",
                    "a","a","a","a"));

            //contactNodeManager.displayAll();
            contactNodeManager.addSorted(contactNodeManager.createContactNode("d", "Johnston","a","a",
                    "a","a","a","a"));

            //contactNodeManager.displayAll();
            contactNodeManager.addSorted(contactNodeManager.createContactNode("j", "Johnston","a","a",
                    "a","a","a","a"));

            //contactNodeManager.displayAll();
            contactNodeManager.addSorted(contactNodeManager.createContactNode("h", "Aohnston","a","a",
                    "a","a","a","a"));


            contactNodeManager.displayAll();

            contactNodeManager.removeNode("haohnston");
            contactNodeManager.displayAll();
        }
    }
}
