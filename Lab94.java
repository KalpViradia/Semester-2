class SharedBuffer {
    private int data;
    private boolean available = false;

    synchronized int get() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = false;
        notifyAll();
        return data;
    }

    synchronized void put(int data) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.data = data;
        available = true;
        notifyAll();
    }
}

class ProducerConsumerThread extends Thread {
    private SharedBuffer buffer;
    private boolean isProducer;

    public ProducerConsumerThread(SharedBuffer buffer, boolean isProducer) {
        this.buffer = buffer;
        this.isProducer = isProducer;
    }

    @Override
    public void run() {
        if (isProducer) {
            buffer.put(1);
            System.out.println("Thread " + Thread.currentThread().getName() + " sent 1");
            int[] numbers = {2, 3, 4};
            for (int number : numbers) {
                buffer.put(number);
                System.out.println("Thread " + Thread.currentThread().getName() + " sent " + number);
            }
        } else {
            int data = buffer.get();
            System.out.println("Thread " + Thread.currentThread().getName() + " received " + data);
            while (data != 2) {
                data = buffer.get();
                System.out.println("Thread " + Thread.currentThread().getName() + " received " + data);
            }
        }
    }
}

public class Lab94 {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();
        ProducerConsumerThread producer = new ProducerConsumerThread(buffer, true);
        ProducerConsumerThread consumer = new ProducerConsumerThread(buffer, false);

        producer.setName("Producer");
        consumer.setName("Consumer");

        producer.start();
        consumer.start();
    }
}