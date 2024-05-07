FROM docker.elastic.co/logstash/logstash:8.9.0

# delete default configuration
RUN rm -f /usr/share/logstash/pipeline/logstash.conf

# copy configurations
COPY ./config/logstash/pipeline /usr/share/logstash/pipeline/
COPY ./config/logstash/config /usr/share/logstash/config/
COPY ./logs /logs