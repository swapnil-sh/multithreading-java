package readwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockHandler {
    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();

        SharedResource resource1 = new SharedResource();
        Thread t1 = new Thread(() -> {
           resource1.producer(lock);
        });

        Thread t2 = new Thread(() -> {
            resource1.producer(lock);
        });

        SharedResource resource2 = new SharedResource();
        Thread t3 = new Thread(() -> {
            resource2.consumer(lock);
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
