package s07.p01;

/**
 * 부모 클래스 타입으로 자식 클래스 타입의 객체를 참조하는 특징
 */

class Foo {
    public void methodA() {
        System.out.println("A");
    }
}

class Bar extends Foo {
    public void methodB() {
        System.out.println("B");
    }
}

public class Poly01 {
    public static void main(String[] args) {
        Bar bar = new Bar(); // new => 새로운 객체 !!! 자식 객체를 새로 생성
        Foo foo = (Foo)bar; // 부모 클래스 타입으로 자식 객체를 받음 foo로 casting
        // 여전히 힙 영역에는 자식 객체가 존재

        foo.methodA();
        //foo.methodB();    // 이 경우 문법적으로 자식 클래스 메소드는 사용 불가능

        Foo foo1 = new Foo(); // Foo클래스 객체 생성
        // Bar bar1 = (Bar)foo1; // 자식 클래스 타입으로 부모 객체를 받음 -> 문법오류는 아니지만 런타임 오류 발셍. 애초에 자식 클래스 타입으로 부모 객체를 받기가 불가능. 성립할 수 없음
        // 자식 클래스 자료형으로 객체를 보려 하지만, 부모 객체 부분만 있기 때문에 런타임 오류 발생
        // bar1.methodB();  // 문법 오류 x. methodB는 Bar라는 클래스에서 만든 거라서 쓸 수 있지만 자식 클래스 타입으로 부모객체를 받은 게 오류
        // bar1.methodA();  // 문법 오류 x -> 마찬가지로 성립할 수 없음 함
        // Bar > Foo : Bar에 Foo 가 속해있는 상황

        // 문법오류는 빌드 자체가 불가능, 런타임 오류는 실행은 되나 실행 중간에 발생하는 오류를 런타임 오류라고

        // 자식 클래스 타입으로 자식 객체를 받음
        // 힙 영역에는 계속 자식 객체가 있었던 것
        Bar bar1 = (Bar)foo; // foo = 자식 객체를 담고 있는데 다시 자식 객체로 casting
        //bar1.methodA();
        //bar1.methodB();
    }
}
