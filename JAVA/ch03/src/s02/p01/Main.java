package s02.p01;

/**
 * 클래스 - 객체를 생성하기 위한 설계도 (Class)
 * 객체 - 클래스를 구체화하여 값으로 생성된 것(object, instance)
 * 클래스를 객체로 만드는 과정 -> Instanciation
 */

class Car {// 클래스 이름은 보통 PasclaCase
    int speed = 0; // 속성, 멤버변수
    // 속성 : attribute, field
    // 멤버 변수 : member variable

    void move() { // 메소드 (Method), (가끔 멤버 함수)
        speed = 10; // 행위를 구현, 속성을 변경
    }
}

public class Main {
    public static void main(String[] args){
        Car carOne = new Car(); // new 키워드로 클래스에서 객체 생성
        System.out.println(carOne.speed); // . (dot)으로 속성 접근 가능
        carOne.move(); // 메소드 호출 (method call)
        System.out.println(carOne.speed);

        Car carTwo = new Car();
        System.out.println(carTwo.speed); // 객체 여러개 생성 가능. 독립적인 객체가 존재

        Car carThree = carOne; // 참조형 객체이기 때문에 carThree에 carOne을 대입하게 됨
        // new를 쓰지 않아서 생성이 아니라 carOne을 가르키는 형태가 됨
        // carOne, carTwo 는 독립적임 ...
        System.out.println(carThree.speed); // 10
        carThree.speed = 5;
        System.out.println(carThree.speed); // 5
        System.out.println(carOne.speed); // 5

        carOne.speed = 30;
        System.out.println(carOne.speed); // 30
        System.out.println(carThree.speed); // 30
    }
}
