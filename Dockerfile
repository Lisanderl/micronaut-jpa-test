
FROM oracle/graalvm-ce:20.3.0-java11 as graalvm
#NATIVE
#RUN gu install native-image
#
#COPY . /home/app/os-hibernate
#WORKDIR /home/app/os-hibernate
#
#RUN native-image --no-server -cp build/libs/os-hibernate-*-all.jar
#
#FROM frolvlad/alpine-glibc
#RUN apk update && apk add libstdc++
#EXPOSE 8085
#COPY --from=graalvm /home/app/os-hibernate/os-hibernate /app/os-hibernate
#ENTRYPOINT ["/app/os-hibernate"]

#JVM
#FROM adoptopenjdk/openjdk11:ubuntu-jre-nightly
#RUN apt-get update
#RUN && apt install bash-completion && apt install iputils-ping
COPY build/libs/os-hibernate-*-all.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","app.jar"]

