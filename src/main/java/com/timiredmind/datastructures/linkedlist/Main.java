package com.timiredmind.datastructures.linkedlist;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.append(4);

        System.out.println(singlyLinkedList);
        System.out.println("Length " + singlyLinkedList.getLength());
        singlyLinkedList.removeLast();
        System.out.println(singlyLinkedList);
        System.out.println("Length " + singlyLinkedList.getLength());
        singlyLinkedList.removeLast();
        System.out.println(singlyLinkedList);
        System.out.println("Length " + singlyLinkedList.getLength());

        singlyLinkedList.removeLast();
        System.out.println(singlyLinkedList);
        System.out.println("Length " + singlyLinkedList.getLength());

        singlyLinkedList.removeLast();
        System.out.println(singlyLinkedList);
        System.out.println("Length " + singlyLinkedList.getLength());

        singlyLinkedList.removeLast();
        System.out.println(singlyLinkedList);
        System.out.println("Length " + singlyLinkedList.getLength());

        singlyLinkedList.append(22);
        System.out.println(singlyLinkedList);
        System.out.println("Length " + singlyLinkedList.getLength());
//        System.out.println(linkedList.getHead());

    }
}
