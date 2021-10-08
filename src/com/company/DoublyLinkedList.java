package com.company;

import java.util.Objects;

public class DoublyLinkedList implements MyList {
    public class Node<T> {

        T value;
        Node next;
        Node prev;

        public Node(T value) {
            this.value = value;
        }
    }

    Node first;
    Node last;
    private int size;

    @Override
    public Object get(int index) {
        if (index < (size() / 2)) {
            if (first == null) {
                return null;
            }
            Node current = first;
            int count = 0;
            while (current != null) {
                if (count == index) {
                    return current.value;
                }
                count++;
                current = current.next;
            }
        } else {
            Node current = last;
            int count = size() - 1;
            while (current != null) {
                if (count == index) {
                    return current.value;
                }
                count--;
                current = current.prev;
            }
        }
        return null;
    }

    @Override
    public void add(Object obj) {
        Node node = new Node(obj);
        if (first == null) {
            first = node;
            last = node;
            size++;
            return;
        }
        last.next = node;
        node.prev = last;
        last = node;
        size++;
    }

    @Override
    public void remove(int index) {
        if (first == null) {
            return;
        }
        Node current = first;
        if (index == 0) {
            first = current.next;
            first.prev = null;
            size--;
            return;
        }
        for (int i = 0; i < index - 1; i++)
            current = current.next;
        if (current == null || current.next == null) {
            return;
        }
        Node next = current.next.next;
        Node prev = current.next.prev;
        current.next = next;
        current.prev = prev;

        size--;
    }

    @Override
    public boolean remove(Object obj) {
        Node current2 = new Node(null);
        Node current = new Node(obj);
        current = first;
        current2 = first;
        if (first.value.equals(obj)) {
            first = first.next;
            first.prev = null;
            size--;
            return true;
        }
        for (int i = 0; i < size - 1; i++) {
            current = current2.next;
            if (current.value.equals(obj)) {
                if (i == (size - 2)) {
                    current.next = null;
                    last = current.prev;
                    size--;
                    return true;
                } else {
                    current.next.prev = current2;
                    current2.next = current.next;
                }
                size--;
                return true;
            }
            current2 = current2.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object obj) {
        Node current = first;
        while (current != null) {
            if (current.value == obj) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoublyLinkedList that = (DoublyLinkedList) o;
        return size == this.size() && Objects.equals(first, this.first) && Objects.equals(last, this.last);
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = first;
        for (int i = 0; i < size; i++) {
            result.append(current.value);
            if (i < size - 1) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }
}
