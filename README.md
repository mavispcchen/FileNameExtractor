File Name Extractor
========================

This is a simple tool to list all the files' name in a root multi-layer folder using spring-kafka.

To sovle the long process time issue when go through a complicated folder.

Try another simpler solution with Blocking-queue under FileNameExtractorWithQueue package.

Requirements
------------

  * Confluent;
  * Spring Boot;
  * Spring Kafka;
  
Set up Confluent
------------

```bash
$ wget http://packages.confluent.io/archive/3.0/confluent-3.0.0-2.11.zip
$ unzip confluent-3.0.0-2.11.zip
$ cd confluent-3.0.0

# start Zookeeper (in a seperate terminal)
./bin/zookeeper-server-start ./etc/kafka/zookeeper.properties

# start Kafka  (in a seperate terminal)
$ ./bin/kafka-server-start ./etc/kafka/server.properties

# start Schema Registry (in a seperate terminal)
$ ./bin/schema-registry-start ./etc/schema-registry/schema-registry.properties
```

Please start the service in order, and Terminate the services with reverse order.

Usage
-----

After started all the Confluent services, run the spring-boot project in FileNameExtractorWithKafka package.

```bash
$ curl -X POST -F 'folder=YOUR FOLDER ABSOLUTE PATH' http://localhost:9000/api/listAllFile
```
