package google;

import structures.MyLinkedList;

public class Leetcode_707 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(0, 2);
        myLinkedList.deleteAtIndex(9);
       // System.out.println(myLinkedList.get(5));
        //myLinkedList.deleteAtIndex(1);
        //System.out.println(myLinkedList.get(1));
        myLinkedList.print();
    }


}
