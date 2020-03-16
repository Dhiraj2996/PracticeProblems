package com.practice.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class MinStack {

    Integer currentMin;
    Stack<Integer> integerStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        integerStack = new Stack<>();
        currentMin = null;
    }

    public void push(int x) {
        if (integerStack.isEmpty()) {
            currentMin = x;
            integerStack.push(x);
        } else {
            if (x < currentMin) {
                integerStack.push(2 * x - currentMin);
                currentMin = x;
            } else {
                integerStack.push(x);
            }
        }
    }

    public void pop() {
        Integer pop = integerStack.pop();
        if (pop < currentMin) {
            currentMin = 2 * currentMin - pop;
        }

    }

    public int top() {
        Integer peek = integerStack.peek();
        if (peek < currentMin) {
            peek = currentMin;
        }
        return peek;
    }

    public int getMin() {
        return currentMin;
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */