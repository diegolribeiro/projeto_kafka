FROM adoptopenjdk/openjdk11:latest
COPY consumidor-*.jar app.jar
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]