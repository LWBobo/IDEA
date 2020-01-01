package com.lwb.pojo;

public class ClassRepeatException extends Exception {
    private String message;

    public ClassRepeatException(){
        super();
    }
    public  ClassRepeatException(String message){
        super(message);
        this.message = message;
    }
}
