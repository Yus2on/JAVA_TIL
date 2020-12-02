package s04.p05;

interface IFoo {
    void run(); // 람다식 쓰려면 run() 하나만 존재해야댐
    void walk();

}

class AnonymousInnerClass { // 딱 한 번만 쓸 수 있는 클래스
    static void useIFoo(IFoo foo) { // 인터페이스에 구현되어 있는 메서드를 사용
        foo.run();
        foo.walk();
    }

    public static void main(String[] args) {
        // localInner
        class InnerClass implements IFoo { // 상속
            @Override
            public void run() {
                System.out.println("Run, Foo Run!");
            }

            @Override
            public void walk() {
                System.out.println("walk..... Foo.... walk.....");
            }
        }

        InnerClass ic = new InnerClass(); // 객체를 만들어서 IFoo에 넣어줌
        useIFoo(ic);


        // AnonymousInnerClass - 익명의 내부 클래스
        // 즉시 딱 한 번 사용 가능
        useIFoo(new IFoo() {  // 인터페이스 앞에 new 키워드가 붙음. 인터페이스는 객체 생성이 불가능한데도...
            // 익명의 내부 클래스를 만들 때는 이런 문법을 사용함 // 상속하고 있다는 의미 ....
            @Override
            public void run() {
                System.out.println("Run!!!!!!");
            }

            @Override
            public void walk() {
                System.out.println("wal...k...");
            }
        });

    }
}

public class Main {
}
