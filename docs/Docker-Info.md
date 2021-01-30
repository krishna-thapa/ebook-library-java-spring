## Use of Docker image for Postgres

### Using Docker-Compose has these benefits:
- it can be faster, repeatable, and automatic
- it saves you from installing the database directly on your host machine
- it allows you to have multiple different versions of the database, in case each of your projects require you to use different versions

### Useful Docker-commands:
1. Run the docker compose command to tun the containers: 
```docker-compose up```
2. Connect to the postgres through terminal
```psql -h localhost -p 5430 -U admin postgres```
3. Password for admin role is `admin`
4. Connect to the right database
```\c registration```
5. See all the tables and sequences in Postgres database
```\d```
6. See the table description
```\d <tablename>```

### Port Mapping
- Have used different host port(`5430`) instead of using the same port that docker container is run so that it won't conflict for another project that is running the Postgres container. 

### Environment variables
- All the required environment variables are declared under `.env` file that can be added in the `.gitignore` for the production.

### Faced issues:
1. `Database directory appears to contain a database; Skipping initialization`: Have to delete all the local mounted volumes directory and re-run the docker-compose command. That would be `pgdata` directory under the root project folder for macOS and `var/` would be for Linux. 

### Resources:
1. [Docker compose for postgresql with db init script](https://gist.github.com/onjin/2dd3cc52ef79069de1faa2dfd456c945)
2. [Getting Started with PostgreSQL using Docker-Compose](https://medium.com/analytics-vidhya/getting-started-with-postgresql-using-docker-compose-34d6b808c47c)
