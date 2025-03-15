package com.timiredmind.datastructures.dll;

public class DoublyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private long length;

    public DoublyLinkedList(E value) {
        Node<E> newNode = new Node<>(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    // create empty doubly linked list
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public Node<E> getHead() {
        return this.head;
    }

    public Node<E> getTail() {
        return this.tail;
    }

    public long getLength() {
        return this.length;
    }

    public void append(E value) {
        Node<E> newNode = new Node<>(value);
        if (this.head == null) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
        }
        this.tail = newNode;
        length++;
    }

    public Node<E> removeLast() {
        if (this.head == null) return null;
        Node<E> last = this.tail;

        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        }
        else {
            this.tail = this.tail.prev;
            this.tail.next = null;
            last.prev = null;
        }

        length--;
        return last;
    }

    public void prepend(E value) {
        Node<E> newNode = new Node<>(value);
        if (this.length == 0) {
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
        }
        this.head = newNode;
        length++;
    }

    public Node<E> removeFirst() {
        if (this.head == null) {
            return null;
        }
        Node<E> nodeToRemove = this.head;
        if (this.head == this.tail) {
            this.tail = null;
            this.head = null;
        }
        else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        length--;
        nodeToRemove.next = null;
        return nodeToRemove;
    }


    public Node<E> get(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }
        Node<E> node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    public boolean set(int index, E newValue) {
        Node<E> node = get(index);
        if (node == null) return false;
        node.value = newValue;
        return true;
    }

    public boolean insert(int index, E value) {
        if (index < 0 || index > length) {
            return false;
        }

        if (index == 0) {
            prepend(value);
        } else if (index == length) {
            append(value);
        } else {
            Node<E> newNode = new Node<>(value);
            Node<E> currentNode = get(index);
            Node<E> prevNode = currentNode.prev;

            newNode.next = currentNode;
            newNode.prev = prevNode;

            prevNode.next = newNode;
            currentNode.prev = newNode;
            length++;
        }
        return true;
    }


    public Node<E> remove(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == (length -1)) {
            return removeLast();
        } else {
            Node<E> node = get(index);
            Node<E> prev = node.prev;
            Node<E> after = node.next;

            prev.next = after;
            after.prev = prev;
            length--;
            node.next = null;
            node.prev = null;
            return node;
        }
    }

    public void printList() {
        Node<E> current = this.head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

}