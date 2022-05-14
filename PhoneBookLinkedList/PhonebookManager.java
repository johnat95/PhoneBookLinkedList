package PhoneBookLinkedList;

import com.sun.istack.internal.Nullable;

import java.util.NoSuchElementException;

public class PhonebookManager {
    private ListNode firstNode;
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

    //creates new LinkedNode from an array of details
    public ListNode createContactNode(String[] detailsArray){

        ListNode listNode = new ListNode();

        for(int i = 0; i < detailsArray.length; i++){

            editNode(listNode, i, detailsArray[i]);

        }

        return listNode;
    }

    //this method creates a new contact node
    public ListNode createContactNode(String firstName, String lastName,
                                      String address, String city, String state, String zipCode, String email,
                                      String phoneNumber){
        return new ListNode(firstName, lastName, address, city, state, zipCode, email, phoneNumber);
    }
    //this
    public void addNode(ListNode newNode) {

        //if there are no nodes, the new node becomes the first node.
        if (firstNode == null) {
            firstNode = newNode;
        } else {

            //link new node to last node
            ListNode lastNode = getNthNode(length-1);
            lastNode.nextNode = newNode;
        }
        length++;

    }


    public void addSorted(ListNode newNode){
        if(firstNode == null ){
            firstNode = newNode;
            length++;
            return;
        }

        ListNode testNode = firstNode;

        ListNode pastNode = null;


        while(testNode != null){

            //check node
            if(newNode.lastName.compareTo(testNode.lastName)<=0){

                if(pastNode == null){
                    newNode.nextNode = testNode;
                    firstNode = newNode;
                    break;
                }

                //insert new node between testNode and past node
                //once the testNode comes after the new node
                pastNode.nextNode = newNode;
                newNode.nextNode = testNode;
                break;
            }

            //move to the next node
            pastNode = testNode;
            testNode = testNode.nextNode;

            //add to end of list no testNodes come after newNode
            if(testNode == null){
                pastNode.nextNode = newNode;

            }

        }
        length++;
    }

    //this method returns the node at the given index
    public ListNode getNthNode(int index) {

        if (index > length) {
            throw new NoSuchElementException();
        }

        int currentIndex = 0;
        ListNode currentNode = firstNode;

        //loop though nodes if requested node isn't at index 0
        if(index != 0) {
            do {
                currentIndex++;
                currentNode = currentNode.nextNode;
            } while (index != currentIndex);
        }

        return currentNode;
    }

    public ListNode getNode(String name) {

        ListNode currentNode = firstNode;

        //loop though nodes check the name of each contact
        while (currentNode != null){

            //check against first and last name
            if((currentNode.getCompareString().toLowerCase()).equalsIgnoreCase(name)){
                return currentNode;
            }
            currentNode = currentNode.nextNode;
        }

        return null;
    }

    //this method remove the node at the given index
    public void removeNode(int index){
        //if node is last node
        if(index==length-1){
            ListNode previousNode = getNthNode(index-1);
            previousNode.nextNode = null;
        }else if(index==0){
            //if removing the firstNode, make the second
            //node the first
            firstNode = getNthNode(index+1);
        }else{
            //link the previous and next node
            ListNode previousNode = getNthNode(index-1);
            ListNode nextNode = getNthNode(index).nextNode;
            previousNode.nextNode = nextNode;
        }
        length--;
    }

    public int removeNode(String name){

        ListNode currentNode = firstNode;
        ListNode previousNode = null;


        //loop though nodes check the name of each contact
        while (currentNode != null){

            //check against first and last name
            if((currentNode.getCompareString().equalsIgnoreCase(name))){

                //if removing the first node
                if(previousNode == null){
                    firstNode = currentNode.nextNode;


                }else{
                    previousNode.nextNode = currentNode.nextNode;
                }
                //indicates successful removal
                length--;
                return 1;
            }
            //keep current node in memory
            previousNode = currentNode;
            currentNode = currentNode.nextNode;

        }
        //indicates no contact found
        return  -1;
    }

