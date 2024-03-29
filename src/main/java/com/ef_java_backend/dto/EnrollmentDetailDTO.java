package com.ef_java_backend.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EnrollmentDetailDTO {

    //@NotNull
    @JsonBackReference
    private EnrollmentDTO enrollment;

    @NotNull
    private CourseDTO course;

    @NotNull
    private String classroom;

}
