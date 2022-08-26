package com.kathesama.restfulapi.service.implementation;

import com.kathesama.restfulapi.dto.TodoDTO;
import com.kathesama.restfulapi.exception.TodoCollectionException;
import com.kathesama.restfulapi.repository.TodoRepository;
import com.kathesama.restfulapi.service.TodoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.*;

@Service
public class TodoServiceImpl implements TodoServiceInterface {
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<TodoDTO> getAllTodos() throws ConstraintViolationException, TodoCollectionException {
        List<TodoDTO> todos = todoRepository.findAll();

        return !todos.isEmpty() ? todos: new ArrayList<>();
    }

    @Override
    public TodoDTO getOneTodo(String id) throws ConstraintViolationException, TodoCollectionException {
        Optional<TodoDTO> todo = todoRepository.findById(id);
        if (todo.isEmpty()){
            throw new TodoCollectionException(TodoCollectionException.NotFound(id));
        }
        return todo.get();
    }

    @Override
    public void createTodo(TodoDTO todo) throws ConstraintViolationException, TodoCollectionException {
        if(todoRepository.findByTodoName(todo.getTodo()).isPresent()){
            throw new TodoCollectionException(TodoCollectionException.TodoAlreadyExists());
        }

        todo.setCreatedAt(new Date(System.currentTimeMillis()));
        todoRepository.save(todo);
    }

    @Override
    public void updateTodo(String id, TodoDTO todo) throws ConstraintViolationException, TodoCollectionException {
        Optional<TodoDTO> todoOptionalById = todoRepository.findById(id);
        if(todoOptionalById.isEmpty()){
            throw new TodoCollectionException(TodoCollectionException.NotFound(id));
        }

        TodoDTO todoToUpdate = todoOptionalById.get();
        todoToUpdate.setTodo(todo.getTodo());
        todoToUpdate.setDescription(todo.getDescription());
        todoToUpdate.setCompleted(todo.getCompleted());
        todoToUpdate.setUpdatedAt(new Date(System.currentTimeMillis()));

        try{
            todoRepository.save(todoToUpdate);
        }catch(DuplicateKeyException ex){
            throw new TodoCollectionException(TodoCollectionException.TodoAlreadyExists());
        }
    }

    /**
     * @param id
     * @throws ConstraintViolationException
     * @throws TodoCollectionException
     */
    @Override
    public void deleteTodo(String id) throws ConstraintViolationException, TodoCollectionException {
        Optional<TodoDTO> todo = todoRepository.findById(id);
        if (todo.isEmpty()){
            throw new TodoCollectionException(TodoCollectionException.NotFound(id));
        }

        todoRepository.deleteById(id);
    }
}
