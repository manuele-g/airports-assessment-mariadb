# Airports Assessment Project

*Simple Spring Boot app with a MariaDB*

## Table of contents
* [General info](#general-info)
* [Prerequisites](#prerequisites)
* [Setup](#setup)

##General info
**Description**

The assessment comes with 3 CSV files. The files contain data for countries, airports and runways.
Write a program that retrieves the following information given the provided files:
* Runways for each airport given a country code or country name.
* Top 10 countries with highest number of airports.

**Requirements**

Bonus: Support retrieving the information given a partial/fuzzy country code/name as input parameter, e.g. entering 'zimb' will result in 'Zimbabwe'.

* The program should be written in Java.
* Write production-ready code.
* Document how to run the application.
* Publish the source code into GitHub (using your own personal account) and share it with us.


## Prerequisites

* Java 17
* Apache Maven (3.8.6)
* Docker
* MariaDB

## Setup
* [To install and run MariaDB with Docker](#to-install-and-run-mariadb-with-docker).
* [Prerequisites](#prerequisites)
* [Setup](#setup)

### To install and run MariaDB with Docker

[Source: MariaDB docker hub](https://hub.docker.com/_/mariadb/?target=_blank)

To Pull the **mariadb** image:

	docker pull mariadb


To check that the image has been downloaded:

	docker images

Starting a MariaDB instance with the latest version is simple after setting \*user\*, \*password\* and \*password_root\*:

	docker run --detach -p 3306:3306 --name mariadb-demo --env MARIADB_USER=[user] --env MARIADB_PASSWORD=[passowrd] --env MARIADB_ROOT_PASSWORD=[password_root]  mariadb:latest


To check that the container is running:

	docker ps


To stop the container:

	docker stop mariadb-demo

To start again the container:

	docker start mariadb-demo

To create the user, go to src/main/resources and launch setup.sql after setting *user* and *password*

**How to Build the project with Maven**

	mvn clean install -Pdev,flywaydb

Exist the following Maven profiles:

* **local**: local environment: <code>mvn clean install -Plocal
* **dev**: development environment, e.g. Docker: <code>mvn clean install -Pdev
* **flywaydb**: to version the database
* **flywaydb-clean**: to clean the database and to version the database


Exists the **apt-maven-plugin** that makes sure that the Q-types are generated during the process goal of Maven build. The outputDirectory configuration property points to the directory where the Q-type source files will be generated. The value of this property is target/generated-sources/java.

You should also add this directory to the source folders of the project, if your IDE does not do this automatically — consult the documentation for your favorite IDE on how to do that.

<h3>How to start the Spring Boot application with Docker</h3>
<p>Go to the folder (project root) where the dockerfile is located:</p>
<code>cd <base_project_path>/airports-assmnt-mariadb</code>
<p>Create an volume to export data to json</p>
<code>docker volume create assmnt-volume</code>
<p>Create an image from the Dockerfile</p>
<code>docker build -t mg/airports-assmnt-mariadb-api .</code>
<p>Run the container from the image:</p>
<code>docker run -d -p 8080:8080 --mount source=assmnt-volume,target=/export/json --name airports-assmnt-mariadb-api mg/airports-assmnt-mariadb-api:latest</code>
<p>To explore the volume</p>
<code>docker run -it --rm -v assmnt-volume:/export/json busybox ls -l /export/json</code>

<h3>How to access Swagger UI to visualize and interact with the API’s resources:</h3>
<code>http://localhost:8080/assessment/swagger-ui/index.html</code>

<h2>API Documentation</h2>


<h3>2. To retrieve the top x countries  with the highest number of airports</h3>
<code>GET /assessment/airport/statistics/top/{limit}/countries</code>
<p>Path Parameters:
<li>limit (required): represents the max number of airport runways that are retrieved, e.g. if you want ten countries, set {limit} to 10</li>
</p>

<h3>3. To retrieve the runways for each airport given a country code or country name. It also works with partial/fuzzy code or name</h3>
<code>POST /assessment/aiport/statistics/given/country</code>
<p>JSON body parameters:
<li><b>code</b> (optional): represents the country code whose airport runways you would like to retrieve.</li>
<li><b>name</b> (optional): represents the country name whose airport runways you would like to retrieve.</li>
<li><b>page</b> (required): represents the page that is retrieved</li>
<li><b>size</b> (required): represents the max number of airport runways that are retrieved</li>
<li><b>sortBy</b> (required): represents the property to order for, e.g. id</li>
<li><b>sortOrder</b> (required): represents the sort directions (asc/desc). Default: asc</li>
</p>

<h3>1.To Export the airports to json</h3>
<code>GET /assessment/export/airport/json</code>
<p>Returns true if this operation is successful</p>

<h3>1.To Export the countries to json</h3>
<code>GET /assessment/export/countries/json</code>
<p>Returns true if this operation is successful</p>

<h2>Postman Collection</h2>

<p>The postman collection is in the project root</p>
<code>File: developer-assessment-mariadb.postman_collection.son</code>

