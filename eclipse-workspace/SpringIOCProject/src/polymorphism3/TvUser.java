package polymorphism3;

public class TvUser {
 public static void main(String[] args) {
     BeanFactory factory = new BeanFactory();
     Tv tv = (Tv) factory.getBean(args[0]);
     
     tv.powerOn();
     tv.volumeUp();
     tv.volumeDown();
     tv.powerOff();
     // run - edit configuration - Program arguments 에 lg, samsung 을 넣으면 그 객체가 실행 됨.

     // 다형성을 사용했더니 클라이언트 소스 수정이 필요하기 때문에 디자인 패턴 사용 
     // 팩토리 패턴을 사용하면 공장으로 붙어 원하는 것을 얻어낸다. 클라이언트는 유지보수 과정에서 수정되지 않는다.
     // 클라이언트(main)만 봐서는 무슨 tv가 생성되는지 알 수 없도록 작성되어야 함 

     // 소스 수정 -> 컴파일 -> 서버에 올리는 일련의 과정이 필요하므로 소스 수정 최소화
     
     // 다형성, 디자인패턴를 써도 해결되지 않은 문제를 해결하는 것이 스프링프레임워크  
     //  - 핵심은 유지보수할 때 자바소스 수정하지 않음 (= 컴파일을 다시 할 필요 X)


 }
}