FROM amazoncorretto:22

LABEL version="1.0"

Expose 8080:8080

WORKDIR /app

COPY target/Docker-Demo-Learning-0.0.1-SNAPSHOT.jar /app/Docker-Demo-Learning.jar

ENTRYPOINT ["java","-jar","Docker-Demo-Learning.jar"]

