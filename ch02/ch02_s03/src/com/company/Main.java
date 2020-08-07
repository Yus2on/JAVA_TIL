    package com.company;

    import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
            //출력 메소드
            //println -> ln : line의 약자 // print("text\r\n"); \r\n == \n

            System.out.println("string can be printed");
            System.out.println('C');
            System.out.println(402345);
            System.out.println(1.52f);
            System.out.println(15.2434);

            System.out.print("12535\n");
            System.out.println("");

            System.out.printf("%b\n", true); //b = boolean
            System.out.printf("%d 0x%x 0X%X 0%o ---- " ,15, 15, 15, 15); //10진수 16진수 8진수

            System.out.printf("%f\n", 14.23); //f = floating  //float -> 자료형 //double도 f(loating)로 가능
            System.out.printf("%f\n", 14.23f); //f = float
            System.out.printf("%e\n", 14.423); // 지수표현 s
            System.out.printf("%c %c\n", 'U', '\u0042'); //c = char

            System.out.printf("%n"); //new line

            //정수 포맷팅
            System.out.printf("%5d.\n", 10);  // 우측정렬 // 변수사용 불가능
            System.out.printf("%-5d.\n", 10);  // 좌측정렬
            System.out.printf("%05d.\n", 234);
            System.out.printf("%3d.\n", 104294); // 최소한 3칸을 확보 했으나 출력될 것이 길면 실제 출력될 것이 다 출력됨

            //실수 자릿수 표현
            System.out.printf("%5.4f\n", 23545355.54453454); // 소수점 아래로 네자리까지만 표현(뒷자리) + 표현된 뒷자리부터 최소 5칸 확보(소수점포함
            System.out.printf("%5.2f.\n", 1.4324); // ' '1.43
            System.out.printf("%-5.2f.\n", 1.4325); // 1.43' '

            // System.out.printf("%05.2f.\n", 1.4325); // 1.43' '

            // 입력 메소드
            System.out.println("Input methods");
            Scanner scanner = new Scanner(System.in);

            //String s = scanner.next(); // 공백으로 구분된 String을 입력 받는다
            //next() 메소드는 입력 받는 내용이 있을 때까지 기다린다. => Blocking 메소드 (<-> non-blocking 메소드)
            //this is string
            /* System.out.println(scanner.next()); // "this"
            System.out.println(scanner.next()); // "is"
            System.out.println(scanner.next()); // "string"*/

            // 공백으로 구분된 정수
            //        System.out.println(scanner.nextInt());
            //        System.out.println(scanner.nextInt());
            //        System.out.println(scanner.nextInt()); //자료형 안맞으면 에러

            //공백으로 구분되는 float 등.... --> TIL 하면서 해보기~~~

            //nextLine() 메소드는 new line(Enter)로 구분되는 입력
            System.out.println(scanner.nextFloat());
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextLine());

        }
    }
