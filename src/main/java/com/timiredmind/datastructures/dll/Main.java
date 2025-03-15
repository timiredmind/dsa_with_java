package com.timiredmind.datastructures.dll;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> intergerList = new DoublyLinkedList<>(1);

        intergerList.printList();
        System.out.println(intergerList.getHead());
        System.out.println(intergerList.getTail());
        System.out.println(intergerList.getLength());
        intergerList.append(2);
        intergerList.printList();
//        System.out.println(intergerList.getHead());
         System.out.println(intergerList.getTail());
        // System.out.println(intergerList.getLength());
    }
}
