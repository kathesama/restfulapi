package com.kathesama.restfulapi.repository;

import com.kathesama.restfulapi.dto.TodoDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends MongoRepository<TodoDTO, String> {

    @Query("{'todo': ?0}")
    Optional<TodoDTO> findByTodoName(String todo);

    @Query(value="{'id': ?0}", fields="{'id' :  1, 'todo':  1}")
    Optional<TodoDTO> findByIdAndTodo(String id, String todo);
}
