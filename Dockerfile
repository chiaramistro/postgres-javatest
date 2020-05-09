FROM openjdk:8
COPY ./PostgreSQLJDBC/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "Main"]