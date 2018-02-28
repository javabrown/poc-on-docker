echo off

rem start mvn clean package

rem echo Running DEV profile:
rem java -jar target\test-profile-1.0.jar

echo Running PROD profile:
java -jar -Dspring.profiles.active=prod target\test-profile-1.0.jar