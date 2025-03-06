package multithreadingbasic;

public class MonitorLockExample {
     synchronized void task1() {
         System.out.println("Inside task1..." + Thread.currentThread().getName());
         try {
             Thread.sleep(10000);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
         System.out.println("Ending task1..." + Thread.currentThread().getName());
     }

     void task2() {
         System.out.println("Inside task2 before synchronised..." + Thread.currentThread().getName());
         synchronized(this) {
             System.out.println("Inside task2 after synchronised..." + Thread.currentThread().getName());
         }
     }

     void task3() {
         System.out.println("Inside task3.." + Thread.currentThread().getName());
     }
}