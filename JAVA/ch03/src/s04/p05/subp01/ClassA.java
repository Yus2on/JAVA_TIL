package s04.p05.subp01;

import java.util.stream.DoubleStream;

public class ClassA {
    //실제로는 classA.java 라는 파일을 생성
    public int x;
    protected int y;
    int z; // default ( = package)
    private int w;


    //메소드
    public void publicMethod() { }
    protected void protectedMethod() { }
    void defaultMethod() { } //default (= package)
    private void privateMethod() { // 내부 구현을 위해서만 씀.
//        System.out.println(x);
//        System.out.println(y);
//        System.out.println(z);
//        System.out.println(w);
//
//        publicMethod();
//        protectedMethod();
//        defaultMethod();
    }
}


class ClassATest{
    // 같은 패키지 내에 있는 또 다른 class
    public static void main(String[] args) {
        ClassA obj = new ClassA(); //인스턴스
        System.out.println(obj.x);
        System.out.println(obj.y);
        System.out.println(obj.z);
        //System.out.println(obj.w);

        obj.publicMethod();
        obj.protectedMethod();
        obj.defaultMethod();
        //obj.privatieMethod(); // 자기 자신에서만 허용
    }


}