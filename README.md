# ACME

[![Build Status](https://github.com/alonyb/ioet/workflows/ioet/ACME/badge.svg)](https://github.com/rdbaez/ioet/actions)
[![Latest Release](https://img.shields.io/github/v/release/alonyb/ioet?include_prereleases)](https://github.com/alonyb/ioet/releases/latest)


# About
This project is in Java using maven as software project management that calculates salary of employees, using hexagonal architecture, Mockito to unittests, Docker as container system and Dockerhub as image repository, GitHub as code/artifact repository and GitHub actions to CI, finally sonar cloud as code analyzer.

# Architecture
This proyect was based on hexagonal architecture.

![hexagonal](https://user-images.githubusercontent.com/13793894/97639761-391c8700-1a0d-11eb-9194-933b805290bc.png)

If you want to see more examples check:
* [Golang](https://github.com/alonyb/url_shortener) - Project based on hexagonal arch and using Golang.
* [Docs](https://alistair.cockburn.us/hexagonal-architecture/) - Good reference docs about this arch.

# Dockerhub
This proyect use the amazing Dockerhub to manage docker images.
You can check it [here](https://hub.docker.com/repository/docker/rubendario/ioet)

<img width="764" alt="dockerhub" src="https://user-images.githubusercontent.com/13793894/97639862-6d904300-1a0d-11eb-8cbd-f3c8f4ea2c1a.png">

# GitHub
* ### Actions
  * Project uses actions to CI, such is composed by four steps(can check it [here](https://github.com/alonyb/ioet/actions)):
    * Unittests
    * Package project
    * Sonar analyzer
    * Deploy to Dockerhub
* ### Artifact
  * You can check artifact [here](https://github.com/alonyb/ioet/packages/)

# Run
This is my favorite part, to run it, you should to have docker on your machine, if you don't well.. kill your self! :)
```bash
docker pull rubendario/ioet:latest
docker run <id-image>
```

### Example
![Screen Shot 2020-10-30 at 09 17 35](https://user-images.githubusercontent.com/13793894/97715747-c0f7a500-1a90-11eb-9db2-306635d5d382.png)


# Cloning project to run locally
The following will give you a project that is set up and ready to use.

```bash
git clone https://github.com/alonyb/ioet.git
cd ioet
```

Download maven dependencies
```bash
mvn clean install
```

Run unittests
```bash
mvn tests
```

Run project
```bash
mvn exec:java -Dexec.mainClass="com.ioet.acme.AcmeApplication"
```
