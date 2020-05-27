package com.qa.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "This showTime does not exist")
public class ShowTimeNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = -2591687720244290021L;

}