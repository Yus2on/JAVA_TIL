package polymorphism4;

public class SamsungTv implements Tv {
	private Speaker speaker;
	private int price;
	
    public SamsungTv() {
        System.out.println("===> Samsung TV(1) 생성");
    }
        
    /*
    public SamsungTv(Speaker speaker) {
    	System.out.println("===> Samsung TV(2) 생성");
		this.speaker = speaker;
	}
    
    public SamsungTv(Speaker speaker, int price) {
    	System.out.println("===> Samsung TV(3) 생성");
    	this.speaker = speaker;
		this.price = price;
	}
	*/
    
	public void setSpeaker(Speaker speaker) {
		System.out.println("----> setSpeaker() 호출 ");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("----> setPrice() 호출 ");
		this.price = price;
	}

	@Override
    public void powerOn(){
        System.out.println("SamsungTv---전원 켠다.");
    }

    @Override
    public void powerOff(){
        System.out.println("SamsungTv---전원 끈다." + price);
    }

    @Override
    public void volumeUp(){
    	speaker.volumeUp();
        
    }

    @Override
    public void volumeDown(){
        speaker.volumeDown();
    }
}