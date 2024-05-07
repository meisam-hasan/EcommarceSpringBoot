# Sample Ecommerce App using Spring boot


## Running the Application

To run the application using Docker, 
run this command from the root directory:

```
docker-compose --env-file=env.list up
```

# Application base url
 
The application base url is:

```
http://localhost:8085/
```
     
## Log visualization Endpoint

The application log visualization using elk:

```
http://localhost:5601/
```
    

## Metrics Endpoint

The application exposes metrics using Graphite. You can access the metrics endpoint at:

```
http://localhost:85/
```

# Swagger UI

You can access the swagger endpoint at:

```
http://localhost:8080/api-ui.html
```