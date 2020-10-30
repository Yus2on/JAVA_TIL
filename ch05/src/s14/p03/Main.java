package s14.p03;

public class Main {
    public static void main(String[] args) {
        Thread p1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // e.printStackTrace();
                System.out.println("Interrupted");
            }
            System.out.println("P1!");
        });

        Thread p2 = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("P2!");
            p1.interrupt(); // 기존 동작을 뱅하하고 반응을 강제하는 메서드
                            // 주로 임베디드에서 사용
        });

        p1.start();
        p2.start();
    }
}
