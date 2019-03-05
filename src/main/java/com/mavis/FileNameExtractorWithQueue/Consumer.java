package com.mavis.FileNameExtractorWithQueue;

import java.io.File;
import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable {

    private BlockingQueue<File> blockingQueue;

    public Consumer(BlockingQueue<File> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                File task = blockingQueue.take();
                for (File fileEntry : task.listFiles()) {
                    if (fileEntry.isDirectory()) {
                        blockingQueue.put(fileEntry);
                    } else {
                        System.out.println(fileEntry.getName());
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}