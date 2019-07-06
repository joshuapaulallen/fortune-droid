FROM openjdk:11.0.3-jdk

# not essential, but can be necessary for other Spring Boot applications if they need to actually write in the filesystem
# see: https://spring.io/guides/gs/spring-boot-docker/
VOLUME /tmp

# install fortune command line program
RUN apt-get update
RUN apt-get upgrade -y
RUN apt-get install -y fortune

# move fortune to a "standard" $PATH folder
RUN mv /usr/games/fortune /usr/local/bin/

# copy the fortune-droid app into the container
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

# start me up
ENTRYPOINT ["java","-cp","app:app/lib/*","org.yourotherleft.fortunedroid.FortuneDroidApplication"]