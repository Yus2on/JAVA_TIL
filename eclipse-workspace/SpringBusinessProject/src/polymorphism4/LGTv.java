package polymorphism4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//<bean class="polymorphism4.LGTv></bean>" 와 같음 
// id 정의가 안되었을 경우 bean : id="polymorphism4.LGTv#01"
// 				@Component : id="lGTv"

// 아이디 속성을 추가하고 싶다면 괄호열고 원하는 아이디 
@Component("tv") // -> 디폴트 생성자 생성 
// 유지보수과정에서 안 바뀌는 애들은 어노테이션 사용 -> 엘지티비가 삼성이나 구글티비로 변경될 가능성이 없음 
// 하지만 스피커는 자주 바뀐다? 이러면 bean 등록을 해서 xml 코드에서만 수정하는게 편함 
// 티비도 자주 바뀐다 -> @Component  사용하면 안됨....  xml에 실제로 사용할 티비 객체를 메모리에 등록 (티비는 아이디도 필요, 왜냐면 tvuser에서 룩업하기 때문에) 


public class LGTv implements Tv {

	// @Autowired : Type Injection
	// 변수의 타입을 기준으로 의존성 주입을 처리 -> 
	// 해당 타입의 객체가 메모리에 있기만 하면 컨테이너가 그 객체를 변수에 할당
	// 만약 객체가 없으면 Exception 발생 
	@Autowired
	private Speaker speaker; 
	
    public LGTv() {
        System.out.println("===> LGTv 생성");
    }

    @Override
    public void powerOn() {
        System.out.println("LGTv---전원 켠다.");
    }

    @Override
    public void powerOff() {
        System.out.println("LGTv---전원 끈다.");
    }

    @Override
    public void volumeUp() {
        speaker.volumeUp();
    }

    @Override
    public void volumeDown() {
    	speaker.volumeDown();
    }
}