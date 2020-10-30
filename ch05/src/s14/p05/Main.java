package s14.p05;


/**
 * Intrinsic Lock (고유 락) 과 synchronized 키워드
 * - 자바의 모든 객체 (Object) 는 고유 락을 가지고 있음
 *  - 객체의 소유권을 한정하는 내부적인 구현 -> 소유권은 독점적
 * - synchronized를 이용하면 객체의 고유 락의 소유권을 가져올 수 있다.
 *  - 소유권이 이미 점유된 경우에는 Blocking 으로 동작
 *
 */

// 1, 멀티 스레드 동작에 취약
class Counter {
    private int count = 0;
    public int increaseCont() {
        return ++ count; // 읽고, 수정하고, 쓰는 작업
                        // 경쟁적으로 동작하다 보면 읽고 수정하고 쓰기 전에 다른 스레드가 읽는 경우가 발생
    }

    public int getCount() {
        return count;
    }
}

// 2. Object 객체의 Intrinsic Lock 을 구현 - 굳이 이렇게 할 필요 없음
/*class Counter {
    private Object count = new Object();
    private int count = 0;
    public int increaseCont() {
        synchronized (lock) {
            return ++count;
        }
    }

    public int getCount() {
        return count;
    }
}*/


// 3. this 객체의 Intrinsic Lock 을 이용한 구현 -> 가장 좋은 방법
// 가장 좁은 영역에서 Intrinsic Lock  를 사용함
// 넓은 영역에서 Intrinsic Lock 이 사용될 경유 병렬동작이 줄어들고 순차적으로 바뀌면서 성능이 떨어짐
/*class Counter {
    private int count = 0;
    public int increaseCont() {
        synchronized (this) {
            return ++count;
        }
    }

    public int getCount() {
        return count;
    }
}*/


/*// 4. 메소드에 synchronized 키워드 사용
// synchronized 키워드가 사용된 메소드를 호출하기 위해서는
// 해당 캑체를 소유해야만 호출이 가능. 소유하지 못하면 Blocking
class Counter {
    private int count = 0;
    public int increaseCont() {
            return ++count;
    }

    public int getCount() {
        return count;
    }
}*/

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter(); // 이 객체를 100개의 스레드가 서로 동작시키고 싶어하는 것.
        // 이 스레드가 동시에 실행 시키면 문제가 생기기 때문에 한 스레드가 한번의 동작만 가능. 스레드 하나 동작 시 다른 스레드가 침범 불가능

        for(int i = 0; i <100; i++) {
            new Thread(() -> {
                //synchronized (c) { // 이렇게 싱크를 하면 전혀 병렬적으로 돌지 않음 ...
                    // 스레드가 하나가 100번 동작하고 끝나면 다른 스레드가 100번 동작하게 됨. 단일 스레드처럼 순차적으로 동작함
                    // 가장 안전하지만 가장 효율이 떨어지는 코드가 됨
                    for (int j = 0; j < 100; j++) {
                        // c 라는 shared object (공유 객체) 가 있을 때
                        // 멀티 스레드로부터 안전한 영역을 생성하는 방법
                        synchronized (c) { // c의 고유 락을 획득해야만 동작
                            c.increaseCont();
                        }
                    }
               // }
            }).start();
        }// end for

        Thread.sleep(1000);
        System.out.println(c.getCount());

    }
}
