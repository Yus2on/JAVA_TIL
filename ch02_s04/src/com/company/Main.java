package com.company;

/*
* 연산자(Operator)
* 피연산자(Operand)
* 연산자, 피연산자 -> 연산식(Expression)
* 사칙 연산자 : + - * /
* 비교 연산자 : < > <= >=
* 논리 연산자
* 증감 연산자
* 삼항 연산자
* 비트 연산자
*
*
* */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       //사칙연산 //이항연산
        int x = 10, y= 20, z;
        z = x + y; // + : 피연산자 x,y : 연산자 x+y : 연산식(Expression)
                    // 대입도 연산자 //  =: 연산자 z : 피연산자 x+y: 피연산자
                    // 대입 연산자의 우선 순위가 가장 낮기 때문에 가장 마지막에 실행

        //System.out.println(z);


        //정수형 사칙 연산
//        System.out.println(20 - 5);
//        System.out.println(5 - 20);
//        System.out.println(10 * 8);
 //      System.out.println(16 / 8); // 정수 나누기 -> 몫(소수점 버림)
//       System.out.println(17 % 8); // modulus 연산, 나머지

        //실수형 사칙 연산
        System.out.println(10.0 - 52.3); // res : -42.3
        System.out.println(10.5f - 12.3);
        // float, double 이 같이 연산되면 double로 변한 후 연산
        // res : -1.8000000000000007

        System.out.println(10.4 - 50);
        // 실수형, 정수형 같이 연산하면 실수형으로 변환 후 연산
        // res : -39.6

        System.out.println(150 / 8.0);
        // 실수로 나누면 소수점까지 계산
        // res : 18.75

        System.out.println(5.2 / 1.2);
        // 몫이 아니고 실수 값으로 계산 됨
        // res : 4.333333333333334

        System.out.println(5.2 % 1.2);
        //실수 나눗셈도 modulus 연산으로 나머지 계산 가능
        // 부동수소점->오차생김
        // res : 0.40000000000000036

//        System.out.println("사칙연산의 중요성!!!!!");
//        System.out.println(Integer.MAX_VALUE / 2 * 3 ); //-1073741827 //값이 넘쳐서 overflow됨
//        System.out.println(Integer.MAX_VALUE); // 2147483647 // 가장 큰 값
//        System.out.println(Integer.MAX_VALUE+1 ); //-2147483648 // +1이 되니까 가장 작은 값이 됨
                                                // overflow
                                                // MIN_VALUE 일때도 동일


        // 맨 앞자리가 0 -> 양수, 1 -> 음수
        // 음수를 표현하기 위한 방법
        // 0과 1을 뒤집은 다음에 + 1 => 1's complement


//        System.out.println("실수 사칙연산의 조심할 점!!!!!");
//        System.out.println( (6 - 5.9) * 10 ); // 정밀도 떨어져서 0.999999999.....
//        System.out.println(Math.floor((6 - 5.9) * 10)); // 0.0 // 정밀도 문제로 1이 나오지 않음
//
//        //수식은 문제가 없지만 값에서 문제가 생길 경우 NaN //연쇄
//        System.out.println( 40 / 0.0 ); //Infinity // 매우 큰 숫자
//        System.out.println( 40 % 0.0); // NaN == Not a Number (숫자가 아니다, 계산 불가능)
        // 정수를 0으로 나누면 by zero


        ///////////////
        // 대입 연산자
        z += 10; // z = z + 10; 을 줄인 형태
        z %= 10; // modulus, 비트, 논리 연산자 가능

        // 비교 연산자
        // 출력이 boolean으로 나옴
//        System.out.println(10 > 20); // 거짓 : false
//        System.out.println( 10 < 20); // 참 : true
//        System.out.println( 10 >= 10); // true;
//
//        x= 10; y=10;
//        System.out.println(x == y); // true
//        System.out.println(x != y); // false
//        System.out.println("");


        // 논리 연산자
        // 입출력이 모두 boolean
        // a AND b : a, b 모두 참일 때만 참
        // a OR b : a 또는 b 둘 중 하나만 참이어도 참
        // a XOR b : a 또는 b 둘 중 하나만 참이어야 참 //exclusive or, 배타적 or
        // NOT a : a 가 참이면 거짓, 거짓이면 참
