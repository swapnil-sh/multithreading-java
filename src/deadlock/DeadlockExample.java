package deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
    public static void main(String[] args) {
        final Resource resource1 = new Resource("Resource1");
        final Resource resource2 = new Resource("Resource2");
        Thread thread1 = new Thread(() -> {
            try {
                // Thread 1 tries to lock resource1 first and then resource2
                if (resource1.lock.tryLock()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ": locked " + resource1.name);
                        // Adding sleep to simulate some work
                        Thread.sleep(50);
                        if (resource2.lock.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getName() + ": locked " + resource2.name);
                            } finally {
                                resource2.lock.unlock();
                            }
                        }
                    } finally {
                        resource1.lock.unlock();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread thread2 = new Thread(() -> {
            try { // Thread 2 tries to lock resource2 first and then resource1
                if (resource2.lock.tryLock()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ": locked " + resource2.name); // Adding sleep to simulate some work
                        Thread.sleep(50);
                        if (resource1.lock.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getName() + ": locked " + resource1.name);
                            } finally {
                                resource1.lock.unlock();
                            }
                        }
                    } finally {
                        resource2.lock.unlock();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        thread1.start();
        thread2.start();
    }
}