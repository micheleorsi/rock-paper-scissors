# Rock paper scissors [![Build Status](https://travis-ci.org/micheleorsi/rock-paper-scissors.svg?branch=master)](https://travis-ci.org/micheleorsi/rock-paper-scissors)

## Usage

You can build and run with maven with the following commands:

```bash
mvn clean package exec:java -DskipTests=true
```

## Test

Launch all the tests:

```bash
mvn clean verify 
```

## Coverage and code analysis

You should install and launch sonarqube. ([Here](https://docs.sonarqube.org/display/SONAR/Get+Started+in+Two+Minutes) is the guide to install it and run it)

After that then you can connect to your installation. (The default one is [here](http://localhost:9000/))

If everything works you can now launch:

```bash
mvn -Ptest-coverage clean verify sonar:sonar  
```
