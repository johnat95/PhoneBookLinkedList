import PhoneBookLinkedList.PhonebookManager;
import PhoneBookLinkedList.PhonebookUI;

public class Main {

    public static void main(String[] args) {

        PhonebookUI ui = new PhonebookUI();

        Demo demo = new Demo();

        //change true to false to run ui
        if(true){
            demo.run();
        }else{
            ui.runUI();
        }

    }

    private static class Demo{

        public void run(){


            //show transfer method

            System.out.println("~Bellingham~");
            PhonebookManager bellingham = new PhonebookManager();
            //a node
            bellingham.addSorted(bellingham.createContactNode("a", "a","a","a",
                    "a","a","a","a"));
            //c node
            bellingham.addSorted(bellingham.createContactNode("c", "c","c","c",
                    "c","c","c","c"));
            bellingham.displayAll();

            System.out.println("~Seattle~");
            PhonebookManager seattle = new PhonebookManager();
            //b node
            seattle.addSorted(seattle.createContactNode("b", "b","b","b",
                    "b","b","b","b"));
            seattle.displayAll();

            //transfer c in bellingham to seattle
            bellingham.display("cc");
            bellingham.transfer(seattle,"cc");
            //remove b
            seattle.removeNode("bb");
            System.out.println("~Seattle with C and no b~");
            seattle.displayAll();

            //change aa to za
            bellingham.editNode("aa", bellingham.FIRST_NAME,"za" );

            System.out.println("~Bellingham without C and za as first name~");
            bellingham.displayAll();



        }
    }
}
