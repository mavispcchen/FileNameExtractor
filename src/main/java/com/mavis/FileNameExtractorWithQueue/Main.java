package com.mavis.FileNameExtractorWithQueue;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {

    public static void main(String[] args) {

        BlockingQueue<File> blockingQueue = new LinkedBlockingDeque<>(1000);
        File folder = new File(args[args.length-1]);
        new Thread(new Producer(blockingQueue, folder), "Producer").start();

        for (int i = 0; i < 3; i++) {
            new Thread(new Consumer(blockingQueue), "Consumer" + i).start();
        }
    }
}
