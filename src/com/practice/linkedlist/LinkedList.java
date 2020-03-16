package com.practice.linkedlist;

public class LinkedList {
    class Node{
        public Node next;
        public int value;
        public Node(int value1){
            value=value1;
        }
    }
    private Node head;
    public LinkedList(int value) {
        this.head = new Node(value);
    }

    public LinkedList(){}

    public void addToTail(int value){
        if(head==null){
            head=new Node(value);
        }
        else {
            Node newNode=new Node(value);
            Node current=head;
            while (current.next!=null){
                current=current.next;
            }
            current.next=newNode;
        }
    }
    public void deleteDuplicates(){
        if (head==null) return;
        Node current=head;
        while (current!=null && current.next!=null){
            if(current.value==current.next.value){
                current.next=current.next.next;
            }
            else {
                current=current.next;
            }
        }
    }
    public Node getHead(){
        return head;
    }
     public void show(){
        Node current=head;
        StringBuilder stringBuilder=new StringBuilder("'");
        while (current!=null){
            stringBuilder.append(current.value);
            stringBuilder.append("-->");
            current=current.next;
        }
        stringBuilder.append("'");
         System.out.println(stringBuilder);

     }

}
