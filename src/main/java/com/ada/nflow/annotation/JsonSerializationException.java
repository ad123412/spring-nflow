package com.ada.nflow.annotation;

public class JsonSerializationException extends Exception {
    public JsonSerializationException(String message) {
        super(message);
    }

    public JsonSerializationException(String message, Throwable cause) {
        super(message, cause);
    }
}
