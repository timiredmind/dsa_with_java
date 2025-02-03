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

    public Node<E> removeFirst() {
        if (length == 0) return null;

        Node<E> temp = this.head;
        if (length == 1) {
            this.tail = null;
        }
        this.head = this.head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public Node<E> get(long index) {
        if (index < 0 || index >= length) return null;

        Node<E> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    public boolean set(long index, E value) {
        Objects.requireNonNull(value, "Value of Node be null");
        Node<E> node =  get(index);
        if (node == null) return false;

        node.value = value;
        return true;
    }

    public boolean insert(long index, E value) {
        Objects.requireNonNull(value, "Value of Node be null");

        if (index < 0 || index > length) return false;
        
        if (index == 0) {
            prepend(value);
        }
        else if (index == length) {
            append(value);
        } else {
            Node<E> prev = get(index - 1);
            prev.next = new Node<>(value, prev.next);
            length++;
        }
        return true;
    }

    public Node<E> remove(long index) {
        if (index < 0 || index >= length) return null;

        if (index == 0) return removeFirst();

        else if (index == length - 1) return removeLast();

        Node<E> prev = get(index - 1);
        Node<E> current = prev.next;

        prev.next = current.next;
        current.next = null;
        length--;
        return current;
    }

    public void reverse() {
        Node<E> current = this.head;
        this.head = this.tail;
        this.tail = current;

        Node<E> after = null;
        Node<E> before = null;

        for (int i = 0; i < length; i++) {
            after = current.next;
            current.next = before;
            before = current;
            current = after;
        }
    }

    public void printList() {
        Node<E> temp = this.head;
        for (int i = 0; i < length; i++) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }
}
