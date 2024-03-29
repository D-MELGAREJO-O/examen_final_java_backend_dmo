package com.ef_java_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse<T> {

    private int status;
    private String message;
    private List<T> data;
}
