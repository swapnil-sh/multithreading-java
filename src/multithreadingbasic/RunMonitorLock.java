package multithreadingbasic;

public class RunMonitorLock {

    public static void main(String[] args) {
        MonitorLockExample lockExample = new MonitorLockExample();
        MonitorLockThreaOneRunnable monitorLockThreaOneRunnable = new MonitorLockThreaOneRunnable(lockExample);

        Thread t1 = new Thread(monitorLockThreaOneRunnable);

        Thread t2 = new Thread(() -> {
            lockExample.task2();
        });
        Thread t3 = new Thread(() -> {
            lockExample.task3();
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
