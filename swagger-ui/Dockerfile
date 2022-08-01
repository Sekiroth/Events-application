FROM swaggerapi/swagger-ui:latest
MAINTAINER ITAcademy

ADD /classifier-service/spec/classifier-service.yaml /usr/share/nginx/html/doc/classifier-service.yaml
ADD /event-service/spec/events-service.yaml /usr/share/nginx/html/doc/events-service.yaml
ADD /user-service/spec/user-service.yaml /usr/share/nginx/html/doc/user-service.yaml


ENV URLS="[{ url: 'doc/classifier-service.yaml', name: 'classifier'},{ url: 'doc/event-service.yaml', name: 'event'},{ url: 'doc/user-service.yaml', name: 'user'}]"
ENV URLS_PRIMARY_NAME="Events"