package com.ef_java_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity

public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idEnrollment;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne //FK Estudiante (Tipo Class)
    @JoinColumn(name="id_student",nullable = false,foreignKey = @ForeignKey(name = "FK_ENROLLMENT_STUDENT"))
    private Student student;

    @Column(nullable = false)
    private boolean state;

    @OneToMany(mappedBy = "enrollment",cascade = CascadeType.ALL) //El OneToMany "SIEMPRE" trabaja de la mano con un List<>
    private List<EnrollmentDetail> details;

}
