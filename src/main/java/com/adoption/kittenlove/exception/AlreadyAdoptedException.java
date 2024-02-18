package com.adoption.kittenlove.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        code = HttpStatus.FORBIDDEN,
        reason = "This kitten has already been adopted. Feel free to adopt another one.")
public class AlreadyAdoptedException extends RuntimeException {
}
