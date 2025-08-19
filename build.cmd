@echo off
REM 设置 JAVA_HOME 环境变量
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_251

REM Maven 打包命令（跳过测试）
echo 正在打包项目（跳过测试）...
call .\mvnw.cmd clean package -DskipTests

if %ERRORLEVEL% EQU 0 (
    echo.
    echo 打包成功！
    echo JAR文件位置: target\linuxCommandListener-0.0.1-SNAPSHOT.jar
    echo.
    echo 运行应用程序:
    echo java -jar target\linuxCommandListener-0.0.1-SNAPSHOT.jar
) else (
    echo.
    echo 打包失败！
)

pause
