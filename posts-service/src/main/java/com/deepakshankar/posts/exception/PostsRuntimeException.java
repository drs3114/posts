package com.deepakshankar.posts.exception;

public class PostsRuntimeException extends RuntimeException {
    public PostsRuntimeException() {
    }

    public PostsRuntimeException(String message) {
        super(message);
    }

    public PostsRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public PostsRuntimeException(Throwable cause) {
        super(cause);
    }

    public PostsRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
