package producerconsumer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SharedResource {
    private Queue<Integer> bufferQueue;
    private int bufferSize;
    

    SharedResource(int bufferSize) {
        bufferQueue = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    synchronized void producer(int x) {
        System.out.println("Inside producer = " + Thread.currentThread().getName());
        while (bufferQueue.size() == bufferSize) {
            try {
                System.out.println("Waiting Inside producer as  queue is full = " + Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Producer item added = " +  x + " " + Thread.currentThread().getName());
        bufferQueue.add(x);
        notify();
    }
    
    synchronized void consumer() {
        System.out.println("Inside consumer = " + Thread.currentThread().getName());
        while (bufferQueue.isEmpty()) {
            try {
                System.out.println("Queue empty Waiting Inside consumer = " + Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int item = bufferQueue.poll();
        System.out.println("Item consumed = " + item + " " + Thread.currentThread().getName());
        notify();
    }
}
