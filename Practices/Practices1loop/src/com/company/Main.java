package com.company;
/*
*  반복 조건문 연습
*
* 1. **********  >>>>>>> * 열개 반복해서 사각형 만들기~~~~
*
* 2.
*         *
*        **
*       ***
*      ****
*     *****
* */
public class Main {

    public static void main(String[] args) {

        //1 .
        String var = "*";
        for(int i = 0; i < 5; i ++){
            //System.out.println(var);
            for(int k = 0; k < i + 1; k++){
               // System.out.println(var);
            }
            //System.out.println("");
        }


        // 2.
        for(int j = 0; j < 5; j++){
            for(int c = 0; c < 4-j; c++){
                //System.out.print(" ");
            }
            for(int z = 0; z < j + 1; z++){
                //System.out.print("*");
            }
            //System.out.println("");
        }

        // 1. j = 0; ==> 2 * j + 1
        // 2. j = 1; ==> 2 * j - 1
        for(int j = 1; j < 6; j++){
            for(int c = 0; c < 5-j ; c++){ // 빈 칸 증가
                System.out.print(" ");
            }
            for(int c = 0; c < 2 * j - 1; c++){
                System.out.print("*");
            }
            System.out.println(" ");
        }

        // 4
        for(int j = 1; j < 6; j++){
            for(int c = 0; c < 5-j ; c++){ // 빈 칸 증가
                System.out.print(" ");
            }
            for(int c = 0; c < 2 * j - 1; c++){
                System.out.print(j);
            }
            System.out.println(" ");
        }



        // 5
        for(int j = 0; j < 5; j++){
            for(int i = 0; i < 4-j ; i++){
                System.out.print(" ");
            }
            for(int i = 0; i < 2*j+1; i++){
                System.out.print(i - j > 0 ? i - j + 1 : j - i+1 );
            }
            System.out.println();
        }

        for(int i = 0; i < 5; i++){
            for(int j = 5; j > 1; j--){
                if(j <= i + 1){
                    System.out.print(j);
                }else{
                    System.out.print(" ");
                }
            }
            for(int j = 1; j <= 5; j++){
                if(j <= i + 1){
                    System.out.print(j);
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }



        /*
        * 3,6,9 게임
        * 내가 1번, 총 5명 게임
        * 짝 여러번 + 10의 배수에서 만세
        * 1 ~ 99
        * */
        for(int i = 1; i<=99; i++){ // 99번 반복
            int x = i % 10;
            int y = i / 10;
            int z = 0; // 짝

            if( i % 10 == 0){ //
                System.out.println("만세");
                continue;
            }

            if ((i - 1) % 8 != 0) {
                continue;
            }

            if( x == 3 || x == 6 || x == 9) {
                z++;
            }
            if ( y == 3 || y == 6 || y == 9){
                z++;
            }

            if(z == 0){ // 박수가 x
                System.out.println(i);
            }else{
                for(int k = 0; k < z; k++){
                    System.out.print("");
                }
                System.out.println(" ");
            }
        }


    }
}
