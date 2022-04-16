package com.company;

import java.util.concurrent.BlockingQueue;

public class Producer {
    private final BlockingQueue<Integer> blockingQueue;
    private int ind;

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
        ind = 0;
    }

    public void produce() throws InterruptedException {
        Thread.sleep(500);
        blockingQueue.put(ind);
        System.out.println("Produced: "+ind);
        ind++;
    }
}
