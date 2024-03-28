package org.example.designmovieticketbookingtool.exception;

public class EntityNotPresentException extends RuntimeException{
    public EntityNotPresentException(String message){
        super(message);
    }
}
