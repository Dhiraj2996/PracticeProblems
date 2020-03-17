package com.practice.geeksForgeeks;

public class SegmentTreeTest {
    

}
class SumSegmentTree {
    int st[];
    public SumSegmentTree(int arr[]){
        int n = arr.length;
        int heightOfTree=(int)Math.ceil(Math.log(n)/Math.log(2));
        int maxNumOfNodes=((int)Math.pow(2,heightOfTree+1))-1;
        st=new int[maxNumOfNodes];
        constructST(arr,0,n-1,0);
    }

    private int constructST(int[] array,int startIndex,int endIndex,int current) {
        if(endIndex==startIndex){
            st[current]=array[startIndex];
            return array[startIndex];
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


    }}
