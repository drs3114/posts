package com.deepakshankar.posts.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

public class RestError {
    private HttpStatus status;
    private PostsErrorCode errorCode;
    private String message;
    private List<String> errors;

    public RestError(HttpStatus status, PostsErrorCode errorCode, String message) {
        this(status, errorCode, message, null);
    }

    public RestError(HttpStatus status, PostsErrorCode errorCode, String message, List<String> errors) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
        this.errors = errors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public PostsErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(PostsErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
