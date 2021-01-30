## Initial Plan

### TODO
- Add logger interface of SL4J
- Add docker-compose file for Postgres with defined username, password and database
- Have toi implement API management tool like Swagger
- Add docker build and deploy commands in github action CI/CD pipeline to deploy the latest build image of the project in the Github package repository.
- Configure the response error with logger instead of throwing an exception 
- Spike on DB migration on Spring framework and add initial insert query for admin role

### Database for the eBooks library
- Use the [resources provided from here](https://corgis-edu.github.io/corgis/csv/classics/) 
- [Official site info](https://www.gutenberg.org/about/)
