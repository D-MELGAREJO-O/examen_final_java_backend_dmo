package com.ef_java_backend.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentDTO {

    private Integer idStudent;

    @NotNull
    private String firstnameStudent;

    @NotNull
    private String lastnameStudent;

    @NotNull
    private String dninumberStudent;

    //Edad mínima para matricularse: 18 años
    @Min(value = 18)
    private short ageStudent;
}
