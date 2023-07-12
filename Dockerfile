FROM ubuntu:latest
LABEL authors="welli"

ENTRYPOINT ["top", "-b"]
