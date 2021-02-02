## Basic Demo project using Java and Spring boot framework

### Dependencies used so far
- [Spring boot Web starter](https://spring.io/guides/gs/spring-boot/)
- [Spring boot JPA](https://spring.io/guides/gs/accessing-data-jpa/)
- [Spring boot Mail](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mail.html)
- [Spring boot Security](https://spring.io/guides/gs/securing-web/)
- Postgres Database Driver
- [Lombok](https://projectlombok.org/)
- [Spring Doc OpenApi](https://springdoc.org/)

### Resources 
- Initial Spring structure form [tutorial](https://www.youtube.com/watch?v=QwQuro7ekvc).

### Future plan
- Start adding classes, services and repository for the e-Book library project using data from: https://corgis-edu.github.io/corgis/csv/classics/
- Start adding logs and fix the error handling in http response, [more help](https://www.baeldung.com/rest-api-error-handling-best-practices).
- Think about creating a web-app as a front-end tool for the project, probabily using Javascript framework of https://svelte.dev/.

### Use of docker-compose
This project depends on the two services that can be deployed using the docker container:
1. `image: postgres:latest`
2. `image: maildev/maildev`

Postgres container has a volume mounted to the local machine's directory, which can be varied depending on the OS on which the docker container is running. All the environment variables that are used in the `docker-compose` yml files are stored in the `.env` file that should be git ignored in the production. At the moment, postgres database get emptied every time when the project is loaded or restarted. This has to be configured in the application file under the resources.

**Future Plan**: Write the `DockerFile` that should generate the docker image of this Java Spring project and push the image to the Github package image repository using the [github action](https://docs.github.com/en/actions/guides/publishing-docker-images).

### How to run
1. Download the required docker images and run them using the command: `docker-compose up`
2. Go to the file: `OnlineLibraryApiApplication.java` and run 
3. Can also be done using maven or gradle plugins