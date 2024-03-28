package org.example.designmovieticketbookingtool.exception;

public class SeatsUnavailableException extends RuntimeException{
    public SeatsUnavailableException(String message){
        super(message);
    }
}
