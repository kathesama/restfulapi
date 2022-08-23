package com.kathesama.restfulapi.controller;

import com.kathesama.restfulapi.model.Example;
import com.kathesama.restfulapi.service.ExampleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${jms.configuration.base-url}")
@AllArgsConstructor
public class ExampleController {
    private final ExampleService exampleService;

    @GetMapping("examples")
    public List<Example> fetchAllExamples() {
        return exampleService.getAllExamples();

    }
}
