package com.gisma.asc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class ClientError extends RuntimeException {

        private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        private ErrorCode errorCode;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public ClientError(ErrorCode errorCode) {
            super(errorCode.getDescription());
            this.errorCode = errorCode;
        }

        public ClientError(ErrorCode errorCode, String message) {
            super(errorCode.getDescription().concat(Objects.nonNull(message) ? message : ""));
            this.errorCode = errorCode;
        }

        public ClientError(ErrorCode errorCode, String code, String description) {
            super(errorCode.getDescription().replace("{{code}}", code).replace("{{description}}", description));
            this.errorCode = errorCode;
        }
}
