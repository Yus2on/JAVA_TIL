package polymorphism3;

public class BeanFactory { 
	// 객체 공장, 팩토리 패턴(디자인패턴 중 하나) 활용
    public Object getBean(String id){
        if (id.equals("lg")){
            return new LGTv();
        } else if(id.equals("samsung")){
            return new SamsungTv();
        } else if(id.equals("google")){
    	// 구글 티비를 만들어서 그냥 프로그램 컨피규레이션에 google을 넣는다고 동작하지않음 
        // 빈팩토리에 분기를 만들어서 조건을 걸어줘야 동작이 된다.
        // 추가 수정 삭제 될 때마다 코드를 수정해야 하는 문제 
            return new GoogleTv();
        }
        return null;
    }
}