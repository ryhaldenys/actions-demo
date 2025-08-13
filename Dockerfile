#FROM bellsoft/liberica-openjre-alpine:17.0.3
#WORKDIR /usr/share/app
#COPY config/target/*.jar app.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "app.jar"]

FROM alpine:3.10

COPY entrypoint.sh entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]