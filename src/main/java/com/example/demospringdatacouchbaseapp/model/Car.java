package com.example.demospringdatacouchbaseapp.model;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.USE_ATTRIBUTES;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.IdAttribute;
import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.experimental.Wither;

@Data
@AllArgsConstructor
@Builder(toBuilder=true)
@Document
public class Car {

  public static final String ID_DELIMITER = "::";

  @Id
  @GeneratedValue(strategy = USE_ATTRIBUTES, delimiter = ID_DELIMITER)
  @Wither
  private String id;

  @Field
  @IdAttribute(order=0)
  private String manufacturer;

  @Field
  @IdAttribute(order=1)
  private String model;

  @Field
  @IdAttribute(order=2)
  private String spec;

  @Field
  private String colour;

}
