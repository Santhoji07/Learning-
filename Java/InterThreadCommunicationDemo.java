class SharedBuffer {
    int data;
    boolean available = false;

    // Producer writes data
    synchronized void produce(int value) {
        while (available) {
            try {
                wait(); // Wait until data is consumed
            } catch (InterruptedException e) {
                System.out.println("Producer interrupted");
            }
        }

        data = value;
        available = true;
        System.out.println("Produced: " + data);
        notify(); // Notify consumer
    }

    // Consumer reads data
    synchronized int consume() {
        while (!available) {
            try {
                wait(); // Wait until data is produced
            } catch (InterruptedException e) {
                System.out.println("Consumer interrupted");
            }
        }

        available = false;
        System.out.println("Consumed: " + data);
        notify(); // Notify producer
        return data;
    }
}

// Producer thread
class Producer extends Thread {
    SharedBuffer buffer;

    Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.produce(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
    }
}

// Consumer thread
class Consumer extends Thread {
    SharedBuffer buffer;

    Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.consume();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
    }
}

// Main class
public class InterThreadCommunicationDemo {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();
        Producer p = new Producer(buffer);
        Consumer c = new Consumer(buffer);

        p.start();
        c.start();
    }
}
