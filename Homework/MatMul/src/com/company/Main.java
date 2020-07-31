package com.company;
/**
 * 행렬의 곱 계산하기
 *
 * 두 행렬의 곱을 구하는 프로그램을 작성하시오.
 * 행렬의 곱을 계산한 후에 행렬 형태로 출력하시오.
 *
 *
 * 인자
 * matA: N x M 행렬
 * matB: M x K 행렬
 */
public class Main {


    public static void main(String[] args) {
        //N x K
        int [][] matA = {
                            {1, 2, 3} ,
                            {4, 5, 2}
                        }; // 2 x 3 행렬
        int [][] matB = {
                            {5, 2},
                            {6, 2},
                            {1, 0}
                        }; // 3 x 2 행

        int[][] res = new int[matA.length][matB[0].length];

        for(int i = 0; i < matA.length; i++){ // A행렬 2
            for(int k = 0; k < matB[0].length; k++){ // B행렬 2
                for(int j = 0; j < matA[0].length ; j++ ){ // 3
                    res[i][k] += matA[i][j] * matB[j][k];
                }
                System.out.printf("%d ", res[i][k]);
            }
            System.out.println("");
        } // end for

    }
}
