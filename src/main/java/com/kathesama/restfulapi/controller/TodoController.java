package com.kathesama.restfulapi.controller;

import com.kathesama.restfulapi.model.dto.TodoDTO;
import com.kathesama.restfulapi.exception.GenericCollectionException;
import com.kathesama.restfulapi.repository.TodoRepository;
import com.kathesama.restfulapi.service.implementation.TodoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("${jms.configuration.base-url}/todos")
public class TodoController {
    public static final Logger logger = LoggerFactory.getLogger(TodoController.class);
    @Autowired
    TodoServiceImpl todoServiceImpl;

    @Autowired
    private TodoRepository todoRepository;

    // TODO: change single output to array output at documentation
    @Operation(summary = "list all todos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the todos",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TodoDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "not found",
                    content = @Content) })
    @GetMapping
    public ResponseEntity<?> getAllTodos() {
//        var auth = SecurityContextHolder.getContext().getAuthentication();
//        logger.info("Datos del usuario: {}", auth.getPrincipal());
//        logger.info("Datos de los permisos: {}", auth.getAuthorities());
//        logger.info("Autenticado?: {}", auth.isAuthenticated());
//
//        logger.info("Datos del usuario: {}", auth.getPrincipal());
        try{
            List<TodoDTO> todos = todoServiceImpl.getAllTodos();
            return new ResponseEntity<>(todos, !todos.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
        }catch(GenericCollectionException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "return one todo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found one todo",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TodoDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Todo not found",
                    content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<?> getOneTodo(@PathVariable("id") String id){
        try{
            return new ResponseEntity<>(todoServiceImpl.getOneTodo(id), HttpStatus.OK);
        }catch(GenericCollectionException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Insert one todo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TodoDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid data supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content) })
    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoDTO todo){
        try{
            todoServiceImpl.createTodo(todo);
            return new ResponseEntity<TodoDTO>(todo, HttpStatus.OK);
        }catch (ConstraintViolationException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }catch (GenericCollectionException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @Operation(summary = "Update one todo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TodoDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content),
            @ApiResponse(responseCode = "422", description = "Unprocesable entity",
                    content = @Content) })
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable("id") String id, @RequestBody TodoDTO todo){
        try {
            todoServiceImpl.updateTodo(id, todo);
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        }catch (ConstraintViolationException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }catch (GenericCollectionException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }catch (DuplicateKeyException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Delete one todo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TodoDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid data supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content) })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable("id") String id){
        try{
            todoServiceImpl.deleteTodo(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }catch(GenericCollectionException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
