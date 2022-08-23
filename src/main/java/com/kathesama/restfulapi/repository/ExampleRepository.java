package com.kathesama.restfulapi.repository;

import com.kathesama.restfulapi.model.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ExampleRepository extends MongoRepository<Example, String> {
    Optional<Example> findByName(String name);

//    @Query("")
//    void test();
}
