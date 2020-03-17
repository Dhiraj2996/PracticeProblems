package com.practice.heap;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HeapTests {
    @Test
    public void sortCharsByFrequency(){
        /*
        * Given a string sort it in decreasing order based on frequency of characters
        * e.g. Input: "tree"
        *       Output: "eetr" ..."eert" is also valid output*/

        String str="tree";
        PriorityQueue<Map.Entry<Character,Integer>> priorityQueue=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        Map<Character,Integer> charMap=new HashMap<>(0);
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            charMap.put(c,charMap.getOrDefault(c,0)+1);
        }
        priorityQueue.addAll(charMap.entrySet());
        StringBuilder sb=new StringBuilder();
        while (!priorityQueue.isEmpty()){
            Map.Entry<Character, Integer> poll = priorityQueue.poll();
            for (int i=0;i<poll.getValue();i++){
                sb.append(poll.getKey());
            }
        }
        System.out.println(sb);

    }
    @Test
    public void kthSmallestElement(){
        /*
         * Find kth smallest element in unsorted array
         * */

        int k=3;
        int array[]=new int[]{3,2,1,5,6,4};
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>((a,b)->a-b);
        for (int val : array) {
            priorityQueue.add(val);
        }
        int kthMin=-1;
        for(int i=0;i<k;i++){
            kthMin=priorityQueue.poll();
        }
        System.out.println(kthMin);

    }
}
