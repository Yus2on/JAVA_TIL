package s05.p02;


/**
 * 람다식이 가능한 조건
 *  - 모든 경우에 람다식이 가능한 건 아님
  */

@FunctionalInterface // 필수는 아니지만 적어주면 interface가 적합한지
interface Runner<T> { // 제네릭 이용
    T run(); // 단 하나의 abstract method
    //T runtwo(); // abstract method가 2개 이상이면 오류 발생
    default void method() {}; // default 메서드는 상관 없음
}


public class Main {
    static void useRunner(Runner<?> runner) {
        System.out.println(runner.run());
    }

    public static void main(String[] args) {
        useRunner(() -> "This is how to use runner.");
    }
}
