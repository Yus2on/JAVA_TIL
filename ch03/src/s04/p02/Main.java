package s04.p02;

/**
 * 클래스의 포함 관계 (class Composition)
 * 클래스를 조립해서 구성한다는 의미
 * 상속하고 유사하지마느 한 클래스가 다른 클래스의 객체를 포함하는 관계
 * 내부에 포함하고 있어 'HAS-A' 관계로 표현된다
 * 객체지향 관점에서 자바에서 지원되는 기능이 별로 없음.
 */

// MainMachine 'HAS-A' String
class MainMachine {
    String model; //모델
    boolean isBroken = false; // 고장 유무

    public MainMachine(String model){
        this.model = model;
    }
}

// Developer 'HAS-A' MainMachine (Developer가 MainMachine 을 갖고 있다)
// Developer  클래스는 MainMachine의 객체 하나를 보유한
class Developer {
    String name;
    MainMachine mainMachine;

    public Developer(String name, MainMachine machine) {
        this.name = name;
        this.mainMachine = machine;
    }

    public void writeCode(){
        if (mainMachine.isBroken){
            System.out.println("코딩을 할 수 없습니다.");
        } else {
            System.out.println(mainMachine.model +" (으)로 코딩하기 ");
        }

        if (Math.random() > 0.9){
            breakMachine();
        }
    }

    public void breakMachine(){
        mainMachine.isBroken = true;
    }
}

public class Main {
    public static void main(String[] args) {
        MainMachine mac = new MainMachine("MacBook Pro");
        Developer dev = new Developer("너개발", mac);

        for(int i = 0; i < 10; i++) {
            dev.writeCode();
        } // end for

    }
}
