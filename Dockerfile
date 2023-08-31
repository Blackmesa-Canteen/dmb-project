FROM gradle:jdk17-alpine
RUN mkdir /home/gradle/buildWorkspace
COPY . /home/gradle/buildWorkspace

WORKDIR /home/gradle/buildWorkspace
RUN ls /home/gradle/buildWorkspace
RUN gradle build --no-daemon
RUN ls /home/gradle/buildWorkspace/build/libs

ENTRYPOINT ["java","-jar","/home/gradle/buildWorkspace/build/libs/dynamic_menu_builder-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080