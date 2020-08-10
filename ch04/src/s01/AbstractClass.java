package s01;

/**
 * 추상 클래스 (Abstract Class)
 * - 일부 메소드가 구현되지 않고, 선언만 되어 있는 클래스
 *  - 자식 클래스에서 이것을 반드시 구현하게끔 강제하는 것
 *  - 필요한 모든 클래스가 구현될 수 있도록 하여 안정성을 높임
 */

abstract class AbstractFoo { // abstract -> 추상클래스 키워드
    int x, y;

    public void method(){
        System.out.println("method");
    }
                                        // 세미콜론 잊지말자. 시험에 내기 좋음
    public abstract void abstractMethod(); // 선언만 하고 구현하지 않음! 세미콜론 중요
                                        // 세미콜론 중요!!!!
}

// 객체 생성이 불가능하기 때문에 상속이 필수
class Foo extends AbstractFoo {

    @Override
    public void abstractMethod(){
        System.out.println("implemented abstractMethod");
    }

}


public class AbstractClass {
    public static void main(String[] args) {
        // AbstractFoo afoo = new AbstractFoo(); // 추상클래스는 곧바로 객체 생성이 불가능하다
        Foo foo = new Foo();
        foo.abstractMethod();

        //다형성
        AbstractFoo afoo = (AbstractFoo)foo; // 부모 클래스로 자식 클래스를 받는 것
        afoo.abstractMethod(); // virtual method call

        // 추상 클래스는 객체 생성이 불가능하지만,
        // 구현된 자식 클래스의 객체는 받을 수 있다.

    }
}
