From centos

RUN yum install -y java

FROM maven:3.5-jdk-8-alpine as build (2)
WORKDIR /app
COPY --from=clone /app/spring-petclinic /app (3)
RUN mvn install

VOLUME /tmp
ADD /target/twitter-client-1.0.0.jar twitter-client.jar
RUN sh -c 'touch /twitter-client.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/;/urandom","-jar","/twitter-client.jar"]

