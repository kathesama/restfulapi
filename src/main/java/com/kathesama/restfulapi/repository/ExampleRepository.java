package com.kathesama.restfulapi.repository;

import com.kathesama.restfulapi.model.Example;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExampleRepository extends MongoRepository<Example, String> {
}
