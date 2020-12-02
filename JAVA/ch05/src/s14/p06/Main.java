package s14.p06;

class WorkObject {
    public synchronized void methodA(){
        System.out.println("methodA() call");
        //  notify(), wait()은 synchronized 블록 안에서 가능
        notify(); // wait() 중인 다른 스레드를 하나 동작 상태로 만듦 -> 다른 스레드가 들어와도 된다고 하는 것
        // notifyAll(); // notify()는 하나만, all() 은 전부 다
        try {
            wait(); // Lock 을 반환 하고 대기 상태로 들어감 -> notify 에서 들어올 수 있다고 신호를 주고 wait 상태가 되면 들어옴.
            // 메소드 A가 먼저 실행 ->  wait 상태(notify 는 효과 없음 ) -> lock을 반환 ->  메소드 B가 lack 을 얻고 메소드 B가 notify()
            // -> 메소드 B가 wait() -> 메소드 A가 다시 notify() -> 메소드 A가 wait() 상태 -> 반복
            // notify 와 wait 의 순서가 변경되면 안 됨
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void methodB() {
        System.out.println("methodB() call");
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // method A와 동일
    public void methodASAME(){
        synchronized (this) {
            System.out.println("methodA() call");
            //  notify(), wait()은 synchronized 블록 안에서 가능
            notify(); // 대기 중인 다른 스레드를 하나 동작 상태로 만듦 -> 다른 스레드가 들어와도 된다고 하는 것
            // notifyAll(); // notify()는 하나만, all() 은 전부 다
            try {
                wait(); // 대기 상태로 들어감 -> notify 에서 들어올 수 있다고 신호를 주고 wait 상태가 되면 들어옴.
                // notify 와 wait 의 순서가 변경되면 안 됨
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread extends Thread {
    private final WorkObject WorkObject;
    private boolean isA;

    public MyThread(WorkObject workObject, boolean isA ) { // Dependency Injection
        // 외부에서 WokrObject 생성ㅇ해서 주입
        this.WorkObject = workObject;
        this.isA = isA;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (isA) {
                WorkObject.methodA();
            } else {
                WorkObject.methodB();
            }
        } // end for
    }

}

public class Main {
    public static void main(String[] args) {
        WorkObject sharedObject = new WorkObject();

        Thread p1 = new MyThread(sharedObject, true);
        Thread p2 = new MyThread(sharedObject, false);

        p1.start();
        p2.start();
    }
}
