package polymorphism4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUser {
 public static void main(String[] args) {
	 // 1. 스프링 IoC 컨테이너를 생성(구동) 한다.
	 GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
	 // new GenericXmlApplicationContext("applicationContext.xml"); --> 이렇게만 사용해도 됨 
	 // 구글티비를 생성할ㄷ지 엘지티비를 생성할지 언급이 없지만 컨테이너가 실행할 객체 생성 
	 // 이걸 역제어 컨테이너라고 함 (IoC, Inversion of Control). 제어의 역전/ 제어의 역행
	 // 역제어는 객체생성 주체가 개발자가 아니라 컨테이너로 넘어감 (= 컨테이너가 객체 생성을 대신 함) 
	 // 유지보수할 때 클라이언트 변경해도 자바 소스를 변경하지 않고 실행 객체 변경가능해서 좋음 
	 
	 // 역제어의 반대는 순제어
	 // new LGTv();
	 // 가장 큰 문제는 티비를 바꾸고 싶다면 소스 수정이 필요함 
	 // 소스 수정 없이는 티비 변경 불가능 
	 // 클라이언트 양이 많을수록 수정해야 할 소스 양도 많기 때문에 유지보수가 어려워짐 
	 
	 // 2. 스프링 IoC 컨테이너로부터 객체를 검색(LookUp) 한다
	 Tv tv = (Tv) container.getBean("tv");
	 
	 // id가 tv이면 객체가 Tv인거 찾아줘 ~ 
//	 Tv tv1 = (Tv) container.getBean("tv");
//	 Tv tv2 = (Tv) container.getBean("tv");
//	 Tv tv3 = (Tv) container.getBean("tv");
	 // getBean을 여러개 해도 주소값을 리턴. 메모리에 하나 이상 뜰 수없음 
	 tv.powerOn();
     tv.volumeUp();
     tv.volumeDown(); //Dependency Injection 의존성 주입. IoC 중 가장 핵심임 
     tv.powerOff();
	 
     
     // 3. 스프링 IoC 컨테이너를 종료한다 (컨테이너는 종료되기 직전 자신이 관리했던 모든 객체를 메모리에서 삭제한다  )
     container.close();
 
 }
}