FROM openjdk:11
COPY target/calculatorProject-*.jar /calculatorProject.jar
WORKDIR /usr/src/main/java/PCK1
CMD ["java", "-jar", "/calculatorProject.jar"]