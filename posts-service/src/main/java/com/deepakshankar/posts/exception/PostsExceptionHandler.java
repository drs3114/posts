/*
 * Copyright (c) 2019. Deepak Ravi Shankar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
        return getRestErrorResponseEntity(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EntityNotFound.class)
    public ResponseEntity<RestError> handleEntityNotFound(EntityNotFound exception, WebRequest request) {
        return getRestErrorResponseEntity(exception, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<RestError> getRestErrorResponseEntity(RuntimeException exception, HttpStatus status) {
        List<String> errors = new ArrayList<>();
        inflateErrors(exception, errors);
        RestError error = new RestError(status, PostsErrorCode.POSTS_GENERIC_ERROR, exception.getMessage(), errors);
        return new ResponseEntity<>(error, new HttpHeaders(), error.getStatus());
    }

    private void inflateErrors(RuntimeException exception, List<String> errors) {
        of(exception.getCause().getStackTrace())
                .forEach(stackTraceElement -> errors.add(buildError(stackTraceElement)));
    }

    private String buildError(StackTraceElement stackTraceElement) {
        return null;
    }
}
