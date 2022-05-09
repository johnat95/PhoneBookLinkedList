package PhoneBookLinkedList;

import java.util.NoSuchElementException;

public class ContactNodeManager {
    private ContactNode firstNode;
    private int length;


    //constants for changing a nodes field
    public final int FIRST_NAME = 1;
    public final int LAST_NAME = 2;
    public final int ADDRESS = 3;
    public final int CITY = 4;
    public final int STATE = 5;
    public final int ZIP_CODE = 6;
    public final int EMAIL = 7;
    public final int PHONE_NUMBER = 8;



    //this
    public void addNode(ContactNode newNode) {

        //if there are no nodes, the new node becomes the first node.
        if (this.firstNode == null) {
            this.firstNode = newNode;
        } else {

            //link new node to last node
            ContactNode lastNode = getNode(length-1);
            lastNode.setNextNode(newNode);
        }
        length++;

    }

    //this method add a node at a given index
    public void addNode(ContactNode newNode, int index) {

        //get previous node and its next node
        ContactNode previousNode = getNode(index-1);
        ContactNode nextNode = previousNode.getNextNode();

        //link next node to new node
        newNode.setNextNode(nextNode);

        //link new node to previous node
        previousNode.setNextNode(newNode);

        length++;

    }

    private void addSorted(ContactNode newNode){

        ContactNode currentNode = firstNode;

        ContactNode nextNode = currentNode.getNextNode();

        while(currentNode.getNextNode() != null){

            if(nextNode.getCompareString().compareTo(newNode.getCompareString())<0){
                //splice
                 newNode.setNextNode(currentNode.getNextNode());

                 currentNode.setNextNode(newNode);
            }
        }
    }

    //this method returns the node at the given index
    public ContactNode getNode(int index) {

        if (index >= length) {
            throw new NoSuchElementException();
        }

        int currentIndex = 0;
        ContactNode currentNode = firstNode;

        //loop though nodes if requested node isn't at index 0
        if(index != 0) {
            do {
                currentIndex++;
                currentNode = currentNode.getNextNode();
            } while (index != currentIndex);
        }

        return currentNode;
    }

    public ContactNode getNode(String name) {

        ContactNode currentNode = firstNode;

        //loop though nodes check the name of each contact
        while (currentNode.getNextNode() != null){

            //check against first and last name
            if((currentNode.getFirstName()+currentNode.getLastName()).equalsIgnoreCase(name)){
                return currentNode;
            }
            currentNode = currentNode.getNextNode();
        }

        return null;
    }

    //this method remove the node at the given index
    public void removeNode(int index){
        if(index>0){
            //link over node at given index
            ContactNode previousNode = getNode(index-1);
            previousNode.setNextNode(getNode(index+1));
        }else{
            //if removing the firstNode, make the second
            //node the first
            firstNode = getNode(index+1);
        }
    }

    public void removeNode(String name){

        ContactNode currentNode = firstNode;
        ContactNode previousNode = null;

        //loop though nodes check the name of each contact
        while (currentNode.getNextNode() != null){

            //check against first and last name
            if((currentNode.getFirstName()+currentNode.getLastName()).equalsIgnoreCase(name)){
                //if replacing the first node
                if(previousNode == null){
                    firstNode = currentNode.getNextNode();
                }else{
                    previousNode.setNextNode(currentNode.getNextNode());
                }

            }
            //keep current node in memory
            previousNode = currentNode;

            currentNode = currentNode.getNextNode();
        }

    }

    public void editNode(int index, int field, String newValue){

        ContactNode editNode = getNode(index);

        switch (field){
            case FIRST_NAME:
                editNode.setFirstName(newValue);
                break;
            case LAST_NAME:
                editNode.setLastName(newValue);
                break;
            case ADDRESS:
                editNode.setAddress(newValue);
                break;
            case CITY:
                editNode.setCity(newValue);
                break;
            case STATE:
                editNode.setState(newValue);
                break;
            case ZIP_CODE:
                editNode.setZipCode(newValue);
                break;
            case EMAIL:
                editNode.setEmail(newValue);
                break;
            case PHONE_NUMBER:
                editNode.setPhoneNumber(newValue);
                break;
        }

    }
    public void editNode(String name, int field, String newValue){

        ContactNode editNode = getNode(name);

        switch (field){
            case FIRST_NAME:
                editNode.setFirstName(newValue);
                break;
            case LAST_NAME:
                editNode.setLastName(newValue);
                break;
            case ADDRESS:
                editNode.setAddress(newValue);
                break;
            case CITY:
                editNode.setCity(newValue);
                break;
            case STATE:
                editNode.setState(newValue);
                break;
            case ZIP_CODE:
                editNode.setZipCode(newValue);
                break;
            case EMAIL:
                editNode.setEmail(newValue);
                break;
            case PHONE_NUMBER:
                editNode.setPhoneNumber(newValue);
                break;
        }
    }

    public void display(int index){
        System.out.println(getNode(index).toString());
    }
    public void display(String name){
        System.out.println(getNode(name).toString());
    }
}
