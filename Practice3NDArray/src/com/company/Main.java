package com.company;

public class Main {

    public static void main(String[] args) {
        int [][] matA = {{1, 2, 3}, {4, 5, 6}}; // 2x3
        int [][] matB = {{7, 8, 9}, {6, 5, 4}}; // 2x3

        int [][] A2 = new int [matA.length][matA[0].length]; // 직접 2, 3 으로 지정할 수 있지만 A행렬과 똑같이 만들기위해 A행렬 변수로

        for (int i = 0; i < matA.length; i ++){
            for(int j = 0; j < matA[i].length; j ++){
                A2[i][j] = matA[i][j] + matB[i][j];
            }
        }
        //향상된 for문
        for(int [] row: A2){
            for(int elem : row){
                System.out.printf("%d ", elem);
            }
            System.out.println("");
        }
        //

        System.out.println("*===============================");

        //transpose
        int [][] matA_ = new int[matA[0].length][matA.length];
        for (int i = 0; i < matA.length; i++) {
            for (int j = 0; j < matA[0].length; j++) {
                matA_[j][i] = matA[i][j];
            }
        }

        for (int [] array: matA_) {
            for (int val: array) {
                System.out.printf("%d ", val);
            }
            System.out.println("");
        }
    }
}
