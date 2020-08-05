/**
 * 싱글톤 패턴 구현하기
 *
 * 단 하나의 인스턴스만 존재할 수 있는 클래스 SingletonPattern을 구현하시오.
 *
 * 생성자를 외부에서 직접 호출할 수 없다.
 * 정적 메소드인 getInstance() 메소드를 이용해 객체를 받아온다.
 * 받아온 객체는 항상 같은 객체를 참조해야 한다.
 */

public class SingletonPattern {
    // static -> 정적 메소드
    private static SingletonPattern SingletonPattern = null;

    private SingletonPattern(){}; // 기본생성자 -> private 사용하여 생성 불가능

    public static SingletonPattern getInstance() { // getInstance를 통해서만 생성 가능
        if(SingletonPattern == null) {
            SingletonPattern = new SingletonPattern();
        }
        return SingletonPattern;
    }
}


class SingletonPatternTest {
    public static void main(String[] args) {
        // SingletonPattern instance = new SingletonPattern(); // should fail
        SingletonPattern instanceOne = SingletonPattern.getInstance();
        SingletonPattern instanceTwo = SingletonPattern.getInstance();

        System.out.println("");
        System.out.prin tln(instanceOne == instanceTwo); // should be true
    }
}