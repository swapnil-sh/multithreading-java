package deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource {
    String name;
    Lock lock = new ReentrantLock();

    public Resource(String name) {
        this.name = name;
    }
}
