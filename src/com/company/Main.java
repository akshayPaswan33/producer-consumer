package com.company;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
        BlockingQueue<Integer> blockingQueue = new BlockingQueueWaitNotify<>(10);

        Thread producerThread = new Thread(() -> {
           Producer producer = new Producer(blockingQueue);
            try {
                while(true) {
                    producer.produce();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            Consumer consumer = new Consumer(blockingQueue);
            try {
                while(true) {
                    consumer.consume();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
