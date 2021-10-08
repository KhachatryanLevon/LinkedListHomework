package com.company;

import java.util.Objects;

public class SinglyLinkedList implements MyList {

    public class Node<T> {

        T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    Node first;
    Node last;
    private int size;

    @Override
    public Object get(int index) {
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
            size--;
            return;
        }
        for (int i = 0; i < index - 1; i++)
            current = current.next;
        if (current == null || current.next == null) {
            return;
        }
        Node next = current.next.next;
        current.next = next;
        size--;
    }

    @Override
    public boolean remove(Object obj) {
        Node current = new Node(obj);
        current.next = first;
        if (first.equals(obj)) {
            current.next = first.next;
            size--;
            return true;
        }
        for (int i = 0; i < size; i++) {
            if (current.next.value.equals(obj)) {
                if (i == (size - 1)) {
                    current.next = null;
                    last = current;
                    size--;
                    return true;
                } else {
                    current.next = current.next.next;
                }
                size--;
                return true;
            }
            current = current.next;
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
        SinglyLinkedList that = (SinglyLinkedList) o;
        return size == that.size && Objects.equals(first, that.first) && Objects.equals(last, that.last);
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
