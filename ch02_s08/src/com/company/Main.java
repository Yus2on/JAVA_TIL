package com.company;

/*
* N - D Array
* 배열이 배열을 담고 있으면, 다차원 배열이라 한다. (N-D Array)
* 수학에서 말하는 점 -> 선 -> 면 -> 공간 -> 4차원 -> 5차원
* */
public class Main {

    public static void main(String[] args) {
        //다차원 배열 선언
        int [][] ints;
        // 쓰지 말아야함!
        // [] array1 [];
        // oldCstyle[][];


        int [][] ints1 = new int[10][5]; //길이가 5인 어레이를 담고 잇는 길이가 10인 어레이....
        int [][] ints2 = new int[10][];
        for (int i= 0; i <ints2.length; i++){
            ints2[i] = new int[5];
        }

        // 하위 차원의 길이는 달라질 수 있다.
        // 다차원 배열은 길이가 다른 array도 들어갈 수 잇음
        int [][] ints3 = new int[5][];
        ints3[0] = new int[10];
        ints3[1] = new int[8];
        ints3[2] = new int[4];
        ints3[3] = new int[15];
        ints3[4] = new int[9];

        //초기화
        int [][] ints4 = {{1, 2, 3}, {4, 5, 6}}; // int [2][3] 으로 표기 가능 // 길이가 3인 배열이 두개 들어있음
        int [][] ints5 = {{1, 2, 3}, {7, 8 }, {4, 5, 6}}; // int [3][] 으로 표기 가능
        for(int i = 0; i < ints5.length; i ++){ // length : 3 상위 배열
            System.out.printf("[%d] : ", ints5[i].length  ); // 길이 변하는 거 확인
            for(int j = 0; j < ints5[i].length; j ++) { // 하위배열
                System.out.printf("%d ", ints5[i][j]);
            }
            System.out.println("");
        } // end for



    }
}
