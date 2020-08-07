package s04.p03;

/**
 * 메소드의 재정의 (Method Overiding)
 * Override -> 덮어 씌운다, 해킹해서 뭔가 달라지게 한다.... 의 의미
 * 다형성 (Polymorphism)의 근간이 됩니다.
 */


class Person {
    public void writeCode() {
        System.out.println("아무 코드나 일단 적어 보았다.");
    }

    public void work(){
        System.out.println("열심히 일을 했다");
    }
}

// 'IS-A' 관계
class Student extends Person {
    @Override // 이렇게 적어 주는 것이 관례. (문법 오류는 아님)
    public void writeCode() {
        System.out.println("학생 ==========================");
        System.out.println("능숙하게 코드를 작성해 보았다.");
        System.out.println("답은 틀렸다.");
        System.out.println("하지만 무언가 또 배웠다.");
        System.out.println("==============================");
    }

    public void work(){
        System.out.println("학생 ==========================");
        System.out.println("코드 공부를 했다.");
        System.out.println("무언가 또 배웠다.");
        System.out.println("==============================");
    }

    public void sleep(){
        System.out.println("잘 잤다.");
    }
}

class Develper extends Person{
    @Override
    public void writeCode(){
        System.out.println("개발자 ==========================");
        System.out.println("코드 작성이 하기 싫어서 하지 않았다.");
        System.out.println("==============================");
    }

    public void work(){
        System.out.println("개발자 ==========================");
        System.out.println("일을 하기 싫어서 하지 않았다.");
        System.out.println("==============================");
    }
}

public class Main {
    public static void main(String[] args) {
        Student sdu = new Student();
        //sdu.writeCode();
        //sdu.work();

        Person person = new Person();
       // person.writeCode();
       // person.work();

        Develper dev = new Develper();
        //dev.writeCode();
        //dev.work();

        // 부모 클래스 자료형으로 자식 클래스를 받을 수 있다
        Person p = (Person)dev; // 변수 p는 Develper인 p가 될 수도 있고,Student가 될 수도 있다
        //p.writeCode(); // 부모 클래스 자료형이지만 오버라이드 된 메소드가 동작한다.
        p = (Person)sdu;
        //p.writeCode();
        // 다형성 (Polymorphism)의 구현 중 하나이다.


        Person [] people = new Person[] {new Develper(), new Student()};
        //people 은 Person의 array...
        //Person이라는 array에 사람 넣었는데 개발자일 수도 있고, 학생일 수도 있다.
        for(Person person1: people){
            person1.writeCode();
        }

        sdu.sleep();
        p = (Person)sdu;
        // p.sleep(); //부모 클래스로 캐스팅이 되면 자식 클래스에만 있는 메소드는 실행이 안된다
    }

}
