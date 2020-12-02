package s05.p04;

/**
 * 람다식과 익명 클래스 객체가 동일한 것은 아니다 라는 것의 증명
 */

@FunctionalInterface
interface IFoo {
    String method();
}

public class Main {
    static void functionalMethod(IFoo foo) {
        System.out.println(foo.method());
    }

    void methodA() {
        functionalMethod(() -> {
            System.out.println("this :" + this); // 이 this 가 왜 main의 this?? -> 람다식은 익명 클래스와 달리 클래스가 만들어지지 않음
            System.out.println("OuterClass.this :" + Main.this);
            return "Lamda expression used";
        });

        functionalMethod(new IFoo() {
            @Override
            public String method() { // 익명 클래스가 만들어지고, 그 객체가 만들어지는 과정이 실제로 발생함
                System.out.println("this :" + this); // 익명 클래스의 객차제가 this 됨
                System.out.println("OuterClass.this :" + Main.this); // 외부 클래스 main의 객체인 this
                return "Anonymous local inner class used";
            }
        });
    }

    public static void main(String[] args) {
        new Main().methodA();
    }
}
