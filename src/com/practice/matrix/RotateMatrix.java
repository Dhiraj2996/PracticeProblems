package com.practice.matrix;

import org.junit.jupiter.api.Test;

public class RotateMatrix {
    public static final int MATRIX_LENGTH=4;

    public int[][] initiateMatrix(){
        int matrix[][]=new int[MATRIX_LENGTH][MATRIX_LENGTH];
        int count=0;
        for (int i=0;i<MATRIX_LENGTH;i++){
            for(int j=0;j<MATRIX_LENGTH;j++){
                count++;
                matrix[i][j]=count;
            }
        }
        return matrix;
    }

    @Test
    public void testRotate(){
        int[][] matrix = initiateMatrix();
        printMatrix(matrix);
        rotateMatrixby90(matrix);
        rotateMatrixby90InPlace(matrix);
        spiralMatrix(matrix);

    }

    private void spiralMatrix(int[][] matrix) {
        int n = MATRIX_LENGTH-1;
        int row=0;
        int col=0;
        while (row<n && col<n){
            for(int i=col;i<=n;i++){
                System.out.print(matrix[row][i]+"\t");
            }
            for(int i=row+1;i<=n;i++){
                System.out.print(matrix[i][n]+"\t");

            }
            if(row<n && col<n){
                for(int i=n-1;i>=col;i--){
                    System.out.print(matrix[n][i]+"\t");
                }
                for(int i=n-1;i>row;i--){
                    System.out.print(matrix[i][col]+"\t");

                }
            }
            row++;
            col++;
            n--;
        }

    }

    private void rotateMatrixby90InPlace(int[][] matrix) {
        int n = MATRIX_LENGTH;
        for(int x = 0; x<= n /2; x++){
            for(int y=x;y< n -x-1;y++){
                int temp=matrix[x][y];
                matrix[x][y]=matrix[y][n-1-x];
                matrix[y][n-1-x]=matrix[n-1-x][n-1-y];
                matrix[n-1-x][n-1-y]=matrix[n-1-y][x];
                matrix[n-1-y][x]=temp;
            }
        }
        printMatrix(matrix);
    }

    private void rotateMatrixby90(int[][] matrix) {
        int[][] rotatedMatrix=new int[MATRIX_LENGTH][MATRIX_LENGTH];
        for (int i=MATRIX_LENGTH-1;i>=0;i--){
            for(int j=0;j<MATRIX_LENGTH;j++){
                System.out.print(matrix[j][i]+"\t");
                rotatedMatrix[MATRIX_LENGTH-1-i][j]=matrix[j][i];
            }
            System.out.println("");
        }
        printMatrix(rotatedMatrix);
    }

    private void printMatrix(int[][] matrix) {
        System.out.println("_________________________________________________________");
        for (int i=0;i<MATRIX_LENGTH;i++){
            for(int j=0;j<MATRIX_LENGTH;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println("");
        }
        System.out.println("_________________________________________________________");

    }

}
