package threadlifecycle;

public class SharedResource {
    boolean itemAvailable = false;

    // synchronised puts the monitor lock
    synchronized void addItem() {
        itemAvailable = true;
        System.out.println("Item added by : " + Thread.currentThread().getName());
        notifyAll();
    }

    synchronized void consumeItem() {
        // using while loop to avoid "spurious wakeup"
        while (!itemAvailable) {
            try {
                System.out.println("Waiting for the item to be available " + Thread.currentThread().getName());
                wait(); // releases monitor locks
            } catch (Exception e) {

            }
        }
        System.out.println("Item Consumed by " + Thread.currentThread().getName());
        itemAvailable = false;
    }
}
