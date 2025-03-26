package com.gisma.asc.exception;

public class ErrorDetails {

    private String errorCode;
    private String description;
    private String path;

    public ErrorDetails(String errorCode, String description, String path) {
        this.errorCode = errorCode;
        this.description = description;
        this.path = path;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

