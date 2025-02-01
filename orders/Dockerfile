FROM openjdk:21
RUN mkdir /app
COPY ./build/libs/orders-?.?.?.jar /app/orders.jar
ENTRYPOINT ["java", "-jar", "/app/orders.jar"]
