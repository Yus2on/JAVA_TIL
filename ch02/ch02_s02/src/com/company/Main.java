package com.company;

/**
 * 자료형 (Data Type)
 * 자료형 - 기본형 (Primitive Type), 참조형 (Reference Type)
 * 기본형 자료형 - 정수형, 실수형, 문자형, 논리형
 * 참조형 자료형 - 문자열 (String)
 */

public class Main {

    public static void main(String[] args) {
        //정수형 : byte, short, int, long
       /* System.out.println("Byte");
        System.out.println(Byte.BYTES);
        byte byteValue = 42;
        System.out.println(byteValue);
        System.out.println(Byte.MAX_VALUE); // 2^7 - 1
        System.out.println(Byte.MIN_VALUE); // -2^7
        // byte byteValue1 = 128;
        System.out.println("");

        System.out.println("Short");
        System.out.println(Short.BYTES);
        System.out.println(Short.MAX_VALUE); // 2^15 - 1
        System.out.println(Short.MIN_VALUE); // -2^15
        System.out.println("");

        System.out.println("Int");
        System.out.println(Integer.BYTES); // 4
        System.out.println(Integer.MAX_VALUE); // 2^31 - 1
        System.out.println(Integer.MIN_VALUE); // -2^31
        System.out.println("");

        System.out.println("Long");
        System.out.println(Long.BYTES); // 8
        System.out.println(Long.MAX_VALUE); // 2^63 - 1
        System.out.println(Long.MIN_VALUE); // -2^63
        System.out.println("");*/

        // Overflow
        // 32767 = 2^15 - 1 => 0111111111111111
        short shortValue = (short) 64000;
        //System.out.println(shortValue);
        //System.out.println("");

        // 정수형은 기본적으로 int
        //byte byteValue3 = 144;
        short shortA = 10;
        short shortB = 20;
        short shortC = (short) (shortA + shortB);

        int bigInt = Integer.MAX_VALUE;
        int biggerInt = bigInt + 1; // overflow 주의
        //System.out.println(biggerInt);

        long veryBigInt = 10000000000000L;
        long veryBigInt2 = 100_000_000_000L; //천 단위 씩 끊어서 사용

        //System.out.println(veryBigInt);

        // 진수법 - Binary(2), Octal(8), Decimal(10), Hexadecimal(16)
       /* System.out.println(0b1101);
        System.out.println(071);
        System.out.println(1424);
        System.out.println(0x10); // 0~9 10~15: a,b,c,d,e,f
        System.out.println(0xff);*/
        //byte flagByte = 0b00101100;

        // 실수형 : float, double
        // float 끼리 계산 -> double
        /*System.out.println("float");
        System.out.println(Float.BYTES); //4
        System.out.println(Float.MAX_VALUE); //3.4028235E38 * 10^38
        System.out.println(Float.MIN_VALUE);//1.4 * 10^-45 : resolution
        System.out.println("");

        System.out.println("double"); // float 보다 두 배
        System.out.println(Double.BYTES); //8
        System.out.println(Double.MAX_VALUE); //1.8 * 10^38
        System.out.println(Double.MIN_VALUE);//4.9 10^-324 : resolution
        System.out.println("");

        float val = 1.4234f; // 뒤에 f 사용
        float val2 = (float)1.4234; // casting 사용

        double dVal = 104.42512341245;
        double dVal2 = 104.423e8;
        double dVal3 = 104.425E8;

        // 문자형
        System.out.println("char"); // short 와 같은 2byte
        System.out.println(Character.BYTES); //2
        System.out.println((int)Character.MAX_VALUE); // 2^6 - 1
        System.out.println((int)Character.MIN_VALUE); // 0
        System.out.println("");

        char charVal ='A';
        System.out.println((int)charVal); //65
        System.out.println("");

        System.out.println('\u0041');*/




        //upcasting : 범위가 작은 쪽에서 큰 쪽 / 정밀도가 낮은 쪽에서 큰 쪽
        /*byte byteVal = 10;
        int intVal = byteVal;
        intVal = (int)byteVal; // redundant : 군더더기?? 굳이 해줄 필요가 없다. Upcasting 자동으로 해줌

        intVal = 10244;
        long longVal = intVal;
        longVal = (long)intVal; // redundant

        float floatVal = longVal; // float 4byte long 8byte 이지만 자동으로 Upcasting
        floatVal = (float)longVal; // redundant 뜨지 않지만 자동으로 됨

        double doubleVal = floatVal;
        doubleVal = (double)floatVal; //범위, 정밀도가 double이 높아서 높아서 Upcasting
        */

        //Downcasting
        long longVal = 10244L;
        //int intVal = longVal; // Downcasting이 자동으로 되지 않음
        int intVal = (int)longVal; // 직접 해줘야함
        System.out.println(intVal);

        longVal = 100_000_000_000L;
        intVal = (int)longVal;
        System.out.println(intVal); // 위 intVal과 값이 다름. 상위 비트 소실. 문제가 생길 수 있기 때문에 직접 Downcasting 필요

        char valC = 4123;
        byte valB = (byte)valC;
        System.out.println(valB);
    }
}
