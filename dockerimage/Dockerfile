FROM openjdk:15.0.1-slim-buster

#add new user, so we do not work as root, we do not need root, we are listening on port 8080
#make new user
RUN useradd --create-home --shell /bin/bash testuser
#switch to new user
USER testuser

#make a new dir, simplelog, where we store everything
RUN mkdir -p /home/testuser/simplelog
#set it as entry point
WORKDIR /home/testuser/simplelog

#make simpelog.jar available
COPY ./*.jar simplelog.jar

#download tini and set it as startprogram (for better SIGNAL & process handling by Docker. (not necessary in K8s)
ENV TINI_VERSION v0.19.0
ADD https://github.com/krallin/tini/releases/download/${TINI_VERSION}/tini tini
USER root
RUN chown testuser tini
RUN chmod +x tini
USER testuser
ENTRYPOINT ["./tini", "--"]
CMD ["java", "-jar", "/home/testuser/simplelog/simplelog.jar"]
