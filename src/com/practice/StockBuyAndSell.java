package com.practice;

import java.util.*;
import java.lang.*;
import java.io.*;


public class StockBuyAndSell {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        for (int j = 0; j < testcases; j++) {
            int n = sc.nextInt();
            Integer array[] = new Integer[n];

            for (int i = 0; i < n; i++) {
                array[i]=sc.nextInt();
            }
            maximiseProfit(array);
        }
    }

    /**
     * @param array
     * This problem needs to be solved by finding local minima and local maxima
     * local minima: next element in array is greater
     * local maxima: next element in array is less
     */
    private static void maximiseProfit(Integer[] array) {
        int currentminIndex=0;
        int currentmaxIndex=0;
        StringBuilder stringBuilder=new StringBuilder();
        for(int index=1;index< array.length;index++){
            Integer next = array[index];
            if(next>array[currentminIndex]){
                if(next>array[currentmaxIndex]){
                    currentmaxIndex=index;
                }
            }
            else {
                if(currentmaxIndex!=currentminIndex){
                    stringBuilder.append("("+currentminIndex+" "+currentmaxIndex+")");
                }
                currentminIndex=index;
                currentmaxIndex=index;
            }
        }
        if(currentmaxIndex!=currentminIndex){
            stringBuilder.append("("+currentminIndex+" "+currentmaxIndex+")");
        }
        System.out.println(stringBuilder);
    }

}
