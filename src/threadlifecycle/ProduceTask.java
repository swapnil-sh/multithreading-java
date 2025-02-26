package threadlifecycle;

public class ProduceTask implements Runnable{
    SharedResource sharedResource;

    ProduceTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("Begin ProduceTask with Thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Exception occurred in Thread: " + Thread.currentThread().getName());
        }
        sharedResource.addItem();
        System.out.println("End ProduceTask with Thread: " + Thread.currentThread().getName());
    }
}
