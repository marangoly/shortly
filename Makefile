#####################################
# Make file for Shortly Application #
#####################################


DOCKER_MACHINE := default

.PHONY: all clean build test install package deploy

clean:
	mvn clean

build:
	mvn clean build
	
test:
	mvn clean test
	
install:
	mvn clean install
	
package:
	mvn clean package
	
all:
	mvn clean package
	sudo docker-compose up
	
deploy:
	sudo docker-compose up

help:
	@ echo "Usage   :  make <target>"
	@ echo "Targets :"
	@ echo "   clean ......... Removes build products"	
	@ echo "   build ....... Builds all Java files"	
	@ echo "   test .......... Builds and runs all unit tests"
	@ echo "   install .......... Builds and installs to local repository"	
	@ echo "   package .......... Generates project package."
	@ echo "   deploy .......... Deploys the application in local docker container."
	@ echo "   all .......... Generates project package and deploys it in local docker container."
	@ echo "   help .......... Prints this help message"
	