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
            lastNode.setNextNode(newNode);
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
            if(newNode.getLastName().compareTo(testNode.getLastName())<=0){

                if(pastNode == null){
                    newNode.setNextNode(testNode);
                    firstNode = newNode;
                    break;
                }

                //insert new node between testNode and past node
                //once the testNode comes after the new node
                pastNode.setNextNode(newNode);
                newNode.setNextNode(testNode);
                break;
            }

            //move to the next node
            pastNode = testNode;
            testNode = testNode.getNextNode();

            //add to end of list no testNodes come after newNode
            if(testNode == null){
                pastNode.setNextNode(newNode);

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
                currentNode = currentNode.getNextNode();
            } while (index != currentIndex);
        }

        return currentNode;
    }

    private ListNode getNode(String name) {

        ListNode currentNode = firstNode;

        //loop though nodes check the name of each contact
        while (currentNode != null){

            //check against first and last name
            if((currentNode.getCompareString().toLowerCase()).equalsIgnoreCase(name)){
                return currentNode;
            }
            currentNode = currentNode.getNextNode();
        }

        return null;
    }

    //this method remove the node at the given index
    public void removeNode(int index){
        //if node is last node
        if(index==length-1){
            ListNode previousNode = getNthNode(index-1);
            previousNode.setNextNode(null);
        }else if(index==0){
            //if removing the firstNode, make the second
            //node the first
            firstNode = getNthNode(index+1);
        }else{
            //link the previous and next node
            ListNode previousNode = getNthNode(index-1);
            ListNode nextNode = getNthNode(index).getNextNode();
            previousNode.setNextNode(nextNode);
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
                    firstNode = currentNode.getNextNode();


                }else{
                    previousNode.setNextNode(currentNode.getNextNode());
                }
                //indicates successful removal
                length--;
                return 1;
            }
            //keep current node in memory
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();

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
            System.out.println(current.getCompareString());
            current = current.getNextNode();
        }
        System.out.println("~");
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
        return 1;
    }
    //this method edits the node with the matching name
    public int editNode(String name, int field, String newValue){
        @Nullable
        ListNode editNode = getNode(name);

        if(editNode == null){
            return -1;
        }

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
        return 1;
    }



    public class ListNode {

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


        public ListNode(String firstName, String lastName,
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

        public ListNode getNextNode() {
            return nextNode;
        }

        public void setNextNode(ListNode nextNode) {
            this.nextNode = nextNode;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        //this method will concat the last name of a contact to the first name, bringing both
        //to lower case
        public String getCompareString(){
            return firstName.toLowerCase().concat(lastName.toLowerCase());
        }

        @Override
        public String toString() {
            return "ListNode{"+
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", address='" + address + '\'' +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", zipCode='" + zipCode + '\'' +
                    ", email='" + email + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    '}';
        }
    }
}
