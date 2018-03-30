set SERVER_DN="CN=10.168.1.68, OU=localhost, O=localhost, L=hangzhou, S=zhejiang, C=CN" 
set CLIENT_DN="CN=client, OU=client, O=client, L=hangzhou, S=zhejiang, C=CN"
set CPASS_SET="client"
set SPASS_SET="tomcat"
set CER_ROOT_PATH="e:\SSL"
:: 路径不存在则创建路径
if not exist %CER_ROOT_PATH% md %CER_ROOT_PATH%
::制作 keystore

:: 为服务器生成证书
keytool -genkey -alias tomcat -keyalg RSA -keystore %CER_ROOT_PATH%/tomcat.keystore -dname %SERVER_DN% -storepass %SPASS_SET% -keypass %SPASS_SET% -validity 36500

:: 导出服务器证书，后面要导入到客户端，以便客户端信任服务端
:: 将tomcat.cer证书填入到“受信任的根证书颁发机构”
keytool -export -alias tomcat -keystore %CER_ROOT_PATH%/tomcat.keystore -storepass %SPASS_SET% -rfc -file %CER_ROOT_PATH%/tomcat.cer

:: 为客户端生成证书
keytool -genkey -alias client -keyalg RSA -storetype PKCS12 -keystore %CER_ROOT_PATH%/client.p12 -dname %CLIENT_DN% -keypass %CPASS_SET% -storepass %CPASS_SET% -validity 36500


:: 导出客户端证书，后面要导入到服务端，以便服务端信任客户端
keytool -export -alias client -storetype PKCS12 -keystore %CER_ROOT_PATH%/client.p12 -storepass %CPASS_SET% -rfc -file %CER_ROOT_PATH%/client.cer


:: 导入客户端证书到服务端的可信列表
keytool -import -file %CER_ROOT_PATH%/client.cer -storepass %SPASS_SET% -keystore %CER_ROOT_PATH%/tomcat.keystore -noprompt




:: https://blog.csdn.net/qq_26708427/article/details/68491201

pause