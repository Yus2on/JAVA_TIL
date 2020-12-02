package s04.p05.subp02;

import s04.p05.subp01.ClassA;

//protected, private 은 상황에 따라 사용....
class ClassAA extends ClassA{
    private void test() { // 내부 구현을 위해서만 씀.
        System.out.println(x); // public -> 접근 가능
        System.out.println(y); // protected -> 접근 가능
        // protected는 private처럼 쓰지만 상속한 경우 접근이 필요할 때 사용

        //System.out.println(z); // default -> 같은 패키지에서만 접근할 수 있기때문에 접근 불가능
        //System.out.println(w); // private -> 자기 자신 내에서만 가능

        publicMethod(); // public
        protectedMethod(); // protected
        //defaultMethod(); // default
        //privateMethod(); // private
    }
}

// class 에서 제어자 -> public 과 default 사용
// private class 클래스명 사용 불가능
// default class 클래스명 사용 가능 -> 아무 것도 없이 class 클래스명
// protected class 클래스명 사용 불가능
public class ClassB {
    public static void main(String[] args) {
        ClassA obj = new ClassA(); //인스턴스
        System.out.println(obj.x); // public
        //System.out.println(obj.y); // protected는 다른 패키지인 경우 자식만 가능
        //System.out.println(obj.z); // default는 다른 패키지면 안된다.
        //System.out.println(obj.w); // private

        obj.publicMethod(); // public
        //obj.protectedMethod(); // protected는 다른 패키지인 경우 자식만 가능
        //obj.defaultMethod(); // default는 다른 패키지면 안된다.
        //obj.privatieMethod(); // 자기 자신에서만 허용
    }

}
