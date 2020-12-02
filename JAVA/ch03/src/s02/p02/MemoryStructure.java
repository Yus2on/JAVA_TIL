package s02.p02;

/**
 * 클래스의 객체의 메모리 구조
 * - 클래스 영역 (class area, method area, code area, static area)
 *      -> field 정보, method 정보, type 정보, constant pool
 * - 스택 영역 (Stack area)
 *      -> 임시적인 영역
 *      ->  method 호출 시 선언된 로컬 변수 (임시로 있다가 사라짐)
 * - 힙 영역 (Heap area)
 *      -> new 키워드 생성된 객체. 클래스 내부에 써있긴 하지만 객체에 속하는 속성들이 힙 영역에 만들어짐
 *      -> garbage collection이 동작하는 영역(GC)
 *         더 이상 사용하지 않는 메모리를 알아서 반환하는 JVM의 기능
 */
public class MemoryStructure { // 클래스 정보는 클래스 영역으로 감. 클래스 영역
    int x, y; // 힙 영역. 객체에 속하는 것은 힙. 클래스가 아니기 때문에 32bit 메모리 (int)를 잡고 있음
    String str = "String"; // 힙 영역, "String"은 상수풀

    public void method (int val) { // 메소드도 클래스 영역에 생성
        // int val => 스택 영역
        char c = 'w'; // 스택 영역

    }
}
