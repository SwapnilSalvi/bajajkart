FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/bajajkart.jar .
EXPOSE 8080
CMD [ "java","-jar","bajajkart.jar" ]

# ENTRYPOINT - Has highest priority and cannot be changed
# CMD - Can be changed