package s01;
/**
 * Wrapper 클래스 (Wrapper class)
 * - 기본형 타입을 객체로 쓰기 위해 있는 클래스
 * - 기본형 타입이 허용되지 않는 문법에 기본형 타입을 쓰기 위해서 제공
 *
 * byte -> Byte
 * char -> Character
 * short -> Short
 * int -> Integer
 * long -> Long
 * float -> Float
 * double -> Double
 * boolean -> Boolean
 *
 */

public class WrapperClass {
    public static Integer add(Integer x, Integer y){
        return x + y; // unboxing -> 자동으로 기본자료형으로 변형되어계산
        // return 될 때는 다시 Autoboxing -> Inteer로 변경
    }

    //제네릭
    public static <T> T bypass (T x) {
        return x;
    }

    public static void main(String[] args) {
        Integer integer = new Integer(10);  //  Integer라는 클래스 생성자
        Integer integer1 = Integer.valueOf(10);  // Integer 클래스 valueof라는 스테틱메소드 사용
                                                //위와 같음

        Character character = new Character('d');
        Character character1 = Character.valueOf('d');

        // Autoboxing -> 자동으로 WrapperClass를 씌워줌
        Integer integer2 = 4; // 바로 넣어줄 수 있음
        System.out.println(add(4,2));

        bypass(5); // autoboxing
        // T : Wrapper class 인 Integer로 결정됨
        // 5 -> new Integer(5) (Autoboxing)

        //문자열 <-> 기본자료형 (전부 공식)
        int x = Integer.parseInt("100"); // parse+ 자료형 정적 메소드 ---- 권장!!!!
        int y = new Integer("100"); // String을 입력 받아도 파싱 가능
        int z = Integer.valueOf("200"); // 얘도 String 가능

        //unboxing
        int m = new Integer(10); // 사칙연산 뿐 아니라 기본 자료형이 필요한 자리에
        // Wrapper class 객체가 있을 경우 자동 unboxing 이뤄짐
    }
}
