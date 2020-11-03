
/**
 * Aggregation과 Composition의 비교
 *
 * Aggregation과 Composition 모두 'HAS-A' 관계이지만,
 * Aggregation은 두 클래스의 생명주기가 무관하고
 * Composition은 두 클래스의 생명 주기가 같은 것을 의미합니다.
 *
 * 말로 설명하면 복잡하지만, 코드로 보면 간단하니 아래 코드를 확인해 주세요!
 */

class Foo {
    int x = 10;
}

class Bar {
    Foo foo = new Foo(); // 이것은 Composition 관계입니다.
}

class Qoo {
    Foo foo;

    public Qoo(Foo foo) { // 이것은 Aggregation 관계입니다.
        this.foo = foo;
    }
}

public class AggCompCompare {
    public static void main(String[] args) {
        Bar bar = new Bar();
        System.out.println(bar.foo.x); // Foo 객체가 Bar 객체와 함께 생성됩니다. Bar 객체가 사라질 때 Foo 객체도 함께 사라집니다.

        Foo foo = new Foo();
        Qoo qoo = new Qoo(foo);
        System.out.println(qoo.foo.x);  // Qoo 객체와 Foo 객체가 별도로 생성됩니다. Qoo 객체가 사라져도 Foo 객체는 사라지지 않습니다.
    }
}
