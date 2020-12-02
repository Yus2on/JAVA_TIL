package s02.p07;

/**
 *   초기화 블록(Initializer)
 */
public class Main {
    static int classVar;
    static int instanceCount;
    int instanceVar;

    // static initializer
    // 정적 초기화 블록
    static {
        System.out.println("static block 1 ");
        classVar = 20;
    }

    // initializer
    // 객체를 초기화 하는 object initializer
    {
        System.out.println(" block 1 ");
        instanceVar = 30;
        classVar = 50; // 추천되지 않는다. 객체를 생성하는데 클래스에 관한게 변하면 안 됨
        instanceCount++; // 이러한 패턴은 사용된
    }

    static { // 여러개 있을 수 있음
        System.out.println("static block 2 ");
        classVar = 5;
    }

    { // 여러개 있을 수 있음
        System.out.println(" block 2");
        instanceVar = 5;
    }
}

class MainTest{
    public static void main(String[] args) {
        System.out.println(Main.classVar);
        Main main = new Main();
        System.out.println(main.instanceCount);

        System.out.println(main.instanceVar);
        System.out.println(Main.classVar);

        Main main2 = new Main();
        System.out.println(main2.instanceCount);

        Main main3 = new Main();
        System.out.println(main3.instanceCount);

    }
}
