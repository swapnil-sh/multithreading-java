package multithreadingbasic;

public class MonitorLockThreaOneRunnable implements Runnable{

    MonitorLockExample monitorLockExample;

    MonitorLockThreaOneRunnable(MonitorLockExample monitorLockExample) {
        this.monitorLockExample = monitorLockExample;
    }

    @Override
    public void run() {
        monitorLockExample.task1();
    }
}
