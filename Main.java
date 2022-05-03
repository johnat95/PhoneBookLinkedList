import PhoneBookLinkedList.ContactNode;
import PhoneBookLinkedList.ContactNodeManager;

public class Main {

    public static void main(String[] args) {

        ContactNodeManager contactNodeManager = new ContactNodeManager();

        contactNodeManager.addNode(new ContactNode("Nathan", "Johnston","a","a",
                "a","a","a","a"));
        contactNodeManager.addNode(new ContactNode("Naan", "Johnston","a","a",
                "a","a","a","a"));
        contactNodeManager.addNode(new ContactNode("an", "Johnston","a","a",
                "a","a","a","a"),1);

        contactNodeManager.display(0);

        contactNodeManager.editNode("NathanJohnston", contactNodeManager.FIRST_NAME, "sdfs");

        contactNodeManager.display(0);



    }
}
