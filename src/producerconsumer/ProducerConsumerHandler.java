package producerconsumer;


public class ProducerConsumerHandler {
    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource(4);

        Thread producer = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i=1; i<=8; i++)
                sharedResource.producer(i);
        });

        Thread consumer = new Thread(() -> {
            for (int i=1; i<=4; i++)
                sharedResource.consumer();
        });

        producer.start();
        consumer.start();
    }
}
