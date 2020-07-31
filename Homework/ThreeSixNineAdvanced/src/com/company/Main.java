package com.company;
/**
 * 369게임+
 *
 * 369게임에 참여했을 때, 내가 외쳐야 하는 숫자나 동작을 순서대로 출력하시오.
 *
 * 규칙
 * 1. 3, 6, 9, 5가 포함되지 않은 숫자는 숫자를 외친다. (2!)
 * 2. 숫자에 포함된 3, 6, 9의 개수 만큼 박수를 친다. (짝!)
 * 3. 숫자에 포함된 5의 개수 만큼 발을 구른다. (쿵!)
 * 4. 박수와 발구르기의 순서는 관계 없으나, 반드시 번갈아 수행한다.
 *
 * 예시
 * 2   -> 2!
 * 33  -> 짝!짝!
 * 553 -> 쿵!짝!쿵! (짝!쿵!쿵!x)
 * 47  -> 47!
 *
 * 인자
 * gameLength: 게임이 종료되는 데 걸리는 턴 수
 * numPeople: 게임에 참여하는 인원 수
 * myTurn: 내가 숫자를 외치는 순번
 */
public class Main {

    public static void main(String[] args) {
        int gameLength = 1000;
        int numPeople = 12;
        int myTurn = 7;

        System.out.println("3 6 9 게임 시작 --------------------- \n");

       // for(int i = 1; i <= gameLength; i++) { // 게임 진행
       for(int i = myTurn; i <= gameLength; i+=myTurn) { // 게임 진행 // 내 순서 부터 시작
            int numClap = 0; // 짝의 횟수 - 3 6 9
            int numClap2 = 0; // 쿵의 횟수 - 5

           int tempVal =i;
           //while(tempVal) {  // 0보다 클 동안 계속 추출. 10의로 나눈 나머지 추출
                               //10으로 나눈 나머지가 3, 6 , 9에 속하면 박수 카운트 . 5에 속하면 쿵 카운트

           //}

            int num1 = i / 100; // 100의 자리 몫
            int a = i % 100; // 100의 자리 나머지

            int num2 = a / 10; // 10의 자리 몫 a / 10
            int num3 = a % 10; // 1의 자리 : 10 나머지 89 % 10 = 9 나머지

            // 내 순서 체크 -> 내 순서가 아니면 끊고 for문 다시 시작
            if ((i - myTurn) % numPeople != 0) {
                continue;
            }

            //1의 자리가 3, 6, 9일 때 체크
            if (num3 == 3 || num3 == 6 || num3 == 9) {
                numClap++;
            }

            // 10의 자리가 3, 6 ,9 일떄 체크를
            if(num2 == 3 || num2 == 6|| num2 == 9){
                numClap++;
            }

            // 100의 자리가 3, 6, 9 일때
            if(num1 == 3 || num1 == 6 || num1 ==9){
               numClap++;
            }

            // 1의 자리가 5
            if(num3 == 5){
                numClap2++;
            }

            //  10의 자리가 5
            if(num2 == 5){
                numClap2++;
            }

            // 100의 자리가 5
            if(num1 == 5){
                numClap2++;
            }



            //박수 횟수가 없을 떄
            if(numClap == 0 & numClap2 == 0){
                System.out.println(i);
            }else{
                for (int j = 0; j < numClap; j++) {
                    System.out.print("짝");
                }

                for (int j = 0; j < numClap2; j++) {
                    System.out.print("쿵");
                }
            System.out.println("");
            }

        }
    }
}
