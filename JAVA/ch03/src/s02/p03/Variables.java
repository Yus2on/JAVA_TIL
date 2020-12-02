package s02.p03;

/**
 * 변수 (Variables)
 *  클래스에 쓰이는 다양한 변수
 *      - 클래스 멤버 변수 (static variable, class variavle)
*      - 인스턴스 멤버 변수 (member variable, attribute...)
 *      - 로컬 변수 (local varialbe)
 *      - 로컬 파라미터 변수 (local p)
 */
public class Variables {
    static int classVar; // 클래스 멤버 변수
    int instanceVar; // 인스턴스 멤버 변수

    public void method(int paramVar){ //로컬 파라미터 변수
        int localVal; // 로컬 변수
        localVal = 0;

        //System.out.println(localVal); // 로컬변수는 0으로 초기화 할 수 없음
        localVal = 10;
        System.out.println(localVal); // 값 대입 후 사용

        {
            localVal = 30;
            int localVal2 = 20;
        }
        // localVar2 = 40; // => 접근 불가. 생명주기가 끝났다 (Life-cycle)

    }
}

class VariableTest {
    public static void main(String[] args) { // main + enter
        System.out.println("클래스 변수");
        System.out.println(Variables.classVar); // 0 으로 초기화 됨
        //클래스 변수는 클래스  이름으로 바로 접근 가능
        Variables.classVar = 10; // 클래스이름.변수명으로 접근
        // 접근 -> 수정도 가능
        System.out.println(Variables.classVar);
        System.out.println("");

        System.out.println("인스턴스 멤버 변수");
        Variables var = new Variables();
        System.out.println(var.instanceVar); // 0 으로 초기화 됨
        var.instanceVar = 20;
        System.out.println(var.instanceVar);

        Variables var2 = new Variables();
        System.out.println(var2.instanceVar);
        System.out.println("");

        // System.out.println(var2.classVar); // 가능하나 권장하지 않음
        // Varables.instanceVar // 접근 불가능
        System.out.println("");

        System.out.println("로컬 변수");
        var.method(9);


    }
}

