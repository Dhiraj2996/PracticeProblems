package com.practice.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class CustomStack {
    private List<Integer> Mystack=new ArrayList<>();
    private Integer maxsize;
    private Integer currentSize;

    public CustomStack(int maxSize) {
        maxsize =maxSize;
        currentSize=-1;

    }

    public void push(int x) {
        if(currentSize< maxsize){
            Mystack.add(x);
            currentSize++;
        }
    }

    public int pop() {
        if(currentSize==-1){
            return -1;
        }
        Integer pop = Mystack.get(currentSize);
        currentSize--;
        return pop;

    }

    public void increment(int k, int val) {
        int numOfIteration=k<currentSize+1?k:currentSize+1;
        for(int i=0;i<numOfIteration;i++){
            Integer remove = Mystack.remove(i);
            Mystack.add(i,remove+val);
        }
    }
}