package reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable=false;

    void producer(ReentrantLock reentrantLock) {
        try {
            reentrantLock.lock();
            System.out.println("Lock acquired by : " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        } catch (Exception e) {

        } finally {
            System.out.println("Lock released by : " + Thread.currentThread().getName());

            reentrantLock.unlock();
        }
    }
}
