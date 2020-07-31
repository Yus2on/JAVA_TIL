package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.lang.reflect.Array;

/**
 * 배열의 연속합 최대 구하기
 *
 * 정수 배열에서 연속된 값의 합의 최대값을 구하시오.
 *
 * ex1) {1, 45, -2, 5, -6} => 1 + 45 + (-2) + 5 = 49
 * ex2) {-4, 5, 12, -7, 52, -5, 7} => 5 + 12 + (-7) + 52 + (-5) + 7 = 64
 *
 *
 * 인자
 * integers: 정수 배열
 */
public class Main {

    public static void main(String[] args) {
        int [] integers = {-4, 7, 14, 9, -5, 4, 16, -22, 31};
        int length = integers.length;
        int ret = 0;

        for (int i = 0; i < length; i++) { // 9번씩 반복을 함
            int sum = 0; // 0으로 초기화

            for (int j = i; j < length; j++) {
                sum += integers[j]; // 배열 증감식을 sum에 계속 더해줌 // sum = integers[j] + sum;
                //System.out.print(" "+integers[j]);
                ret = Math.max(ret, sum); // 큰 수를 찾아서 ret에 대입
            }
        }
        System.out.println(ret);
    }
}

