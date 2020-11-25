package polymorphism4;

public class GoogleTv implements Tv {
	
	private int price;
	
    public GoogleTv() {
        System.out.println("===> GoogleTv 생성");
    }
    
    public void 멤버변수초기화() {
    	System.out.println("--> 멤버변수초기화() 호출 ");
    	this.price = 1200;
    }
    
    // 실행되지 않음 -> 구글티비 객체가 메모리에 살아있기 때문에
    // 컨테이너 객체를 종료해야 이 메서드가 실행 됨 
    public void 자원해제() {
    	System.out.println("--> 자원해제() 호출 ");
    	this.price = 0;
    }

    @Override
    public void powerOn(){
        System.out.println("GoogleTv---전원 켠다.");
    }

    @Override
    public void powerOff(){
        System.out.println("GoogleTv---전원 끈다.");
    }

    @Override
    public void volumeUp(){
        System.out.println("GoogleTv---소리 올린다.");
    }

    @Override
    public void volumeDown(){
        System.out.println("GoogleTv---소리 내린다.");
    }
}