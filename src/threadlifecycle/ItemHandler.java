package threadlifecycle;

public class ItemHandler {
    public static void main(String args[]) {
        System.out.println("App started with : " + Thread.currentThread().getName());
        SharedResource sharedResource = new SharedResource();
        Thread addItemThread = new Thread(new ProduceTask(sharedResource));
        Thread consumeItemThread = new Thread(new ConsumeTask(sharedResource));
        addItemThread.start();
        consumeItemThread.start();
//        Thread comsumerThread = new Thread(() -> {
//            System.out.println("Begin ConsumeTask with Thread: " + Thread.currentThread().getName());
//            sharedResource.consumeItem();
//            System.out.println("End ConsumeTask with Thread: " + Thread.currentThread().getName());
//        });
        System.out.println("App ended with : " + Thread.currentThread().getName());
    }
}
