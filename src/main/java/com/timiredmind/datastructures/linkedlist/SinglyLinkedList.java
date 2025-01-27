package com.timiredmind.datastructures.linkedlist;

import java.util.Objects;

public class SinglyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private long length;


    public SinglyLinkedList(E value) {
        Objects.requireNonNull(value, "Value of Node be null");
        Node<E> newNode = new Node<>(value);
        this.head = newNode;
        this.tail = newNode;
        length++;
    }

    public SinglyLinkedList() {}

    public static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node<E> nextNode) {
            this.value = value;
            this.next = nextNode;
        }

        @Override
        public String toString() {
            return "Node { value: " + this.value + ", nextNode: " + this.next + " }";
        }


        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            Node<?> node = (Node<?>) object;
            return Objects.equals(value, node.value) && Objects.equals(next, node.next);
        }
    }

    public Node<E> getHead() {
        return this.head;
    }

    public Node<E> getTail() {
        return this.tail;
    }

    public long getLength() {
        return length;
    }

    public String toString() {
        return "LinkedList { " + this.head + " }";
    }

    // method to add new node to the already last node
    public void append(E value) {
        Objects.requireNonNull(value, "Value of Node be null");
        Node<E> newNode = new Node<>(value);
        if (this.length == 0) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }

        this.tail = newNode;
        length++;
    }

    public Node<E> removeLast() {
        if (this.length == 0) return null;
        Node<E> temp = head;
        Node<E> prev = null;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }

        if (prev == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = prev;
            this.tail.next = null;
        }

        length--;
        return temp;
    }

    public void prepend(E value) {
        Objects.requireNonNull(value, "Value of Node be null");
        Node<E> newNode = new Node<>(value);

        if (length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        length++;
    }

}
