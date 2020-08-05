package s02.p05;

/**
 * 생성자
 * 클래스에서 인스턴스를 생성할때 사용하는 메솓,
 * new 키워드를 사용할 때 호출되는 메소드
 *
 * 기본생성자
 * 파라미터 생성자 (Parameter)
 *  --> 여러개의 생성자를 오버로딩할 수 있음
 *
 *
 *  this -> 생성중인 객체를 가리킴. 생성중...
 *  순서대로 호출이 아니라 Hoisting... 한줄한줄실행이 아니라 전체를 보고 실행.. .
 *  변수가 맨 위에 선언되어 있지 않아도 됨
 */
public class Constructor {
    int x, y;
    String z;

    //public  Constructor(){} //기본 생성자. 구현하지 않아도 존재함. 알아서 생김.
    public  Constructor(){
       this(0, 0, "디폴트 constructor");
       // x = 1;
       // y = 2;
       // z = "초기화";
    }

    // private Constructor(){} // 생성자 중에 외부에서 사용할 수 없는 것.. 외부에서 호출이 불가능한 생성자이다

    //public Constructor(int a, int b, String c){ // 오버로딩
    public Constructor(int x, int y, String z){ // 오버로딩
        this.x = x; // 로컬변수에 같은 이름의 변수가 있다면  this를 사용해서 멤버변수를 표기하기 위해서 사용할 수 있다
        this.y = y;
        this.z = z;
    }

    public Constructor(int a, int b) {
        this(a, b,""); // 자바에서 this는 무조건 첫줄에만 사용할 수 있음. 규칙!!!
        // 코드 중복을 최소화 하기 위해 사용함.. .
        //x = a;
        //y = b;
        //z = "";
    }
}

class ConstructorTest{
    public static void main(String[] args) {
        Constructor c = new Constructor(); // 기본생성자 호출
        System.out.println(c.x + ", " + c.y + ", " + c.z);
        // z의 경우, 클래스이기 때문에 null로 초기화가 된다
        // null ->  아무것도 참조하지 않고 있음

        Constructor c1 = new Constructor(10, 20, "파라미터생성자");
        System.out.println(c1.x + ", " + c1.y + ", " + c1.z);

        Constructor c2 = new Constructor(10, 20);
        System.out.println(c2.x + ", " + c2.y + ", " + c2.z);
    }
}
