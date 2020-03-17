package com.practice.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MajorityChecker {
    private int[] arr;
    public MajorityChecker(int[] arr) {
        this.arr=arr;
    }

    public int query(int left, int right, int threshold) {
        int sublen = right - left + 1;
        if (threshold > sublen) {
            return -1;
        }

        int result=-1;
        Map<Integer,Integer> countMap=new HashMap<>();
        for(int i=left;i<=right;i++){
            countMap.put(arr[i],countMap.getOrDefault(arr[i],0)+1);
            if(countMap.get(arr[i])>=threshold){
                result=arr[i];
                break;
            }
        }
        return result;
    }
}
