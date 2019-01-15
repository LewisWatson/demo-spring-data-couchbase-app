# Demo Spring Data Couchbase App

Example Spring Boot app which integrates with a [Couchbase NoSQL Database][Couchbase] using [Spring Data Couchbase].

## Setup

Follow the instructions on [dockerhub.com/couchbase](https://hub.docker.com/_/couchbase) to stand up a couchbase server

### Setup Step 1

```bash
docker run -d --name db -p 8091-8094:8091-8094 -p 11210:11210 couchbase:6.0.0
```

### Setup Step 2

Next, visit http://localhost:8091 on the host machine to see the Web Console to start Couchbase Server setup.

Walk through the Setup wizard and accept the default values. You may need to disable analytics if the defaults won't run in your environent.

### Setup Step 3

Add a `cars` bucket with default settings.

### Setup Step 4

Security -> Add User

Create a new user called `cars` with `Full Admin` permissions.

TODO: reduce permissions

### Setup Step 5

Go to `Query` and run the following

```
CREATE PRIMARY INDEX `cars_primary` ON `cars`
```

## Run CRUD Tests

```bash
gradlew test -Dspring.couchbase.bucket.password=<cars user password>
```

[Couchbase]: https://www.couchbase.com/
[Spring Data Couchbase]: https://spring.io/projects/spring-data-couchbase