    public void display(int index){
        System.out.println(getNthNode(index).toString());
    }
    public void display(String name){
        @Nullable
        ListNode node = getNode(name);
        if(node != null){
            System.out.println(getNode(name).toString());
            return;
        }
        System.out.println("No Entry Found");

    }
    public void displayAll(){
        ListNode current = firstNode;

        while(current != null){
            System.out.println(current.toString());
            current = current.nextNode;
        }
        System.out.println("~end~");
    }

    //this method edits the node at the given position
    public int editNthNode(int index, int field, String newValue){
        @Nullable
        ListNode editNode = getNthNode(index);

        if(editNode == null){
            return -1;
        }

        switch (field){
            case FIRST_NAME:
                editNode.firstName = newValue;
                break;
            case LAST_NAME:
                editNode.lastName = newValue;
                break;
            case ADDRESS:
                editNode.address = newValue;
                break;
            case CITY:
                editNode.city = newValue;
                break;
            case STATE:
                editNode.state = newValue;
                break;
            case ZIP_CODE:
                editNode.zipCode = newValue;
                break;
            case EMAIL:
                editNode.email = newValue;
                break;
            case PHONE_NUMBER:
                editNode.phoneNumber = newValue;
                break;
        }
        return 1;
    }

    public int editNode(String name, int field, String newValue){
        @Nullable
        ListNode editNode = getNode(name);

        if(editNode == null){
            return -1;
        }

        switch (field){
            case FIRST_NAME:
                editNode.firstName = newValue;
                break;
            case LAST_NAME:
                editNode.lastName = newValue;
                break;
            case ADDRESS:
                editNode.address = newValue;
                break;
            case CITY:
                editNode.city = newValue;
                break;
            case STATE:
                editNode.state = newValue;
                break;
            case ZIP_CODE:
                editNode.zipCode = newValue;
                break;
            case EMAIL:
                editNode.email = newValue;
                break;
            case PHONE_NUMBER:
                editNode.phoneNumber = newValue;
                break;
        }
        return 1;
    }

    public int editNode(ListNode node, int field, String newValue){

        if(node == null){
            return -1;
        }

        switch (field){
            case FIRST_NAME:

                node.firstName = newValue;
                break;
            case LAST_NAME:
                node.lastName = newValue;
                break;
            case ADDRESS:
                node.address = newValue;
                break;
            case CITY:
                node.city = newValue;
                break;
            case STATE:
                node.state = newValue;
                break;
            case ZIP_CODE:
                node.zipCode= newValue;
                break;
            case EMAIL:
                node.email = newValue;
                break;
            case PHONE_NUMBER:
                node.phoneNumber = newValue;
                break;
        }
        return 1;
    }

    public void transfer(PhonebookManager otherManager, String name){

        ListNode node = getNode(name);
        otherManager.addSorted(node);

        removeNode(name);


    }



    private class ListNode {

        // reference to next node
        private ListNode nextNode;

        //personal details
        private String firstName;
        private String lastName;
        private String address;
        private String city;
        private String state;
        private String zipCode;
        private String email;
        private String phoneNumber;

        //empty constructor to allow fields to be entered as the ui provides them
        public ListNode(){

        }

        private ListNode(String firstName, String lastName,
                        String address, String city, String state, String zipCode, String email,
                        String phoneNumber) {


            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zipCode = zipCode;
            this.email = email;
            this.phoneNumber = phoneNumber;
        }


        //this method will concat the last name of a contact to the first name, bringing both
        //to lower case
        private String getCompareString(){
            return firstName.toLowerCase().concat(lastName.toLowerCase());
        }

        @Override
        public String toString() {
            return "First Name:" + firstName + '\n' +
                    "Last Name:" + lastName + '\n' +
                    "Address: " + address + '\n' +
                    "City: " + city + '\n' +
                    "State: " + state + '\n' +
                    "Zip Code: " + zipCode + '\n' +
                    "Email: " + email + '\n' +
                    "Phone Number: " + phoneNumber + '\n';
        }
    }
}
