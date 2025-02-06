FROM openjdk:21
RUN mkdir /app
COPY ./build/libs/iam-proxy-?.?.?.jar /app/iam-proxy.jar
ENTRYPOINT ["java", "-jar", "/app/iam-proxy.jar"]
