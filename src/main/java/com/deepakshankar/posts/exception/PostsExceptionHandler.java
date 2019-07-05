package com.deepakshankar.posts.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Stream.of;

@ControllerAdvice
public class PostsExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = PostsRuntimeException.class)
    public ResponseEntity<RestError> handlePostsRuntimeException(PostsRuntimeException exception, WebRequest request) {
        List<String> errors = new ArrayList<>();
        inflateErrors(exception, errors);
        RestError error = new RestError(HttpStatus.BAD_REQUEST, PostsErrorCode.POSTS_GENERIC_ERROR, exception.getMessage(), errors);
        return new ResponseEntity<>(error, new HttpHeaders(), error.getStatus());
    }

    private void inflateErrors(PostsRuntimeException exception, List<String> errors) {
        of(exception.getCause().getStackTrace())
                .forEach(stackTraceElement -> errors.add(buildError(stackTraceElement)));
    }

    private String buildError(StackTraceElement stackTraceElement) {
        return null;
    }
}
