package com.api.exception;


public class RoomNotEmptyException extends RuntimeException{
    public RoomNotEmptyException(String message){
        super(message);
    }
}
