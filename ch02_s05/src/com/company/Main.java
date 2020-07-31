package com.company;

/*
* 조건문 - 조건에 따라서 코드의 실행 흐름을 결정
* if 계열
* switch 계열
*
* [branch 문] - 조건에 따라 건너 뛰는 것. 기계어 수준에서 부르는 조건 실행문
* */

public class Main {

    public static void main(String[] args) {
        String sum = "519225-2055132"; // 주민번호
        char c = sum.charAt(7);
        System.out.println(c);

        if(c == 1){
            System.out.println("남자");
        }

        if(c == 1 || c == 3){
            System.out.println("남자");
        }else {
            System.out.println("여자");
        }

        int x = 6;
        if (x % 2 == 0){
            System.out.println("짝수");
        }else{
            System.out.println("홀수");
        }
        System.out.println(x % 2 == 0 ? "짝수" : "홀수");

        int score = 2;
        char grade;
        if(score >= 9){
            grade = 'A';
        }else if( score >= 7){
            grade = 'B';
        }else if ( score >= 5){
            grade = 'C';
        }else if( score >= 7){
            grade = 'D';
        }else {
            grade = 'F';
        }

        score = 90;
        boolean late = true;
        // late인 경우에는 하나 낮은 그레이드를 주기로 한다.
        // Nested if문 = 둥지처럼 안쪽에 쌓여있는 복합적인 if
        if(score >= 90){
            if(late){
                grade = 'B';
            }else{
                grade = 'A';
            }
        }else if(score >= 80){
            if(late){
                grade = 'C';
            }else{
                grade = 'B';
            }
        }else if(score >= 70){
            if(late){
                grade = 'D';
            }else{
                grade = 'C';
            }
        }else if(score >= 60){
            if(late){
                grade = 'F';
            }else{
                grade = 'D';
            }
        }else{
            grade = 'F';
        }
        System.out.println("");

        grade = 'A';
        // switch ~ case 문의 조건문은 '깂'이 들어오게 된다. (boolean 에 한정되지 않음)
        // case 가 범위가 될 수 없고, case 도 값이어야 함
        switch (grade){
            case 'A' :
                System.out.println("훌륭합니다");
                break;
            case 'B' :
                System.out.println("멋집니다");
                break;
            case 'C' :
                System.out.println("노력하세요");
                break;
            case 'D' :
                System.out.println("많이 노력하세요");
                break;// break가 없으면 fall=through가 발생
            //  의도적으로 사용할 경우도 있음 (학점 C와 D가 다를 바 없다고 생각하면 case 'C' : case 'D' 로 가능 -> 이경우에는 주석이 필요)
            default: // 위 조건에서 걸리지 않은 경우에 실
                System.out.println("다음엔 잘하세요");

        }
   }
}
