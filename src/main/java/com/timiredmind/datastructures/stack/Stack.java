package com.timiredmind.datastructures.stack;

public class Stack<E> {
    private Node<E> top;
    private long length;

    public static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value) {
            this.value = value;
            this.next = null;
        }

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    public Node<E> getTop() {
        return top;
    }

    public long getLength() {
        return length;
    }

    public Stack(E value) {
        Node<E> newNode = new Node<>(value);
        this.top = newNode;
        this.length = 1;
    }

    public Stack() {
        this.top = null;
        this.length = 0;
    }

    public void push(E value) {
        final Node<E> newNode = new Node<>(value);
        newNode.next = this.top;
        this.top = newNode;
        this.length++;
    }

    public Node<E> pop() {
        if (this.length == 0) {
            return null;
        }

        Node<E> temp = this.top;
        this.top = this.top.next;
        this.length--;
        temp.next = null;
        return temp;
    }
}