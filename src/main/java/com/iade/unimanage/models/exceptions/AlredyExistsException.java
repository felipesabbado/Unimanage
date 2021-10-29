package com.iade.unimanage.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class AlredyExistsException extends RuntimeException {
    public AlredyExistsException(String id, String elemType, String idName) {
        super(elemType + " with " + idName + " " + id + " is alredy enrolled.");
    }
}
