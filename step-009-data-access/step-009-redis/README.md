### Redis db setup on windows
- download redis.zip for windows or get from project root directory
- extract redis.zip
- run redis-server.exe under bin directory

### test
    mvn clean test

### Connect from CMD
    run redis-cli.exe under bin directory
after connect from CMD, then you should run following command:
   
    cmd: keys *
    return: "Model"
    cmd: hgetall Model
    return:
        1) "1"
        2) "{\"id\":\"1\",\"name\":\"Saman Alishiri\",\"email\":\"samanalishiri@gmail.com\"}"
    cmd: hget Model 1
    return:
        "{\"id\":\"1\",\"name\":\"Saman Alishiri\",\"email\":\"samanalishiri@gmail.com\"}"