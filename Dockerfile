FROM anapsix/alpine-java
MAINTAINER jayaram
ADD ./build/distributions/MiniWeb.tar /opt/
WORKDIR /opt/MiniWeb 
ENTRYPOINT ["/opt/MiniWeb/bin/MiniWeb"]
EXPOSE 8081
