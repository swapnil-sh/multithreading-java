package readwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource {
    boolean isAvailable = false;

    void producer(ReadWriteLock readLock) {
        try {
            readLock.readLock().lock();
            System.out.println("Read Lock acquired by : " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(8000);
        } catch (Exception e) {
        }
        finally {
            System.out.println("Read Lock released by : " + Thread.currentThread().getName());
            readLock.readLock().unlock();
        }
    }

    void consumer(ReadWriteLock writeLock) {
        try {
            writeLock.writeLock().lock();
            System.out.println("Write Lock acquired by : " + Thread.currentThread().getName());
            isAvailable = false;
        } catch (Exception e) {

        }
        finally {
            System.out.println("Write Lock released by : " + Thread.currentThread().getName());
            writeLock.writeLock().unlock();
        }
    }
}