//        System.out.println(10 < 20 & 40 >= 2); //true
//        System.out.println(40 < 2 | 1 > 0); //1 거짓, 2 참 -> true
//        System.out.println(!true);  //false
//        System.out.println(!false); //true
//        System.out.println(!(10 > 20)); // 10이 20보다 크지 않아서 false 인데 not 이라서 true
//        System.out.println(10 > 2 ^ 5 > 2); // ^ : XOR //둘다 true 라서 false

        //////////////
        // short-circuit = && , || (NOT, XOR은 두번 쓰기 불가능)
        // && 앞 조건이 false면 뒤 조건은 검사하지 않음
        // || 하나만 참이어도 뒤는 검사하지 않음
        int a = 0;
        int b = 0;
        System.out.println(a > 0 & b > 0 ); // false
        System.out.println(a++ > 0 & b++ > 0); //false
        System.out.println(a + ", " + b); // 1, 1
                                        // && 이면 출력은 1, 0.
        //        System.out.println(10 > 20 || 20 < 50);
        //////////////


        //증감 연산자(단항 연산자)
        int val = 0;
       // System.out.println(val++); //val = 0 으로 먼저 Expression 평가 후 val += 1;
        //sout(val);
        //val += 1;
        // System.out.println(val); // val == 1;

     //   System.out.println(++val); // val +=1 을 먼저 계산 후 Expression 평가
        //val += 1;
        //sout(val)

     //   System.out.println(val--);
        //sout(val);
        //val -= 1;
        // System.out.println(val); // val == -1;

     //   System.out.println(--val);
        //val -= 1;
        //sout(val)


        val = 5;
        int new_val = val++ * 10 + --val;
        // 1. 5 * 10 = 50 -> val = 6인 상태로 10 + --된 val(5) = 55
//        System.out.println(new_val);
//        System.out.println("");


        //삼항 연산자
        // (cond)  ?  (true expression):(false expression);
        // boolean           값                값
    //    System.out.println(true ? 1 : 0 ); // 1

        x = 10;
        y = 30;

     //   System.out.println(x > y ? x : y);



       // 비트 연산자
       // 정수형 연산에 사용
//       System.out.printf("b%32s\n", Integer.toBinaryString(8));
//       System.out.printf("b%32s\n", Integer.toBinaryString(8 >> 1)); // shift 연산자
//                                                                        // 오른쪽으로 한칸씩 옮김
//                                                                        // 값이 반으로 줄어듦
//       System.out.printf("b%32s\n", Integer.toBinaryString(7)); // 111
//       System.out.printf("b%32s\n", Integer.toBinaryString(7 >> 1)); // 11
//       System.out.printf("b%32s\n", Integer.toBinaryString(7 >> 2)); // 1

//        System.out.printf("b%32s\n", Integer.toBinaryString(1423)); // 10110001111
//        System.out.printf("b%32s\n", Integer.toBinaryString(1423 >> 1)); // 1011000111
//        System.out.printf("b%32s\n", Integer.toBinaryString(1423 >> 2)); // 101100011
//        System.out.printf("b%32s\n", Integer.toBinaryString(1423 >> 3)); // 10110001
//
//        System.out.printf("b%32s\n", Integer.toBinaryString(1423 << 1)); // 101100011110
//        System.out.printf("b%32s\n", Integer.toBinaryString(1423 << 2)); // 1011000111100
//        System.out.printf("b%32s\n", Integer.toBinaryString(1423 << 3)); // 1011000111100
//        System.out.println("");
//
//        System.out.printf("b%32s\n", Integer.toBinaryString(-1)); // b11111111111111111111111111111111
//        System.out.printf("b%32s\n", Integer.toBinaryString(-1 >> 1)); // b11111111111111111111111111111111
//        System.out.printf("b%32s\n", Integer.toBinaryString(-1 >>> 1)); // b 1111111111111111111111111111111
//        System.out.println("");

        int intVal = 4123;
        intVal >>= 2; // intVal = intVal >> 2; shift 연산자도 대입 연산자 가능
        intVal |= 412; //intVal = intVal | 412; Bitwise 연산자도 대입 연산자 가능


//        System.out.printf("b%32s\n", Integer.toBinaryString(1252));
//        System.out.printf("b%32s\n", Integer.toBinaryString(125234));
//        System.out.printf("b%32s\n", Integer.toBinaryString(1252 & 15234));
//        System.out.printf("b%32s\n", Integer.toBinaryString(1252 | 15234));
//        System.out.printf("b%32s\n", Integer.toBinaryString(1252 ^ 15234));
//        System.out.printf("b%32s\n", Integer.toBinaryString(~1252)); // NOT
//        System.out.println("");




//
//        System.out.printf("%5d.\n", 10);  // 우측정렬 // 변수사용 불가능
//        System.out.printf("%-5d.\n", 10);  // 좌측정렬
//        System.out.printf("%05d.\n", 234);
//        System.out.printf("%3d.\n", 104294);













    }
}
