package s04.p03;

class Outer {
    static class ClassInner {
        int innerVar = 1;
        static int staticInnerVar = 100;

        void innerMethod() {
            Outer outer = new Outer();
            System.out.println(innerVar);
            //System.out.println(outerVar);
            System.out.println(outer.outerVar); // 이상하지만 가능하다...
        }
    }

    private int outerVar = 2;
}

public class Main {
}
