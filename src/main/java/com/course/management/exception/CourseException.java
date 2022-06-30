package com.course.management.exception;

public class CourseException extends RuntimeException{
    long code;

    public CourseException( long code) {
        this.code = code;
    }
    public CourseException(String exceptionDetails) {
        super(exceptionDetails);
    }
    public CourseException(String message, Throwable cause) {
        super(message, cause);
    }
}

