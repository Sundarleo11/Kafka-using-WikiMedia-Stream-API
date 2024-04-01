Install Kafka’s binary file.
Unzip it in C drive and rename the folder as kafka. Output: C:/kafka.
Inside C:/kafka/config:
    Go to server.properties > Log basics > log.dirs=c:/kafka/kafka-logs
    Go to zookeeper.properties > dataDir=c:/kafka/zookeeper-data


Open CMD at C:/kafka and run the following commands (include .\bin in cmd):
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
.\bin\windows\kafka-server-start.bat .\config\server.properties
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic users --from-beginning
