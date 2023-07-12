FROM amazoncorretto:17-alpine

ARG APP_NAME=vehiclelog
ARG APP_VERSION=0.0.1-SNAPSHOT

RUN adduser --system "$APP_NAME" && mkdir /log  && chown "$APP_NAME" /log

USER $APP_NAME

COPY target/"$APP_NAME"-"$APP_VERSION".jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
