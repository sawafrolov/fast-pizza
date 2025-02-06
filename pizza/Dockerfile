FROM openjdk:21
RUN mkdir /app
COPY ./build/libs/pizza-?.?.?.jar /app/pizza.jar
ENTRYPOINT ["java", "-jar", "/app/pizza.jar"]
