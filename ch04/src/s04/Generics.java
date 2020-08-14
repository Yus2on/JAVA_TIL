package s04;

/**
 * 제네릭 (Generics)
 * - 대상 객체의 타입을 입력 받아서 사용하는 형식
 * - 미리 사용할 수 있는 타입을 명시해서 컴파일 타임에 체크 가능
 *      - 입력을 Object로 할 수도 있으나, 런타임에 instanceof로 객체를 확인해야 함
 *      - 하지만 제네릭을 쓰면 이러한 과정 없이 간결하게 코드를 작성할 수 있는 장점이 있다
 *      - 원시타입 (int char long ) 불가능
 *      - 제네릭을 자주 쓰진 않고 쓰여진 걸 사용하는 게 더중요.....!!
 *
 */

// 일반 클래스
class Foo {

}


// 제네릭 클래스
// 제네릭 클래스를 만들게 되면 클래스를 선언할 때에는 설정되지 않은 타입이 있으며, 이것을 타입 파라미터로 표현
class GenericsFoo<T> { // 꺽쇠 <> 표현  // T => 타입 파라미터
    // 멤버변수 선언시 자료형 + 변수명 쓰는 것처럼 T를 자료형처럼 사용
    String str;
    T memberVar; // memberVar도 String 으로 받는 게 됨.

    // 메소드에도 사용가능
    // T 에는 어떤 타입의 자료형이 들어올지 모름  >> main 함수에서 String을 넣어줫으니가 String 타입
    public GenericsFoo(String str, T memberVar) {
        this.str = str;
        this.memberVar = memberVar;
    }
}

// 제네릭 인터페이스도 만들 수 있음
interface GenericsInterface<T> {

}

class HashMao<K,V> { // 여러개의 타입 파라미터도 쓸 수 있다.

}

class GenericBar<T> {

    /* 문법적으로 문제가 있는 경우!!
    //static T classVar; // 객체에선 T가 결정이 되어 있는데 클래스 입장에선 T가 결정이 안됨. 클래스 입장에서는 T를 사용 할 수 없음. 객체 생성 전에 결정이 되어야 사용 가능.
                        //클래스마다 하나만 있는 거라서 쓸 수 없음
    //static void method (T var) {} // 마찬가지로 스태틱 메소드도 클래스에 속한 것이지 객체에 속한 것이 아니라서 불가능
    T memberVar; // 객체에 속하니까 가능
    //T memberVar = new T();
    // T는 new 키워드 사용 불가능
    //  -> 안전성 문제 때문에. 자료형이 결정되어 있지 않아서 생성자가 어떻게 정의내릴지 전혀 모르는 상태임.
     */


    /* 자바에서 쓸 수 없다고 외워야 함
    // 문법적으로 문제가 없을 것 같으나, 안전성 문제로 인해 금지된 문법
    // 객체 상태에서 실행되는 애들이지만 T가 결정된 상태여도 쓸 수 없음
    {
        //Object obj = new Object();
        //if (obj instanceof T){} // T에 속하는 객체인지 확인 불가능 -> 안전성 문제로 사용 못 함
    }
     */
}


// 제네릭 타입의 상속
class GFoo<T> {}

interface IGFoo<T> {}

// 타입 파라미터는 부모 제네릭의 타입 파라미터를 모두 채워 주어야 한다.
// 추가적인 타입 파라미터도 사용할 수 있다.
// 타입 파라미터오류 남
//class GIGFoo<K, T, D> extends GFoo<T> implements IGFoo<D>{}

// 부모 클래스/인터페이스들에 동일한 타입 파라미터를 넘겨줄 수 있다.
class IGIFooTwo<T> extends GFoo<T> implements IGFoo<T> {
}

// 타입 제한을 하지 않으면 extends Object 동일하다
class GenericNoTypeLimitation<T extends Object>{}

// Number 은 추상클래스  Cloneable은 인터페이스
// extends를 이용해서 부모 클래스를 제한 할 수 있음
class GenericTypeLimitation<T extends Number & Cloneable>{

}

// 제네릭 메소드
class GenericMethod {
    // 일반 메소드
    public int method (int x){
        return x;
    }

    //정적 메소드 가능
    public static <T> T staticMethod (T t){
        // 입력값 받을 때 T 자료형 받기 때문에 오버로딩 된 것 처럼 사용
        // 만사형통은 아님.....
        return t;
    }

    public <T> T method (T x){
        return x;
    }
}


// 와일드 카드 !!!!
// 와일드 카드는 ? => 메소드의 입력 타입에 제네릭이 쓰일 경우, 제네릭의 타입 변수를 결정하지 않거나<?> 제한<extends, super>할 수 있다.
class wildFoo {

}

class wildBar extends wildFoo{

}

class wildGeneric<T> {

}

class wildCard {
    // 입력 파라미터로 제네릭을 사용한다면, 타입 변수를 명시하지않고 ?로 사용 가능. 미리 정하지 않는 것.
    // Object 가 상한 -> 모든 클래스 전부다 사용. 오브젝트 이하면 다 사용 함.
    public void method1 (wildGeneric<?> x){}

    // 제한법1 - wildFoo, wildBar 사용 가능
    public void method2 (wildGeneric<? extends wildFoo> x){} // 와일드 푸를 상한으로 두고 있는 것. 와잂드 푸 아래로
    // 제한법2 - Object, wildFoo, wildBar 사용 가능
    public void method3 (wildGeneric<? super wildBar> x){} // super는 super 뒤에 있는 걸 자식으로 함. 와일드바가 자식인것.
}


// 추가적인 타입 파라미터도 사용할 수 있다
public class Generics {
    public static void main(String[] args) {
        GenericsFoo<String> foo = new GenericsFoo<String>("name","var");
        // 이 때 <> 안에 어떤 자료형을 사용할 건지 써줌

        GenericsFoo<String> foo1 = new GenericsFoo<>("name","var");
        //타입을 앞에서 넣어줬으니 뒤에는 생략해도 됨

        System.out.println(foo.str);
        System.out.println(foo.memberVar);

        // 어떤 것도 가능. 그때그때 받아서 사용
        GenericsFoo<Integer> foo2 = new GenericsFoo<>("name1", 4);
        System.out.println(foo2.str);
        System.out.println(foo2.memberVar);



        // 제네릭 메소드 콜하기
        // 동적 바인딩 -> 컴파일타임에는 동작이 완전히 정의되지 않음
        // 런타임에 결정이 된다

        GenericMethod.staticMethod(new String(" "));
        GenericMethod.staticMethod("sdf");
        GenericMethod.staticMethod(1235);

    }
}
