package s14.p01;

/**
 * Multi-Thread Programming
 * 여러개의 스레드를 사용하는 프로그래밍 기법
 *
 * THread : 최소의 프로세스 동작 단위 -> 하나의 프로세스는 여러개의 스레드를 가질 수 있다 (하나의 스레드는 하나의 스레드에 속함)
 * Process : OS로부터 메모리를 할당받아 동작하는 프로그램의 동작 단위 (램에 상주 )
 *           프로그램이 실제로 메모리에 상주하면서 동작할 떄 프로세스가 된다.
 *           - 프로그램을 실행할 때 멀티 프로세스로 동작하는 프로그램도 존재 (최근에는 멀티 프로세스 거의 없음)
 *           - 프로세스 끼리 메모리를 공유하는 공간은 없음 -> OS에 요청해서 시스템콜
 *
 * 장점
 * - 여러 동작을 병렬적으로 처리하여 CPU 사용률 향상(CPU Utilization)
 *  - 인코딩, 렌더링 작업, 배치작업(DB 정리, 로그 처리) etc (CPU가 다른 작업 하지 않고 현재 작업에 집중하는 것들)
 * - 시간이 걸리는 동작을 분리하여 프로그램의 응답성 향상
 *  - GUI, 게임, APP, web API,
 *
 * 단점
 * - 디버깅이 어렵다. ( = 스레드가 동시 동작하기 때문에, 디버거로 확인하기 어려움)
 *   디버거를 쓰거나, 딥깅을 하기 위한 코드를 추가하면 동작이 변한다.
 * - 구현이 어렵다. 쓰레드 간의 동기화를 하기 위한 구현이 없다. 쉽게 동기하하면 느려진다.
 *  - Contextx switching 오버헤드가 있기 때문에 동기화를 잘못하면 오히려 더 느려짐
 *
 *
 */



// 3. Thread 클래스를 상속하여 Override
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
        }
        System.out.println();
    }
}


public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread p1 = new Thread(new Runnable() { // 1. 익명 내부 클래스
            @Override
            public void run() {
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("Hello Thread");
            }
        });

        // Thread 객체는 1회용이며, start()로 실행한다.
//        p.run(); // 그냥 메소드 콜
//        p.run(); // 그냥 메소드 콜이니까 다시 동작해도 잘 됨
//        p.start(); // Thread 객체는 1회용이므로 start()가 재실행될 수 없음

        Thread p2 = new Thread(() -> { // 2. 람다식 구현
//            System.out.println("Thread by lambda");
            while (true) {

            }
        });
        p2.start();

//        p2.join(); // sleep 없이 join으로 싱크를 맞출 수 있다. Blocking 동작
        p2.join(100); // 100ms동안 기다린 후 강제로 동작


        p1.start(); // 실제로 OS에 스레드 동작을 요청

//        Thread.sleep(100); // Sleep을 이용해서 시간차를 줄 수 있다.
        p1.join();

        Thread thread = new MyThread();
        thread.start();

        // 4. 구현후 즉시 실행
        new Thread(() -> {
            System.out.println("IDEA");
        }).start(); // 이렇게 하면 join 등 활용이 어려움

        System.out.println("Main thread ended");
    }
}