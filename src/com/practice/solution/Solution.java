package com.practice.solution;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0])
                    return 1;
                if(o1[0]<o2[0])
                    return -1;
                return 0;
            }
        });

        Stack<int[]> stack=new Stack<>();
        stack.push(intervals[0]);

        List<int[]> result=new ArrayList<>();
        for (int[] interval : intervals) {
            int[] top = stack.peek();
            if(interval[0]<=top[1]){
                int[] pop = stack.pop();
                pop[1]=Math.max(interval[1],pop[1]);
                stack.push(pop);
            }
            else {
                stack.push(interval);
            }

        }

        return stack.toArray(new int[result.size()][]);
    }

    @Test
    public void pal(){
        //System.out.println(breakPalindrome("a"));
        //System.out.println(breakPalindrome("aa"));
        System.out.println(checkRecord("PPALLP"));
        System.out.println(checkRecord("PPALLL"));
        System.out.println(checkRecord("AAAA"));
    }
    public String breakPalindrome(String palindrome) {
        int length=palindrome.length();
        if(length==1){
            return "";
        }

        int i;
        for(i=0;i<length/2;i++){
            if(palindrome.charAt(i)>'a'){
                palindrome=palindrome.substring(0, i)
                        + 'a'
                        + palindrome.substring(i + 1);
                break;
            }
        }
        if((i>=(length/2))){
            palindrome=palindrome.substring(0, length-1)
                    + 'b';
        }
        return palindrome;
    }

    public boolean checkRecord(String s) {
        return !s.contains("LLL") && (s.split("A",3).length < 3);
    }

    @Test
    public void testcase2(){
        int[] a=new int[]{1,-2,-5,0,10};
        int[] b=new int[]{0,-2,-1,-7,-4};
        System.out.println(maxAbsValExpr(a,b));
    }

    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int max=-1;
        int min=10000000;
        int maxIndex=-1;
        int minIndex=-1;

        for(int i=0;i<arr1.length;i++){
            int abs = Math.abs(arr1[i] + arr2[i] + i);
            if(abs>max){
                max=abs;
                maxIndex=i;
            }
            if(abs<min){
                min=abs;
                minIndex=i;
            }
        }

        //return Math.abs(arr1[ptr1]-arr1[ptr2])+Math.abs(arr2[ptr1]-arr2[ptr2])+Math.abs(ptr1-ptr2);
        return Math.abs(max-min);
    }

    @Test
    public void testCaseLuckyNum(){
        int[][] matrix=new int[][]{{3,7,8},{9,11,13},{15,16,17}};
        luckyNumbers(matrix);
    }
    public List<Integer> luckyNumbers (int[][] matrix) {
        Map<Integer,Integer> rowMins=new HashMap<>();
        Map<Integer,Integer> colMax=new HashMap<>();

        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                rowMins.put(i,Math.min(matrix[i][j],rowMins.getOrDefault(i, 1000000)));
                colMax.put(j,Math.max(matrix[i][j],colMax.getOrDefault(j, -1)));
            }
        }
        List<Integer> result =colMax.values().stream().collect(Collectors.toList());
        result.retainAll(rowMins.values());
        return result;

    }
}
