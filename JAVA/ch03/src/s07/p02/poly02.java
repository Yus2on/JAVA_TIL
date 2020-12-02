package s07.p02;

import java.sql.SQLOutput;

/**
 * 멤버 변수의 재정의는 선언된 객체 타입을 따른다 (문법적으로 본다)
 * 메소드 오버라이드는 메모리 상의 객체 타입을 따른다 (실제 객체로 본다)
 *  (가상 메소드 호출 ; Virtual method call)
 */


class Foo {
    static public String y = "Super class";
    public String x = "Super";

    public void methodA(){
        // 들러리 역할 -> Virtual method (실제로 호출되지 않고 문법적으로 얘가 호출되는 것처럼 보임
        System.out.println("Super Method");
    }
}

class Bar extends Foo {
    static public String y = "Sub class";
    public String x = "sub";

    @Override
    public void methodA() {
        System.out.println("Sub Method");
    }
}

public class poly02 {
    public static void main(String[] args) {
        Bar bar = new Bar();
        Foo foo = (Foo)bar; // Bar 객체를 다시 foo 로 받음

        System.out.println(bar.x); // 자식 객체인 sub
        bar.methodA(); // Sub Method

        System.out.println(foo.x); // Super
        foo.methodA(); // Sub Method // Virtual method call


        System.out.println(Foo.y);
        System.out.println(Bar.y);

        // foo, bar 는 자식 객체 -> static 이 있던 없던 간에 부모 쪽 변수
        // bar 는 자식 쪽 변
        System.out.println(foo.y);
        System.out.println(bar.y);
    }
}
