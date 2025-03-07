package conditioncustomlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable=false;
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition condition = reentrantLock.newCondition();

    void producer() {
        try {
            reentrantLock.lock();
            System.out.println("Producer Lock acquired by : " + Thread.currentThread().getName());
            if(isAvailable) {
                // already available, thread has to wait for it to consume
                System.out.println("Producer thread is waiting  : " + Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = true;
            condition.signal();
        } catch (Exception e) {

        } finally {
            System.out.println("Producer Lock released by : " + Thread.currentThread().getName());
            reentrantLock.unlock();
        }
    }

    void consumer() {
        try {
            Thread.sleep(4000);
            reentrantLock.lock();
            System.out.println("Consumer Lock acquired by : " + Thread.currentThread().getName());
            if (!isAvailable) {
                System.out.println("Consumer thread is waiting: " + Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = false;
            condition.signal();
        } catch (Exception e) {

        } finally {
            System.out.println("Consumer Lock released by : " + Thread.currentThread().getName());
            reentrantLock.unlock();
        }
    }
}
