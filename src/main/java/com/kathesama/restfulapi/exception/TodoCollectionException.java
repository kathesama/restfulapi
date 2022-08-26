package com.kathesama.restfulapi.exception;

public class TodoCollectionException extends Exception{
    public static final long serialVersionUID = 1L;

    public TodoCollectionException(String message){
        super(message);
    }

    public static String NotFound(String id){
        return "Todo with " + id + " not found";
    }

    public static String TodoAlreadyExists(){
        return "Todo with given name already exists in database";
    }
}
