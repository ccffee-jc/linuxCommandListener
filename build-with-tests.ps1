# PowerShell 完整打包脚本（包含测试）

# 设置 JAVA_HOME 环境变量
$env:JAVA_HOME = "C:\Program Files\Java\jdk1.8.0_251"

Write-Host "正在打包项目（包含测试）..." -ForegroundColor Green

# Maven 打包命令（包含测试）
& .\mvnw.cmd clean package

if ($LASTEXITCODE -eq 0) {
    Write-Host ""
    Write-Host "打包成功！" -ForegroundColor Green
    Write-Host "JAR文件位置: target\linuxCommandListener-0.0.1-SNAPSHOT.jar" -ForegroundColor Yellow
    Write-Host ""
    Write-Host "运行应用程序:" -ForegroundColor Cyan
    Write-Host "java -jar target\linuxCommandListener-0.0.1-SNAPSHOT.jar" -ForegroundColor White
} else {
    Write-Host ""
    Write-Host "打包失败！" -ForegroundColor Red
}

Read-Host "按任意键继续..."
