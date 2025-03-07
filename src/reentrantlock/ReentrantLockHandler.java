package reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockHandler {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        SharedResource resource1 = new SharedResource();

        Thread t1 = new Thread(() -> {
            resource1.producer(lock);
        });

        SharedResource resource2 = new SharedResource();
         Thread t2 = new Thread(() -> {
             resource2.producer(lock);
         });
         t1.start();
         t2.start();
    }
}
