package com.example.demospringdatacouchbaseapp.repository;

import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.support.IndexManager;

@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {
    
    @Override
    protected List<String> getBootstrapHosts() {
        return Collections.singletonList("127.0.0.1");
    }

    @Override
    protected String getBucketName() {
        return "cars";
    }

    @Override
    protected String getBucketPassword() {
        return "password";
    }

  //this is for dev so it is ok to auto-create indexes
  @Override
  public IndexManager indexManager() {
    return new IndexManager(true, false, false);
  }
}


