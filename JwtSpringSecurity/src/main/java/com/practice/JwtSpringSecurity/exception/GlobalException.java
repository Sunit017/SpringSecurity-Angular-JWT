package com.practice.JwtSpringSecurity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

@ExceptionHandler(BadCredentialsException.class)
public ResponseEntity<Object> handleBadCredentialException(BadCredentialsException ex)
{
   ErrorMessage errorMessage=new ErrorMessage(ex.getMessage(), HttpStatus.UNAUTHORIZED);
   return new ResponseEntity<>(errorMessage,HttpStatus.UNAUTHORIZED);
}

}
