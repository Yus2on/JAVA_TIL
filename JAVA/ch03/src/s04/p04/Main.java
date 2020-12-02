package s04.p04;

/**
 * super 키워드
 * this가 자기 자신의 객체를 참조하듯,
 * super는 부모 객채를 참조한다
 *
 * super.super 처럼 부모의 부모는 참조할 수 없다.
 */


class Foo {
    String x = "Foo";

    //생성자
    public Foo(String x) {
        this.x = x;
    }
}

class Bar extends Foo { // Foo 상속
    // 자식클래스 생성자 생성시 부모 클래스의 생성자 호출 필요
    // 부모 클래스에 파라미터 생성자가 있으면 호출 필요
    // 예외적으로 부모클래스의 기본 생성자를 사용할 땐 호출 필요 없음
    public Bar(String x, String x1) {
        //부모의 x도 초기화 해야하고, 자식의 x도 초기화 해야 함.
        super(x); // this 와 마찬가지로 첫줄에 써야함. 부모 클래스 생성자 호출
        // 부모 객체를 먼저 생성성 후 -> 자식 객체 생
        this.x = x1;
    }

    String x = "Bar"; // 멤버 변수명이 부모와 겹치면 재정의

    public void method(){
       // String x = "method"; // 로컬 변수
        System.out.println(x); // 로컬 변수 -> 멤버 변수 -> 부모의 멤버 변수 순으로 접근
        System.out.println(this.x); // this 사용으로 멤버 변수 접근. 멤버 변수 -> 부모의 멤버 변수
        System.out.println(super.x); // super 사용으로 부모 변수 접근.
    }
}

// 아무 것도 상속하지 않은 경우, Object 클래스를 상속하는 것과 같다. 기본적으로 클래스는 object 클래스의 기능을 가지고 있다
// class Jaemi extends Object {
class Jaemi {
    public void method(){ // 인스턴스 메소드 -> 실행 시 객체 call 되는 건 이미 객체가 있어서 가능
    }
}

public class Main {
    public static void main(String[] args) {
        Bar bar = new Bar("","");
        bar.method();
        // 자식 객체를 생성하면, 부모 객체를 먼저 생상하고 그 다음에 자식 객체를 생성함
    }
}
