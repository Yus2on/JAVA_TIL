package com.company;
/**
 * 링카운터 출력기
 *
 * 크기가 4인 링카운터는 아래와 같이 동작한다.
 *
 * 0b0001 -> 0b0010 -> 0b0100 -> 0b1000 -> 0b0001 ...
 *
 * 즉, 링카운터는 하나의 비트만 1의 값을 가지며 1의 위치가 N번마다 반복되는 형태로 동작한다.
 *
 * 링카운터의 크기 numBits와 카운트된 횟수 numCount를 이용하여
 * 현재 링카운터의 값을 10진수로 출력하는 프로그램을 작성하시오.
 */
public class Main {

    public static void main(String[] args) {
        int numBits = 12; // 링카운터 크기
        int numCount = 19; // 카운트 횟수

        //case 1
        int temp;
        String res = "";

        for(int i = 0; i<=numCount; i++){ //i가 numCount 이하일 때 반복문 종료
            temp = i;
            if(temp >= numBits){
                temp = temp % numBits;
            }
            System.out.printf("0b%12s\n",(Integer.toBinaryString( 1 << temp)));
            res = (Integer.toBinaryString( 1 << temp));
        }
        System.out.println("현재 링카운터 값 : " + Integer.parseInt(res, 2));

        /*
            1. 시작 숫자 정하고 ex: 1 이면서 numBits 가 4일때  -> 0001
            2. 0001을 shift해서 0010으로 변경(수업참조)
            3. 1000이 되면 다시 0001로 (반복)
            4. 19번째 된 값을 10진수로 변경해서 출력
        */

        //case 2
        System.out.println("현재 링카운터 값 : " + (1 << (numCount % numBits)));
    }
}
