FROM openjdk
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} add.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "/app.jar"]
