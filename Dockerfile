FROM openjdk:11
COPY ./bin /tmp
WORKDIR /tmp
ENTRYPOINT ["java","App"]
