FROM openjdk:21
RUN mkdir /app
COPY ./build/libs/customers-?.?.?.jar /app/customers.jar
ENTRYPOINT ["java", "-jar", "/app/customers.jar"]
