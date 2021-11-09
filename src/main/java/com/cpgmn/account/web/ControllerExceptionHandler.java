package com.cpgmn.account.web;

import com.cpgmn.account.common.ClientException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ClientException.class)
    protected ResponseEntity<String> handleClientException(ClientException ex) {
        return ResponseEntity.badRequest().body(ex.getLocalizedMessage());
    }

    @ExceptionHandler(SQLException.class)
    protected ResponseEntity<String> handleSQLException(SQLException ex) {
        return ResponseEntity.badRequest().body(ex.getLocalizedMessage());
    }
}