#!/bin/sh
docker build . -t os-hibernate
echo
echo
echo "To run the docker container execute:"
echo "    $ docker run -p 8085:8085 --name os-app --network bridge os-hibernate"
