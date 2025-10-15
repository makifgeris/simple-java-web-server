@echo off
chcp 65001 >nul
echo Java Web Sunucusu Derleniyor...
javac -encoding UTF-8 SimpleWebServer.java

if %errorlevel% neq 0 (
    echo Derleme hatasi olustu!
    pause
    exit /b 1
)

echo.
echo Derleme basarili!
echo.
echo Web sunucusu baslatiliyor...
echo Tarayicinizda http://localhost:1989 adresini ziyaret edin
echo Sunucuyu durdurmak icin Ctrl+C tuslayin
echo.

java -Dfile.encoding=UTF-8 SimpleWebServer

pause
