## dependencies
- Runs on MacOS
- Java 14

## build

```sh
javac -sourcepath src/main/java/  -d ./out  src/main/java/com/kodokoto/gotchimon/App.java && cp -r src/main/resources/maps out && cp -r src/main/resources/sprites out/sprites && cp -r src/main/resources/saves out/saves
```

## run

```sh
java -cp ./out com.kodokoto.gotchimon.App
```