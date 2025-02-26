package threadlifecycle;

public class ConsumeTask implements Runnable{

    SharedResource sharedResource;

    ConsumeTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("Begin ConsumeTask with Thread: " + Thread.currentThread().getName());
        sharedResource.consumeItem();
        System.out.println("End ConsumeTask with Thread: " + Thread.currentThread().getName());
    }
}
