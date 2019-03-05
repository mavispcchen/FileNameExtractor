package com.mavis.FileNameExtractorWithQueue;
import java.io.File;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
    private BlockingQueue<File> blockingQueue;
    private File folder;

    public Producer(BlockingQueue<File> blockingQueue, File folder) {
        this.blockingQueue = blockingQueue;
        this.folder = folder;
    }

    @Override
    public void run() {
        try {
            blockingQueue.put(folder);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}