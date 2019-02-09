### Mongo db setup on windows
- download mongodb.zip
- extract mongodb.zip
- run mongod.exe under bin directory

### test
    mvn clean test
### Connect from CMD
    run mongo.exe under bin directory
after successful connect to server, print test on console (test is default database), then you should run following command:
   
    cmd: use step009
    cmd: db.user.find() 