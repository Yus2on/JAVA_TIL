package s14.p02;

public class Main {
    public static void main(String[] args) {
        // 어떻게 동작할지 예측하기 어려움
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                System.out.print("~");
                // 예측이 좀더 수ㅇ월하도록 의도를 집어 넣음
                Thread.yield(); //러닝상태에서 빠져나와 다른 스레드로 동작하는 권한을 양보하고 바로 실행 대기 상태 -> 오버헤드가 늘 수 있음
//                try {
//                    Thread.sleep(1); // Running 상태에서 Timed_Waiting 일정 시간 웨이팅 상태에 있다가 실행 대기 상태가 됨. 오버헤드가 매우 큼
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }


            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                System.out.print("*");
                Thread.yield();
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });

        // Priority 기능은 있으나, 보장되지 않음
        // 이유는 Starving 하는 Thread 가 없게 하기 위해서 OS 가 조절
        System.out.println(t1.getPriority()); // 우선순위 - 값이 높을 수록 우선순위가 높다

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
    }
}
