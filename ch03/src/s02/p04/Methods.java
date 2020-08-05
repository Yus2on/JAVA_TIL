package s02.p04;

import java.util.LinkedHashMap;

/**
 *  메소드 (Method)
 *  객체가 하는 동작(행위)를 정의하는 작업을 수행하는 코드의 집합, 나열
 *  코드의 중복을 방지, 유지보수성을 향상, 코드의 가독성 개선성
 *  인스턴스 = 객체
 */



class Foo {
    int value;
}

class Bar {
    // 인스턴스 메소드 (보통 그냥 메소드)
         // Return type (출력의 자료형)
    public int add (int x, int y){ // 입력 파라미터. 메소드 호출할 때 같이 입력
        return x + y; // return value (반환값)
    }
    // int add를 반환하는 메소드 선언.
    // 선언 (Declaration) - ~ 한 것이 있다. 실제 구현은 x
    // 정의 (Definition) - 메소드 내용까지 있어야지 정의. 선언 + 구현 (초기화)

    public static void classMethod() {
        System.out.println("클래스메소드 호출");
    }




    // Bar 라는 속성과 관련이 없어서 static 사용
    public static void swapPrimitive(int x, int y){
        // x y 뒤집기 -> 메소드 생성 후 호출했기 때문에 변수 전달이 아니라 int x, int y 의 사본이 호출 됨
        //  기본형 타입 (Primitive type) 인 경우에 해당
        // call by value : 메소드 호출을 할 때, 값을 복사해서 넘긴다.

        int temp = x;
        x = y;
        y = temp;
    }

    public static void swapReference(Foo x, Foo y){
        //  Foo -> class. class 는 참조형 변수
        // call by reference
        int temp;
        temp = x.value;
        x.value = y.value;
        y.value = temp;
    }

    public static int sumAll(int ... params){ // 자료형 + ... ->  여러개의 int 입력
        // 입력 받은 결과는 배열로 주어진다. params -> 배열
        int sum = 0;
        for(int value : params){
            sum += value;
        }
        return sum;
    }

    // 메소드 오버로딩 : 함수명은 같고 입력인자가 달라야 함
    // 입력 인자의 개수도 다를 수 있다
    public static float sumAll(float... params) {
        float sum = 0;
        for (float value: params) {
            sum += value;
        }
        return sum;
    }

}

class Person {
    static String korWord = "사람";
    boolean isHungry = true; // 인스턴스 멤버 변수.

    // 클래스 method - 객체에 변화를 주지 않음
    public static void describe(){
        System.out.println(korWord + " 입니다 ");
        // 클래스 메소드는 클래스 변수를 사용할 수 있다
        // System.out.println(isHungry);
        // 단, 객체에 속하는 속성은 사용할 수 없다. isHungry 사용 불가
    }

    // 인스턴스 method - 대부분 객체의 속성을 변화시키는 특성을 가짐 ( 반드시 변화는 아님 )
    public void eat(){
        isHungry = false;
    }
}

public class Methods {

    // 정적 메소드 (Static method), 클래스 메소드
    // void  return type : 아무것도 반환하지 않는다.
    public static void classMethod(){
        System.out.println("클래스메소드 호출");
    }

    public void instanceMethod() {
        System.out.println("인스턴스 메소드 호출");
    }


    public static void main(String[] args) {
        // 메소드 호출
        Bar.classMethod();

        // Bar.add(1, 2); -> 호출 할 수 없음
        Bar bar = new Bar(); // 인스턴스 하나 생성 후 호출 가능
        System.out.println(bar.add(1,2)); // 메소드 호출. return 값으로 대치됨

        // 인스턴스에서 클래스 메소드를 호출할 수 있지만 권장하지 않음
        // bar.classMethod();



        // ---------------------------------------------------------

        // Person이라는 클래스로부터 객체 생
        Person p1 = new Person();
        Person p2 = new Person();

        // 인스턴스 메소드는 객체의 속성을 변화
        p1.eat(); // p1
        System.out.println(p1.isHungry);
        System.out.println(p2.isHungry);

        // 클래스 메소드는 객체의 속성과 상관 없다
        Person.describe();


        int x = 10;
        int y = 20;
        Bar.swapPrimitive(x, y);
        System.out.println(x + ", " + y);

        Foo f1 = new Foo(){};
        Foo f2 = new Foo(){};

        f1.value = 10;
        f2.value = 20;
        Bar.swapReference(f1, f2);
        System.out.println(f1.value + ", " + f2.value);

        System.out.println(Bar.sumAll(3, 6, 43, 10, 1, 1));
        System.out.println(Bar.sumAll(2.2f, 0.2f, 0.2f));

        classMethod(); // 동일 클래스에 속한 클래스 메소드 호출
        Methods.classMethod();
        Methods m = new Methods();
        m.instanceMethod();
    }

}
