FROM amazoncorretto:17-alpine

ARG APP_NAME=vehiclelog
ARG APP_VERSION=0.0.1-SNAPSHOT

WORKDIR /app

RUN adduser --system "$APP_NAME" && mkdir /log  && chown "$APP_NAME" /log

USER $APP_NAME

COPY build/libs/"$APP_NAME"-"$APP_VERSION".jar app/app.jar

CMD ["java", "-jar", "app/app.jar"]
