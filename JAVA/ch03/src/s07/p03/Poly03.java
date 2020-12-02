package s07.p03;


/**
 * 공변 반환 타입 (Covariant return type)
 *
 */

class Foo {
    public Foo getInstance() { // 메소드
        return this;
    }
}

class Bar extends Foo {
    // 상속을 해서 오버라이딩을 하려면 Foo, Bar에 있는 리턴 타입이 똑같아야 하지만
    // Covariant return type은 예외적으로 리턴 타입으로 Bar를 사용
    // 오버로딩이 아님.....
    // 자식 쪽에서만 가능. 상속 받았기 때문에
    @Override
    public Bar getInstance(){
    //public Foo getInstance(){
        return this;
    }
}

public class Poly03 {
    public static void main(String[] args) {
        Bar bar = new Bar();
        bar.getInstance();
    }
}
