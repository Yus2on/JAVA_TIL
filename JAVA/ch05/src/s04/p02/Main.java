package s04.p02;

class Outer {
    class InstanceInner {
       int x = 1;

       void innerMethod() {
           int x = 0;
           System.out.println(x); // 0
           System.out.println(this.x); // 1
           System.out.println(Outer.this.x); //2

           //System.out.println(Outer.y);
           // 클래스에 속한 변수는 static이어야만 함

       }
    }

    private int x = 2;
    //private static int y = 3; // 이렇게 했을때 Outer.x 사용 가능


    public static void main(String[] args) {
        Outer outer = new Outer();
        InstanceInner inner = outer.new InstanceInner();
        inner.innerMethod();
    }
}

public class Main {
}
