# Spring/Java backend with Node/React frontend

This project uses the API described here https://www.trafiklab.se/api/sl-hallplatser-och-linjer-2.
to show a list of the buses with the most bus stops.

## Prerequisites
No need for maven since a wrapper is included
* Node.js 19.9.x
* Java 17


## Installing
To install the project, follow these steps:

1. Clone the com.sl.buslines.repository to your local machine.
2. Navigate to the backend module of the project and run mvn clean install -DskipTests to build the backend.
3. Have docker installed and set containers to be linux

## Running
Stand in workspace root and run 'docker-compose up --build'

### Usage
No input needed, the request should kick off and present the list of buses when navigating to http://localhost:3003/