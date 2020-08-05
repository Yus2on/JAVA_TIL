package com.company;
/*
* Array 연습
*
* 1. 배열에서 최대값을 찾는 프로그램
* 2. 1번과 같은 배열에서 두번째로 큰 값을 찾는 프로그램
* */
public class Main {

    public static void main(String[] args) {
        int [] integers = {4, 2, 12, 23, 62, 9, -2, 0, 1, -4};
        int max = integers[0]; //첫번째 값으로 초기화

        //Q1 - case 1
        for(int i = 0; i<integers.length; i ++){
            if (max < integers[i]) { // max보다 크면 대체하는 로직
                max = integers[i];
            }
        } //end for
        //System.out.println(max);



        //Q1 - case2
        for(int val : integers){
            max = max > val ? max : val;
        }
        //System.out.println(max);

        //------------------------------------------
        //Q2 - case1
        //int [] integers = {4, 2, 12, 23, 62, 9, -2, 0, 1, -4};
        max = integers[0]; // 배열의 첫번째 값
        int max2 = integers[1]; // 배열의 두번째 값 -> 두번째로 큰 수를 담을 예정

        for(int i = 0; i<integers.length; i ++){
            if (max < integers[i]) { // max보다 크면 대체하는 로직. max보다 배열의 값이 크다면 타는 로
                max2 = max; // max2를 max값으로 업데이트해줌 ..
                max = integers[i]; // max에 가장 큰 값을 계속 넣어줌 직

            }else if (max2 > integers[i] ){ // max2는 배열의 두번째 값
                max2 = integers[i];
            }
        }



        //Q2 - case2 max 2 == maxVal
        int [] maxVal = new int[2];
        // 없어도 작동은 함 
        //maxVal[0] = integers[0] > integers[1] ? integers[0] : integers[1];
        //maxVal[1] = integers[0] < integers[1] ? integers[0] : integers[1];
        for(int val: integers){
            if(maxVal[0] < val){
                maxVal[1] = maxVal[0];
                maxVal[0] = val;
            }else if(maxVal[1] < val){
                maxVal[1] = val;
            }
        }
        System.out.println(maxVal[1]);






    }
}
