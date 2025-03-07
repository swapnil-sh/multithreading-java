package stampedlock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    int a = 10;
    StampedLock lock = new StampedLock();

    void producer() {
        long stamp = lock.tryOptimisticRead(); // version no or state of operation
        try {
            System.out.println("Taken optimistic lock : " + Thread.currentThread().getName());
            a = 11;
            Thread.sleep(6000);
            if (lock.validate(stamp)) { // validating if version no or state has changed while curr thread was in sleep
                System.out.println(" Updated value successfully by : " + Thread.currentThread().getName());
            } else {
                System.out.println("Rolling back by : " + Thread.currentThread().getName());
                a = 10;
            }
        } catch (Exception e) {

        }
    }

    void consumer() {
        long stamp = lock.writeLock();
        System.out.println("Write lock acquired by : " + Thread.currentThread().getName());

        try {
            System.out.println("Updating value of a by : " + Thread.currentThread().getName());
            a = 9;
        }
        finally {
            lock.unlockWrite(stamp);
        }
    }
}
