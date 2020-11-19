package pholymorphism2;

//다형성 = 상속 + 메소드 Overriding + 형변환(절차지향언어에서 지원하지 않음) 
// - 유지보수가 편함! 
// - one interface multiple implementation
//자식객체가 부모타입으로 되는걸 묵시적 형변환
public class TvUser {
 public static void main(String[] args) {
     Tv tv = new SamsungTv();
     tv.powerOn();
     tv.volumeUp();
     tv.volumeDown();
     tv.powerOff();
     // 이건 클라이언트에게 리모콘을 줘서 tv를 작동하라고 하는 것과 같다.
     // tv는 바껴도 리모콘은 안바뀌니깐 하나의 리모콘으로 여러 개의 tv를 작동 가능 -> 이게 다형성임 
     // 클라이언트를 수정하지 않고 tv를 바꾸려면 디자인 패턴을 적용 필요 

 }
}