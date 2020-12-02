package s05.p01;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 람다식 (Lamda expression)
 * - JDK1.8 에서 추가된 함수형 프로그래밍 기법
 *      - 함수형 프로그래밍 -> 객체지향 프로그래밍과 다르게,
 *                     비즈니스 로직만 빠르게 구현하는 방법
 *
 *      - 비즈니스 로직 - Mission Critical 한 부분 <= 돈이 되는 부분
 *
 * - 객체지향 언어인 javadptj '메서드' 를 '함수'처럼 사용하는 방식
 *      - java에는 '함수' 라는 게 없음
 *      - 함수형 프로그래밍을 하려면 `1급 함수` 라는 개념이 필요
 *      - 이것을 가능하게 하는 것이 람다식
 *          - 메서드가 하나 있는 클래스를 함수로 가정을 해서 사용
 *      - 1급 함수 : 자바에서 모든 것이 객체 혹은 기본자료형
 *          1급 객체는 클래스를 통해서 생성한 객체(모든 것의 기준이 됨)
 *          이 객체가 함수와 동일시 될 수 있음
 */

// Comparable - 이 인터페이스를 구현한 객체 스스로에게 부여하는 한 가지 기본 정렬 규칙을 설정하는 목적으로 사용한다.
// Comparator - 이 인터페이스를 구현한 클래스는 정렬 규칙 그 자체를 의미하며, 기본 정렬 규칙과 다르게 원하는대로 정렬순서를 지정하고 싶을 때 사용한다.


public class Main {
    public static void main(String[] args) {
        // 람다식이 사용되는 대표적인 예
        // 배열의 정렬
        String [] str = {"fast", "campus", "java", "backend", "best", "people"};
        System.out.println(Arrays.toString(str)); // 입력한대로 출력

        Arrays.sort(str);
        System.out.println(Arrays.toString(str)); // 사전 순(a,b,c... )으로 sort

        // 원하는 식으로 정렬하기 위한 방법 1 : Comparstor 클래스를 만들고 객체를 생성하여 전달
        class MyComparator implements Comparator<String> {
            @Override
            public int compare(String o1, String o2) {
                return o1.substring(1).compareTo(o2.substring(1));
                //시작문자를 1번으로 해서 정렬함
            }
        }

        // 방법 1. sort를 하되, 새로운 Comparator를 이용해서 정렬
        Arrays.sort(str, new MyComparator());
        System.out.println(Arrays.toString(str));


        // 방법 2. 익명 내부클래스 사용
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.substring(2).compareTo(o2.substring(2));
                // 처음 두문자 건너뛰고 세번째 글자부터 sort함
            }
        });
        System.out.println(Arrays.toString(str));


        // 방법 3. 람다식 이용
        Arrays.sort(str, (o1, o2) -> o1.substring(3).compareTo(o2.substring(3)));
        // 처음 두문자 건너뛰고 세번째 글자부터 sort함
        System.out.println(Arrays.toString(str));


        // 방법 n. Comparable 이용
        class nComparable  {
            String value;

            public nComparable(String value) {
                this.value = value;
            }

            //@Override
            public int compareTo(nComparable o) {
                return value.substring(1).compareTo(o.value.substring(1));
            }

            @Override
            public String toString() {
                return value.toString();
            }

            nComparable [] arr = {new nComparable("fast"), new
                    nComparable("campus"), new nComparable("java"), new nComparable("backend"),
                    new nComparable("best"), new nComparable("people")};
        }

    }
}
