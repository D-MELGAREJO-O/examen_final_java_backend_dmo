package com.ef_java_backend.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EnrollmentDTO {

    private Integer idEnrollment;

    @NotNull
    private LocalDateTime dateTime;

    @NotNull
    private StudentDTO student;

    @NotNull
    private boolean state;

    @JsonManagedReference
    @NotNull
    private List<EnrollmentDetailDTO> details;


}
