FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY build/libs/*.jar posts.jar
ENTRYPOINT ["java","-jar","/posts.jar"]
EXPOSE 8080