package com.adoption.kittenlove.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Cat not found")
public class CatNotFoundException extends RuntimeException{
}
