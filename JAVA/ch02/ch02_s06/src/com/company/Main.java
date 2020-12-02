package com.company;

import javax.swing.plaf.IconUIResource;

public class Main {

    public static void main(String[] args) {
	// write your code here
        for(int i = 0; i < 5; i ++){
            //초기화는 한 번 하고 끝
            //System.out.println(i); // 실행문
        }
        System.out.println("");

        for(int i = 0; i<5; i += 2){
            //System.out.println(i);
        }

        for(int i = 4; i>=0; i--){
            //System.out.println(i);
        }

        // nested for
        // i가 0인 상태로 for 실행   i가 0일 때 j는 0 - 4
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++) {
                //System.out.printf("(%d, %d)\n", i, j);
            }
        }

        for(int i = 0; i < 5; i++){
            //System.out.println(i);
            //System.out.println(""); // not iterated : 반복이 되지 않았다
        }

        //  for 문이랑 차이법 : while 은 변수를 반복문 바깥에서 정의를 해주기 때문에
        //  한번 사용하면 다시 사용 할 수 없음. 재정의 필요
        int i = 0;
        while(i < 5){
            //System.out.println(i);
            //i++;
        }

        //do-while 도 초기화를 밖에서함.
        i = 0;
        do{
            //System.out.println(i);
            i++;
        }while(false);
        //  while이 flase 여도 do는 반드시 한 번 실행이 됨


                // 제어문 - break continue
//        for(i=0; i<10; i++){
//            if(i == 3){
//                // 0, 1, 2 는 그냥 실행 -> 3실행하면서 조건문 실행
//                // -> 실행을 중단하고 i가 4가 됨 -> 그 이후는 0, 1, 2... 처럼 진행
//                continue;
//            }
//            System.out.println(i);
//        }
//
//        for(i=0; i<10; i++){
//            if(i == 3){
//                //바로 반복문 종료함
//                break;
//            }
//            System.out.println(i);
//        }

        //레이블  : for문이 중첩된 경우에 사용
        // 가장가까이 잇는 포문에 동작- > 컨티뉴가 실행이 되면
        loop1:
        for (int k = 0; k < 5; k++){
            for (int j = 0; j < 5; j++){
                if(k == 3){
                    System.out.println("----continue called");
                    continue loop1;
                }
                System.out.printf("%d * %d = %d\n",k , j, k * j);
            }
        }


    }
}
