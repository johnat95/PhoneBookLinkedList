import PhoneBookLinkedList.ContactNodeManager;

public class Main {

    public static void main(String[] args) {

        ContactNodeManager contactNodeManager = new ContactNodeManager();

        contactNodeManager.addNode(contactNodeManager.createContactNode("Nathan", "Johnston","a","a",
                "a","a","a","a"));
        contactNodeManager.addNode(contactNodeManager.createContactNode("Naan", "Johnston","a","a",
                "a","a","a","a"));
        contactNodeManager.addNode(contactNodeManager.createContactNode("an", "Johnston","a","a",
                "a","a","a","a"),1);

        contactNodeManager.display(0);

        contactNodeManager.editNode("NathanJohnston", contactNodeManager.FIRST_NAME, "sdfs");

        contactNodeManager.display(0);



    }
}
