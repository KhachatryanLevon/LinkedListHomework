package com.company;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Integer q = 1;
        Integer w = 2;
        Integer d = 3;
        Integer c = 4;
        /*
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(d);
        singlyLinkedList.add(c);
        singlyLinkedList.add(d);
        singlyLinkedList.add(c);
        System.out.println(singlyLinkedList.toString());
        singlyLinkedList.remove(c);
        System.out.println(singlyLinkedList.toString());
        singlyLinkedList.add(c);
        System.out.println(singlyLinkedList.size());
        System.out.println(singlyLinkedList.toString());
        singlyLinkedList.remove(3);
        System.out.println(singlyLinkedList.toString());
        System.out.println(singlyLinkedList.get(3));
        System.out.println(singlyLinkedList.contains(3));
        System.out.println(singlyLinkedList.contains(6));
                 */

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(q);
        doublyLinkedList.add(w);
        doublyLinkedList.add(q);
        doublyLinkedList.add(c);
        doublyLinkedList.add(d);
        doublyLinkedList.add(q);

        System.out.println(doublyLinkedList.toString());
        /*
        for (int i = 0; i < 7; i++) {
            System.out.println(doublyLinkedList.get(i));
        }
        System.out.println(doublyLinkedList.toString());
         */
        //doublyLinkedList.remove(1);
        //System.out.println(doublyLinkedList.toString());
        doublyLinkedList.remove(q);
        System.out.println(doublyLinkedList.toString());
        doublyLinkedList.remove(q);
        System.out.println(doublyLinkedList.toString());
        doublyLinkedList.remove(d);
        System.out.println(doublyLinkedList.toString());

    }
}
