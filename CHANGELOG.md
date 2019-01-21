# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

N/A

## [0.1.0] 2019-01-21

### [0.1.0] Changed

- `com.example.demospringdatacouchbaseapp.model.Car` entity is no longer immutable due to difficulties with [property population via `wither` methods](https://stackoverflow.com/questions/54196925/property-population-via-wither-methods).
- Moved from property based to Java based configuration for Couchbase. See `com.example.demospringdatacouchbaseapp.repository.CouchbaseConfig`.

### [0.1.0] Added

- Auto creation of indexes and views using `@ViewIndexed`, `@N1qlPrimaryIndexed`, and `@N1qlSecondaryIndexed` annotations. Note: This is only for use with for development/test environemnts, so some way of ensuring its not used in production will need to be devised.

## 0.0.1 2019-01-15

### Added

- Initial baseline containing a couchbase repo and associated test (many failing)

[Unreleased]: https://github.com/LewisWatson/demo-spring-data-couchbase-app/compare/0.1.0...HEAD
[0.1.0]: https://github.com/LewisWatson/demo-spring-data-couchbase-app/compare/0.0.1...0.1.0