package com.practice.geeksForgeeks;

import java.util.*;
import java.lang.*;

class GFG {
    public static void main (String[] args) {
        //code
        /*int arr[] = {1, 3, 5, 7, 9, 11};
        int n = arr.length;
        SegmentTreeMultiplesOf5  tree = new SegmentTreeMultiplesOf5(arr);
        System.out.println("dummy step");

        // Build segment tree from given array

        // Print sum of values in array from index 1 to 3
        System.out.println("Sum of values in given range = " +
                tree.getSum(n, 1, 3));*/
        Scanner sc=new Scanner(System.in);
        int testCases=sc.nextInt();
        for(int tc=0;tc<testCases;tc++){
            int n=sc.nextInt();
            int q=sc.nextInt();
            int arr[]=new int[n];

            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int l;
            int r;
            SegmentTreeMultiplesOf5 tree = new SegmentTreeMultiplesOf5(arr);
            for(int i=0;i<q;i++ ){
                l=sc.nextInt();
                r=sc.nextInt();
                System.out.print(tree.getSum(n,l-1,r-1)+" ");
            }
            System.out.println("");
        }
    }


}
class SegmentTreeMultiplesOf5 {
    int st[];
    public SegmentTreeMultiplesOf5(int arr[]){
        int n = arr.length;
        int heightOfTree=(int)Math.ceil(Math.log(n)/Math.log(2));
        int maxNumOfNodes=((int)Math.pow(2,heightOfTree+1))-1;
        st=new int[maxNumOfNodes];
        constructST(arr,0,n-1,0);
    }

    private int constructST(int[] array,int startIndex,int endIndex,int current) {
        if(endIndex==startIndex){
            int num = array[startIndex];
            if (num%5==0)
                st[current]= 1;
            else
                st[current]= 0;
            return st[current];
        }
        //else recursively call for left and right childs
        int mid= getMid(startIndex, endIndex);
        st[current]=constructST(array,startIndex,mid,current*2+1)
                +constructST(array,mid+1,endIndex,current*2+2);
        return st[current];
    }

    private int getMid(int startIndex, int endIndex) {
        return startIndex+((endIndex-startIndex)/2);
    }

    public int getSum(int n,int l,int r){
        if(l<0||r>n-1||l>r){
            System.out.println("invalid input range");
            return -1;
        }
        return getSumUtil(0,n-1,l,r,0);
    }
    public int getSumUtil(int startIndex,int endIndex,int qStart,int qEnd,int current){
        if(qStart<=startIndex&&qEnd>=endIndex){
            return st[current];
        }
        if (endIndex < qStart || startIndex > qEnd)
            return 0;

        int mid = getMid(startIndex, endIndex);
        return  getSumUtil(startIndex,mid,qStart,qEnd,2*current+1)+
                getSumUtil(mid+1,endIndex,qStart,qEnd,2*current+2);


    }

}