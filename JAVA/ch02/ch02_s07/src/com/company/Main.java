package com.company;
/**
 * 배열 (Array)
 * 배열의 특성
 * - 하나의 변수로 여러 개의 값을 다룰 수 있다.
 * - 동일 자료 형만 다룰 수 있다.
 * - 한번 생성한 배열의 크기는 변하지 않는다.
 * - 배열에 속한 값은 메모리에 연속으로 위치한다.
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        int intVal;

        int intOne = 2;
        int intTwo = 4;
        int intThree = 8;

        System.out.println(intOne);
        System.out.println(intTwo);
        System.out.println(intThree);

        int [] intArray1 = {2, 4, 8};
        for (int x: intArray1) {
            System.out.println(x);
        }

        // 배열의 선언
        int [] integers;
        // int cStyleIntegers[];

        long [] longs;
        char [] chars;

        String [] strings;

        // 배열의 생성과 초기화
        integers = new int[10];
        int [] integers2 = new int[10];

        integers2[0] = 5;
        integers2[1] = 10;
        integers2[3] = 9;

        System.out.println(integers2[0]);
        System.out.println(integers2[1]);
        System.out.println(integers2[2]); // 0으로 자동 초기화
        System.out.println(integers2[3]);
        // 값을 넣을 때 순차적으로 하지 않아도 된다.
        System.out.println("");

        int [] integers3 = new int[]{5, 2, 3, 6, 12, 4}; // 길이 입력 안해도 된다.
        System.out.println(integers3[0]);
        System.out.println(integers3[1]);
        System.out.println(integers3[2]); // [2] 에 값을 선언해주지 않으면 자동으로 0 대입. JAVA는 자동 다른 언어는...?
        System.out.println(integers3[3]);
        System.out.println(integers3[4]);
        System.out.println(integers3[5]);
        // System.out.println(integers3[6]); // ArrayIndexOufOfBoundsException 오류 발생
        // 배열 사용할 때에는 선언해 준 길이까지만 접근해야 한다.
        System.out.println("");

        int [] integers5 = {1, 4, 5, 23, 0}; // new int[]를 빼도 초기화 가능

        // 배열을 반복문으로 접근
        float [] floats = new float[5];
        for (int i = 0; i < floats.length; i++) { // for문을 이용한 초기화
            floats[i] = (float)(i * 0.25);
        }

        for (int i = 0; i < floats.length; i++) { // for문을 이용한 출력
            System.out.println(floats[i]);
        }

        for (int i = 0; i < floats.length; i++) {
            float floatVal = floats[i];
            System.out.println(floatVal);
        }
        // Enhanced for, for each 문 --> 위와 같은 것!
        for (float floatVal: floats) {
            System.out.println(floatVal);
        }
        System.out.println("");

        // 배열의 크기를 변경 // 확장 할 때?
        int [] src = {1, 2, 3, 4, 5};
        int [] dst = new int[10];
        for (int i = 0; i < src.length; i++) {
            dst[i] = src[i];
        }
        for (int integer: dst) {
            System.out.println(integer);
        }

        // 배열 크기 변경
        int [] src2 = { 1, 2, 3, 4, 5};
        int [] dst2 = new int[10]; // 복사할 소스를 넣을 배열
        //배열 크기 변경을 위해 arraycopy : 가져올 배열( 복사해올소스 , 몇번인덱스부터 가져올것인지, 몇개나 복사할 것인지)
        System.arraycopy(src2, 0, dst2, 0, src2.length);
        //전체를 다 가져오기 위해서 length. 3개만 가져오고 싶으면 length : 3
        for(int interger: dst2){
            System.out.println(interger);
        }//end for
    }
}
