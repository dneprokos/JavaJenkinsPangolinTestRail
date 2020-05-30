FROM alpine
USER root
RUN apk --no-cache add openjdk8
ENV PATH $PATH:/usr/lib/jvm/java-1.8-openjdk/bin
ENV PANGOLIN_REPOSITORY=https://agiletestware-pangolin.s3-us-west-2.amazonaws.com/3.1
ENV PANGOLIN_ARCHIVE_NAME=pangolin-unix-3.1-readlink-fix.tar.gz
RUN wget ${PANGOLIN_REPOSITORY}/${PANGOLIN_ARCHIVE_NAME} &&\
tar -xzf ${PANGOLIN_ARCHIVE_NAME} &&\
rm ${PANGOLIN_ARCHIVE_NAME}
RUN apk --no-cache add sudo && apk add --no-cache --upgrade bash
WORKDIR /pangolin
COPY . .
#Next first line is workaround fixes one of the 'startup.sh' command problems
RUN echo "Set disable_coredump false" >> /etc/sudo.conf &&\
chmod +x startup.sh &&\
chmod +x runapp.sh
CMD ./runapp.sh
