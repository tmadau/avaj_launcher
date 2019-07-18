package com.avaj_launcher.exceptions;

@SuppressWarnings("serial")
public class CustomFileErrorException extends Exception {
    
    public CustomFileErrorException(String errorMessage) {
        super(errorMessage);
    }
}
