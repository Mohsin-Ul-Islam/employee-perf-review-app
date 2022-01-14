FROM openjdk:11 AS development

WORKDIR /app

COPY ./ ./

CMD [ "./mvnw", "spring-boot:run" ]
