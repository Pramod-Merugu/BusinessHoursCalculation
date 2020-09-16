FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/BusinessHoursCalculation-0.0.1-SNAPSHOT.jar BusinessHoursCalculator.jar
ENTRYPOINT ["java","-jar","BusinessHoursCalculator.jar"]