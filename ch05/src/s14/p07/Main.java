package s14.p07;

import java.util.concurrent.Semaphore;

/**
 * 세마포 (Semaphore)
 * 사전적 의미는 횟대 (깃발)
 * - n개의 깃발을 놓고, 여러 스레드가 경쟁하도록 하는 sync 기법
 * - n = 1, BinarySemaphore 라고 하며, Lock 과 유사하게 동작
 *
 */

public class Main {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);

        sem.release(); // 세마포를 획득하고 있지 않아도 release 가능

        System.out.println(sem.availablePermits()); // 세마포의 상태 체크

//        try { // blocking 형태로 동작
//            sem.acquire(); // 세마포를 획득하는 과정
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // sem.acquireUninterruptibly(); // try ~ catch  구문 없이 동작
        // Interrupt() 반응하지 않음.

        System.out.println(sem.tryAcquire()); // blocking 하지 않음 -> Acquire() 할 때 없어도 기다리지 않고 true/false 만 반환
        // 성공하면 true 반환. 실패하면 false 반환하고 다음으로 넘어감
        // blocking  하지않지만 타임아웃 시간을 적고 timeunit을 사용하면 try~catch 문으로 해당 시간동안 기다림


        System.out.println(sem.availablePermits()); // 세마포의 상태 체크
        sem.release();

        System.out.println(sem.availablePermits()); // 세마포의 상태 체크
    }
}
