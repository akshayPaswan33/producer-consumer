package com.company;

import java.util.concurrent.BlockingQueue;

public class Consumer {
    private final BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void consume() throws InterruptedException {
        Thread.sleep(1000);
        Integer head = blockingQueue.take();
        System.out.println("Consumed: "+head);
    }
}
