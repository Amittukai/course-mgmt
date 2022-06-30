package com.course.management.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse<T> {
    Boolean status;
    Integer code;
    String message;
    T body;

    public ApiResponse(T payload) {
        this.body = payload;
    }
}
