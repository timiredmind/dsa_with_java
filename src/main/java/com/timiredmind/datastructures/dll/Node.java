package com.timiredmind.datastructures.dll;

public class Node<E> {
    E value;
    Node<E> prev;
    Node<E> next;


    public Node(E value, Node<E> prev, Node<E> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public Node() {
        this(null, null, null);
    }

    public Node(E value, Node<E> next) {
        this(value, null, next);
    }

    public Node(E value) {
        this(value, null, null);
    }
}