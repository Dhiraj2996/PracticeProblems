package com.practice.linkedlist;



public class MergeSortedLinkedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;

        ListNode mergedListhead=new ListNode(-1);
        ListNode currNode=mergedListhead;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                currNode.next=l1;
                l1=l1.next;
            }
            else {
                currNode.next=l2;
                l2=l2.next;
            }
            currNode=currNode.next;
        }
        while (l1!=null){
            currNode.next=l1;
            currNode=currNode.next;
            l1=l1.next;
        }
        while (l2!=null){
            currNode.next=l2;
            currNode=currNode.next;
            l2=l2.next;
        }

        return mergedListhead.next;
    }

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
}
