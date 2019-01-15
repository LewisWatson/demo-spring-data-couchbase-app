package com.example.demospringdatacouchbaseapp.repository;

import java.util.Collection;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import com.example.demospringdatacouchbaseapp.model.Car;

public interface CarRepository extends CouchbaseRepository<Car, String> {
  
  Collection<Car> findByColour(String colour);

}
