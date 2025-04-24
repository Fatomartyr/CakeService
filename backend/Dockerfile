FROM amazoncorretto:21.0.6
LABEL authors="Nikita Agafonov"

EXPOSE 8080

WORKDIR /backend/

COPY ./gradle/ ./gradle/
COPY build.gradle gradlew ./
RUN chmod +x gradlew
RUN ./gradlew dependencies --no-daemon

COPY . .
RUN ./gradlew clean build --no-daemon
CMD ["java", "-jar", "build/libs/backend.jar"]