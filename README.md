



# Heroes
This is the repository for the modul "Java Open Source" experimental OSS frameworks.
This sample project Heroes should demonstrate the use of different open source frameworks. 
<p align="left">
    <a href="https://opensource.org/licenses/MIT"><img src="https://img.shields.io/badge/license-MIT-blue.svg"></a>
</p>

Used Frameworks: 
```
Spring Core                            
Spring Data                         
Spring Boot
Spring MVC
Spring RESTful Services for Hero and Party 
Microservices for Camp, Arena and Promoter 
Spring Cloud (Eureka Registry, Hystrix Fallback and Zuul)
Docker Container
```

## Inhalt

  * [Audience](#audience) 
  * [Requirements](#requirements)
  * [Installation](#installation)
  * [Running](#running)
  * [Status](#status)
  * [Problems](#problems)

##	Audience
This project is primarily aimed at software architects, lead developers, software developers and other people involved in the development process. Since this is a technical artifact, knowledge of software development is required.

## Purpose of the Application
The aim of the paradigm is to provide a comprehensive overview of the development of a microservices, highlighting different aspects using different architectural views.

## Requirements
The solution of the application must be realized according to microservice architecture style. This approach maps all interactions in the system and with the database via the REST interface.

## Extensions
We started with the spring cloud application provided by our professor Villars Roger. We extended the application with the following points: 

	 - Heroes have items (swords and shields) to complement the stats (atk/def)
	 - Battleservice is extended with the posibility of critical and missing hits

# Installation
Start the following microservices. Please start the services in the following order:

 - Registry (localhost:1111)
 - Camp (localhost:2222)
 - Arena (localhost:3333)
 - Promoter (localhost:4444)
 - Frontend (localhost:8080).

You can also start all microservices with docker. Please run docker-compose. This feature is not running in stable mode. Sometimes it occurs the error: "error: Could not find or load main class docker run ". Refer to "Status" in this Readme.

# Running 
When you have succesfully started the 5 microservices you should now see on the localhost:1111 the registry (Eureka) with all the services registered (camp, application, promoter, frontend). 
You can now start a fight with entering the following URL:

**localhost:4444/promoteFight**

Or you can now access all the routes via the Zuul API Gateway via the frontend. For example start a fight: 

**localhost:8080/promoter/promoteFight**

# Overview
  
The project is designed as a Maven multi-module project with Corporate POM in the form of "Hierarchical Project Layout". This hierarchical variant is optimal for Maven, but a bit awkward to use with Eclipse. The organization Software + manages several projects (or multi-module projects), therefore common settings of the projects are managed centrally, namely in a [Corporate POM](https://blog.sonatype.com/2008/05/misused-maven-terms-defined/) (or Master POM). 

The structure of the most important project artifacts looks as follows:

```
Workspace
 '- tour-of-heroes-parent (Git-Repository)
     |- pom.xml (Parent-POM)
     '- tour-of-heroes
     |   |- pom.xml (Modul-POM)
     |   '- src ...
     |- configuration
         '- settings.xml (Settings for Maven)
```

The module project has the following properties:

| Eigenschaft| Beschreibung | Wert |
|-----------|-----------| -----------|
| GroupId  | Arranges the project in the organization. | ch.bfh.diekloppers|
| ArtifactId | Short name of the project | heroes |
| Version | Specifies the current version of the project.| 1.0-SNAPSHOT |
| Packaging | Specifies the packaging of the project. This can be jar, was, ejb, etc.| jar |
| Name | Full name of the project.| Heroes |

# Status
The project is running good with the eureka registry. We have sometimes problem to docker-compose the project. There is sometimes the Error: Cannot find main class. We lost a lot of time to search for an answer for this problem, but we didnt succeed. Currently the docker-compose works not stabel enough. If you have the same problem by installing this project, and you know the answer please contact us! 

# Problems
We had several promels during the project. The biggest problems are listed here, maybe it will help you for your project ;)

 - Dependencies: We had a lot of problems with the dependencies in the beggining. The problem is that you need to write the exact dependency in your pom. In Intellij we had the problem that the spring framework wasnt detected after the project was created. We had to use the "Spring Initializer". This is a very usefull tool to create a new spring application!
 - Registry: The registry service with eureka does register himself in the registry if the following line is not provided in the application properties: 
 - Docker: We had a few problems with building the artifacts in Intellij. There was a problem in the project configuration. When you add a file to the artifacts in Project Settings/Artifacts and then add JAR From Modules with dependencies, then you have to add the MainClass. You can search by typing the main class. Further we had to problem to build the docker-compose file. Always make sure that you are in the right configuration mode on docker (Windows or Linux Containers!).
 ```
 eureka.client.register-with-eureka=false  
eureka.client.fetch-registry=false
 ```

So the Addition of the items first was thought as implementing another microservice shop, which sells the items.

Time issues led to implementing the items directly in the camp service.

New entities (model, controller, service etc.), were implemented for the items. We struggled then with attaching those items to the hero.

For showcasing purpose another random int was added to the stat directly in the hero creation.

The items are still being created but never used.

The Battleservice extension with missing and critical hits was fairly straight forward. Next step would be adding those affixes to the items and eventually heroes.

Final Note: The module was super interesting and I'm confident to explore the spring framework even more in the future on my own.