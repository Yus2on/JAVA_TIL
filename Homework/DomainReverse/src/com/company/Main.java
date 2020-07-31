package com.company;
/**
 * 도메인 뒤집기
 *
 * 주어진 홈페이지 주소를 .을 기준으로 각각 뒤집어 출력하시오.
 *
 * ex) www.google.com -> www.elgoog.moc
 *
 * 인자
 * string: 홈페이지 주소
 */
public class Main {

    public static void main(String[] args) {
    	// write your code here
        String string = "www.google.com";
/*
        // . 의 인덱스를 찾는다 - 인덱스 값: 3
        int dot = string.indexOf(".");

        // . 앞부분을 추출
        // substring은 첫번째 지정한 인덱스는 포함하지 않는다.
        // www
        String domain1 = string.substring(0, dot);

        // 뒷부분을 추출
        // 아래 substring은 . 바로 뒷부분인 n부터 추출된다.
        // google
        String domain2 = string.substring(dot+1);
        String domainx = domain2.substring(0,6);

        // com
        String domain3 = domain2.substring(domain2.length()-3, domain2.length());



        System.out.print(domain1+".");

        StringBuffer x = new StringBuffer();
        x.append(domain3+"."+domainx);

        System.out.println(x.reverse());
*/
        String[] domainString = string.split("\\."); // .을 기준으로 문자열 자르기
        for(int j = 0; j<domainString.length; j++){
            for(int i = domainString[j].length() - 1; i >= 0 ; i--)
                System.out.print(domainString[j].charAt(i));
            if(j != domainString.length - 1) // 바로 다음 칸만 실행하고 끝. 마지막은 . 추가하면 안되니까 -1
                System.out.print(".");
        }
        System.out.println();


    }
}
