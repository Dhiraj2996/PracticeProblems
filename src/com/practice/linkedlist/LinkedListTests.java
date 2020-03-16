package com.practice.linkedlist;

import org.junit.jupiter.api.Test;

public class LinkedListTests {
    @Test
    public void test(){
        LinkedList linkedList = new LinkedList(1);
        linkedList.addToTail(2);
        linkedList.addToTail(3);
        linkedList.addToTail(4);
        linkedList.addToTail(5);
        linkedList.addToTail(6);
        linkedList.addToTail(7);
        linkedList.addToTail(8);
        linkedList.show();
        LinkedList.Node node = swapNodes(linkedList);
        show(node);

    }
    public void show(LinkedList.Node head){
        LinkedList.Node current=head;
        StringBuilder stringBuilder=new StringBuilder("'");
        while (current!=null){
            stringBuilder.append(current.value);
            stringBuilder.append("-->");
            current=current.next;
        }
        stringBuilder.append("'");
        System.out.println(stringBuilder);

    }

    public LinkedList.Node swapNodes(LinkedList linkedList){
        LinkedList.Node head = linkedList.getHead();
        LinkedList.Node current = head;
        while (current !=null && current.next!=null){
            if(current==head){
                head=current.next;
                current = swapAdjacentNodes(null, current);
            }
            else {
                current = swapAdjacentNodes(current, current.next);
            }
            current=current.next;
        }
        return head;
    }

    private LinkedList.Node swapAdjacentNodes(LinkedList.Node prev,LinkedList.Node current) {
        LinkedList.Node next = current.next;
        current.next= current.next.next;
        next.next= current;
        if(prev!=null)
            prev.next=next;
        return next;


    }
}
