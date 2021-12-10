FROM tomcat:8.0.15-jre8
MAINTAINER zl@qq.com
RUN echo 'start build contain volume image for tomcat>>>>>>>>>>'
COPY ./docker.war /usr/local/tomcat/webapps
#宿主机与容器内部目录进行挂载
VOLUME ['/usr/local/tomcat/webapps','/usr/local/tomcat/conf']
ARG NODE_VERSION=7.0.0
RUN echo 'node版本号'+NODE_VERSION
#EXPOSE 8888
RUN echo 'end build contain volume image for tomcat>>>>>>>>>>'


