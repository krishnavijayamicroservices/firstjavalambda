package com.awsdev;

public class CustomLambdaException extends RuntimeException {
    
    public CustomLambdaException(String msg, Throwable error) {
        super(msg, error);
    }
}
