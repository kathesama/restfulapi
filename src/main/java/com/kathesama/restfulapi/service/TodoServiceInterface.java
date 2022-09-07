package com.kathesama.restfulapi.service;

import com.kathesama.restfulapi.model.dto.TodoDTO;
import com.kathesama.restfulapi.exception.GenericCollectionException;

import javax.validation.ConstraintViolationException;
import java.util.List;

public interface TodoServiceInterface {
    public List<TodoDTO> getAllTodos() throws ConstraintViolationException, GenericCollectionException;
    public TodoDTO getOneTodo(String id) throws ConstraintViolationException, GenericCollectionException;
    public void createTodo(TodoDTO todo) throws ConstraintViolationException, GenericCollectionException;
    public void updateTodo(String id, TodoDTO todo) throws ConstraintViolationException, GenericCollectionException;
    public void deleteTodo(String id) throws ConstraintViolationException, GenericCollectionException;
}
