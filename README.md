### 后台运行方式
1. 命令行
```shell
# 工程跟目录下
# 编译jar
mvn clean package -Dmaven.test.skip
# 运行jar
java -jar target/api-0.0.1-SNAPSHOT.jar 
```
2. Intellij Idea
IDE打开项目，运行ServerApplication.kt的main方法

### 访问后台接口
参考DiaryControllerTest.kt
