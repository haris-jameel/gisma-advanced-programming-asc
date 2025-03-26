package com.gisma.asc.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

        private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

        @ExceptionHandler(ClientError.class)
        public ResponseEntity<ErrorDetails> handleNotFoundException(ClientError clientError, WebRequest webRequest) {
            log.debug("FATAL_ERROR: [{}]", clientError);
            String errorCode = clientError.getErrorCode() == null ? "" : clientError.getErrorCode().getErrorCode();
            log.error("FATAL_CLIENT_ERROR: [{} , {}]", errorCode, clientError.getMessage());
            clientError.printStackTrace();
            ErrorDetails errorDetails = new ErrorDetails(errorCode, clientError.getMessage(), webRequest.getDescription(false));

            return new ResponseEntity(errorDetails, clientError.getHttpStatus());
        }

    }
