package com.practice.twopointers;

public class Test {
    @org.junit.jupiter.api.Test
    public void test(){
        //int[] array=new int[]{0,1,0,3,12};
        //swapZerosToEnd(array);

        int[] sortedArray=new int[]{2,5,7,11,15};
        int[] sum = twoSum(sortedArray, 16);

            System.out.println("Indexes for sum ::"+sum[0]+" and "+sum[1]);

    }

    private int[] twoSum(int[] sortedArray,int sum) {
        int lowPointer=0;
        int highPointer=sortedArray.length-1;
        int[] returnArray=new int[2];
        while (lowPointer<highPointer){
            int currentSum = sortedArray[lowPointer] + sortedArray[highPointer];
            if(currentSum==sum){
                returnArray[0]=lowPointer;
                returnArray[1]=highPointer;
                return returnArray;
            }
            else if(currentSum > sum){
                highPointer--;
            }
            else {
                lowPointer++;
            }
        }
        returnArray[0]=-1;
        returnArray[1]=-1;
        return returnArray;
    }

    private void swapZerosToEnd(int[] array) {
        int length = array.length;

        int reader=0;
        int writer=0;
        while(reader<length){
            if(array[reader]!=0){
                array[writer]=array[reader];
                writer++;
            }
            reader++;
        }
        while (writer<length){
            array[writer]=0;
            writer++;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(" "+array[i]);

        }
    }

    private void swapValues(int[] array, int indexZero, int i) {
        int temp=array[i];
        array[i]=array[indexZero];
        array[indexZero]=temp;
    }
}
