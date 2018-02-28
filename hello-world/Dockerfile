FROM openjdk:8-jre
VOLUME /tmp
ADD target/test-profile-*.jar app.jar
ENTRYPOINT exec java ${JAVA_OPTS} -jar /app.jar