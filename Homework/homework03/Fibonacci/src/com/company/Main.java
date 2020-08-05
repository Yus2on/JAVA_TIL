package com.company;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
	// write your code here

        /**
         * 피보나치 수열 0, 1, 1, 2, 3, 5, 8
         *
         * 피보나치 수열을 출력하는 프로그램을 작성하시오.
         *
         * 피보나치 수열의 점화식 :  f(n)= f(n-1) + f(n-2)
         *                        f(1) = 0, f(2) = 1
         *
         * 0, 1, 1, 2, 3, 5, 8, ...
         *
         * 인자
         * seqLength: 출력하고자 하는 피보나치 수열의 길이
         */

        int seqLength = 100; //상한값
        // write codes here

        /*
         *  BigInteger zero = BigInteger.ZERO;
         *  BigInteger는 임의 자리의 정수를 표현하는 클래스
         *
         */
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger c;

        System.out.println(0);

        if(seqLength >= 2)
            System.out.println(1);

        for(int i = 2; i<seqLength; i++){
            c = a.add(b); // c = a + b
            a = b;
            b = c;
            System.out.println(c);
        }
    }
}
