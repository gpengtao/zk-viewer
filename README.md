View zookeeper data, using java, spring boot.

### Usage:
#### 1、download release jar or manually `mvn clean package` source code
#### 2、run the jar
For example:
`jar -jar zk-viewer-1.0.0.jar --server.port=8888 --zkAddress=10.0.0.1:2181,10.0.0.2:2181 &`

server.port is http port, default is 8080 if not define.\
zkAddress is your zookeeper address.


![like this](https://github.com/gpengtao/zookeeper-browser/blob/master/screen.png "")

