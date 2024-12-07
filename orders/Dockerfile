FROM openjdk:21
RUN mkdir /app
COPY ./build/libs/order-service-?.?.?.jar /app/order-service.jar
ENTRYPOINT ["java", "-jar", "/app/order-service.jar"]
