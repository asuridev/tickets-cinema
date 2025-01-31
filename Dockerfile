FROM openjdk:17-alpine3.14 as builder
WORKDIR /app
COPY . .
RUN ./gradlew  build -x test


FROM openjdk:17-alpine3.14
WORKDIR /app
COPY --from=builder /app/build/libs/ticketcinema-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "./ticketcinema-0.0.1-SNAPSHOT.jar"]
