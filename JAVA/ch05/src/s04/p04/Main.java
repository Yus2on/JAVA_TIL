package s04.p04;

class LocalInnerClass {
    int x = 1;

    //public Object methodA() {
    public void methodA() {
        final int Y1 = 2;
        int y2 = 2;

        class LocalInner {
            static final int Z = 4; // 상수가 되기 때문에, 따로 메모리를 잡을 필요가 없기 때문에 허용됨.
            // static final는 상수풀에 있을 수 있음

            //staitc int z  = 4; // **Impossible**
            // methodA에서 사용하는 모든 메모리는 stack 메모리에 생성됨. 이게 끝나면 없어짐.
            // 근데 static 변수는 연속하는 애인데 LocalInner 클래스는 메서드가 호출되야만 정의가 되고 그게 끝나면 없어지기 때문에
            // static 변수는 연속하지 못하게 됨. -> 클래스영역에 저장이 되어야 하는데 스택풀로 가니까 오류남
            // final만 가능
            void methodA(){
                System.out.println(x);
                System.out.println(Y1); // JDK1.7

                System.out.println(y2); // JDK1.8
                // y2++; // final처럼 사용되어야 함. 값 변경 불가.
                // 추후 public Object methodA()의 return (Object)inner; 같이 변경될 수 있기 때문에 참조한 상수만 가능하게끔.
            }
        }

        LocalInner inner = new LocalInner(); // 객체는 항상 heap area 에 생성
        inner.methodA();

        //return (Object)inner;
    }


    static {
        class LocalInner {
            void methodA(){
                System.out.println("a");
            }
        }
    }

    { // instance initialize
        class LocalInner {
            void methodA(){
                System.out.println(x);
            }
        }

    }

    public static void main(String[] args) {



    }
}

public class Main {
}
