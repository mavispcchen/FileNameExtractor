package com.mavis.FileNameExtractorWithKafka.controller;

import com.mavis.FileNameExtractorWithKafka.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class APIController {

    private final Producer producer;

    @Autowired
    APIController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/listAllFile")
    public void listAllFile(@RequestParam("folder") String folder) {
        this.producer.addFolder(folder);
    }
}