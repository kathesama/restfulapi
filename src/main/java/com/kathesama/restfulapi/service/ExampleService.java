package com.kathesama.restfulapi.service;

import com.kathesama.restfulapi.model.Example;
import com.kathesama.restfulapi.repository.ExampleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ExampleService {
    @Autowired
    private final ExampleRepository exampleRepository;

    public List<Example> getAllExamples() {
        return exampleRepository.findAll();
    }
}
