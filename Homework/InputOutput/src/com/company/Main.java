package com.company;

import java.util.Scanner;

/**
 * 입력받아 처리하기
 *
 * 3개의 정수를 입력받아, 그 중 최대값을 출력하고자 한다.
 * 이를 수행하는 프로그램을 작성하시오.
 *
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("숫자 1 : ");
        int num1 = scanner.nextInt();

        System.out.print("숫자 2 : ");
        int num2 = scanner.nextInt();

        System.out.print("숫자 3 : ");
        int num3 = scanner.nextInt();

        int maxNum = (num1 > num2 ? num1 : num2 ) > num3 ? (num1 > num2 ? num1 : num2 ) : num3;

        System.out.print("최대값  : " + maxNum);
    }
}