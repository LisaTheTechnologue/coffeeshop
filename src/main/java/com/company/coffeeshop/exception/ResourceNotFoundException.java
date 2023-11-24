package com.company.coffeeshop.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String object, String attribute, String value) {
        super(object + " not found with " + attribute + " of " + value);
    }
}
