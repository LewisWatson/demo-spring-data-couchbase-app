package com.example.demospringdatacouchbaseapp.repository;

import java.util.Collection;
import com.example.demospringdatacouchbaseapp.model.Car;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.N1qlSecondaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

@ViewIndexed(designDoc="car")
@N1qlPrimaryIndexed
@N1qlSecondaryIndexed(indexName="colour")
public interface CarRepository extends CouchbaseRepository<Car, String> {
  
  Collection<Car> findByColour(String colour);

}
