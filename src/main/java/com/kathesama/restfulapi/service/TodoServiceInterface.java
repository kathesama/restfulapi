package com.kathesama.restfulapi.service;

import com.kathesama.restfulapi.dto.TodoDTO;
import com.kathesama.restfulapi.exception.TodoCollectionException;

import javax.validation.ConstraintViolationException;
import java.util.List;

public interface TodoServiceInterface {
    public List<TodoDTO> getAllTodos() throws ConstraintViolationException, TodoCollectionException;
    public TodoDTO getOneTodo(String id) throws ConstraintViolationException, TodoCollectionException;
    public void createTodo(TodoDTO todo) throws ConstraintViolationException, TodoCollectionException;
    public void updateTodo(String id, TodoDTO todo) throws ConstraintViolationException, TodoCollectionException;
    public void deleteTodo(String id) throws ConstraintViolationException, TodoCollectionException;
}
