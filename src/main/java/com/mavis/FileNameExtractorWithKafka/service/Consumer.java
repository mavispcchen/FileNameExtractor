package com.mavis.FileNameExtractorWithKafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;


@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    private final Producer producer;

    @Autowired
    Consumer(Producer producer) {
        this.producer = producer;
    }

    @KafkaListener(topics = "list", groupId = "group_id")
    public void getFolder(String folder) throws IOException {
        logger.info("Consumer - Folder: " + folder);
        if (!folder.isEmpty()){

            File file = new File(folder);
            for (File fileEntry : file.listFiles()) {
                if (fileEntry.isDirectory()) {
                    this.producer.addFolder(fileEntry.getAbsolutePath());
                } else {
                    System.out.println(fileEntry.getName());
                }
            }
        }
    }
}