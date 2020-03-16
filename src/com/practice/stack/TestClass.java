package com.practice.stack;

import org.junit.jupiter.api.Test;

public class TestClass {

    @Test
    void stackTests(){
        StackLocal s=new StackLocal();
        addNElementsToStack(s,5);
        s.display();

    }

    private void addNElementsToStack(StackLocal s,int n) {
        int i=0;
        while (i<n){
            i++;
            s.push(i);
        }
    }

    @Test
    void testMinStack(){
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    @Test
    public void TestCustomStack(){
        CustomStack minStack = new CustomStack(3);
        minStack.push(0);
        minStack.push(1);
        minStack.push(2);
        System.out.println(minStack.pop());
        minStack.increment(3,100);
        System.out.println(minStack.pop());
    }
}
