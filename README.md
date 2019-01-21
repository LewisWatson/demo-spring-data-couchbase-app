# Demo Spring Data Couchbase App

Example Spring Boot app which integrates with a [Couchbase NoSQL Database][Couchbase] using [Spring Data Couchbase].

## Integration Tests

### Run Integration Tests

A couchbase test server configured according to is required in order to run the integration tests. Instructions to set up such a server are provided in [Docker Couchbase Test Server](#DockerCouchbaseTestServer).

```bash
$ ./gradlew integrationTest
```

### Docker Couchbase Test Server

1. spin up container
    ```bash
    docker run -d --name db -p 8091-8094:8091-8094 -p 11210:11210 couchbase:6.0.0
    ```
1. Visit http://localhost:8091 on the host machine to see the Web Console
1. Walk through the Setup wizard and accept the default values.
   - You may need to disable analytics if the defaults won't run in your environment.
1. Add a `cars` bucket with default settings.
1. Navigate to `Security -> Add User` to create a new user called `cars`, with password `password`, and `Application Access` permissions on `cars` bucket.
1. Create index

    Go to `Query` and run the following. This isn't strictly necessary due to our use of `org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed`

    ```sql
    CREATE PRIMARY INDEX ON cars USING GSI;
    ```


For further information on the couchbase container, see [dockerhub.com/couchbase](https://hub.docker.com/_/couchbase).

[Couchbase]: https://www.couchbase.com/
[Spring Data Couchbase]: https://spring.io/projects/spring-data-couchbase