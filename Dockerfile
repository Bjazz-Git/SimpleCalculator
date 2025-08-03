# FROM maven AS builder
# COPY pom.xml .
# RUN mvn -B dependency:go-offline

# COPY . .
# RUN mvn package

# FROM openjdk:11
# COPY --from=builder /target/calculatorProject-*.jar /calculatorProject.jar
# COPY src/main/resources/log4j2.xml ./log4j2.xml
# CMD ["java", "-jar", "/calculatorProject.jar"]

FROM openjdk:11
COPY target/calculatorProject-*.jar /calculatorProject.jar
WORKDIR /usr/src/main/java/PCK1
CMD ["java", "-jar", "/calculatorProject.jar"]