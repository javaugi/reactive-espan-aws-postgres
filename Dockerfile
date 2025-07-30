FROM eclipse-temurin:21
WORKDIR /app
#
#COPY DocumentDbEmulatorCertificate.cer /tmp/
#RUN keytool -import -trustcacerts -alias cosmosdb-emulator \
#    -file /tmp/DocumentDbEmulatorCertificate.cer \
#    -keystore $JAVA_HOME/lib/security/cacerts \
#    -storepass changeit -noprompt
#
COPY target/compass.jar app.jar
EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "app.jar"]
ENTRYPOINT ["java", "-Dcom.sun.net.ssl.checkRevocation=false", "-Djdk.internal.httpclient.disableHostnameVerification=true", "-jar", "app.jar"]