package s04;

class Outer {
    class InstanceInner {
        int innerMemberVar = 1;
        // static int staticVar = 20;
        // static 변수가 존재할 수 없는 이유는 InstanceInner 클래스는 인스턴스가 있어야만 클래스 정의 의미가 생김.
        static final int CONSTANT_VAR = 1000;

        void innerMethod() {
            System.out.println(innerMemberVar);
            System.out.println(outerMemberVar);
        }
    }

    private int outerMemberVar = 2;

    void outerMethod() {
        InstanceInner obj = new InstanceInner();
        obj.innerMethod();
    }

    public static void main(String[] args) {
        // new InstanceInner();
        Outer outer = new Outer();
        InstanceInner inner = outer.new InstanceInner();
        inner.innerMethod();
    }
}


public class InnerClasses {
    public static void main(String[] args) {

    }
}