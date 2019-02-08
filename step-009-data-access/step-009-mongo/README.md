##Mongo db setup on windows
- download mongodb.zip
- extract mongodb.zip
- run mongod.exe under bin directory

###Connect from CMD
    run mongo.exe
    after successful connect to server, print test on console (test is default database), then you shuld run following command:
    cmd: use step009
    cmd: db.user.find() 