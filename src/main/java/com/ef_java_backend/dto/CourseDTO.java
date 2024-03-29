package com.ef_java_backend.dto;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private Integer idCourse;

    @NotNull
    private String nameCourse;

    @NotNull
    private String acronymCourse;

    @NotNull
    private boolean stateCourse;

}
