package com.ef_java_backend.service.Impl;


import com.ef_java_backend.model.Course;
import com.ef_java_backend.model.Enrollment;
import com.ef_java_backend.model.EnrollmentDetail;
import com.ef_java_backend.model.Student;
import com.ef_java_backend.repo.IGenericRepo;
import com.ef_java_backend.repo.IEnrollmentRepo;
import com.ef_java_backend.service.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CRUDImpl<Enrollment,Integer> implements IEnrollmentService {

    private final IEnrollmentRepo repo;

    @Override
    protected IGenericRepo<Enrollment, Integer> getRepo() {
        return repo;
    }

    //Muestra a los estudiantes matriculados por curso:
    public List<String> getEnrollmentbyCourse() {
        List<String> enrollmentStream = repo.findAll()
                .stream()
                .map(e -> e.getDetails().stream().map(d -> d.getCourse().getName()).toList() + " : " + e.getStudent().getFirstName() + " " + e.getStudent().getLastName())
                .sorted()
                .collect(Collectors.toList());
        return enrollmentStream;
    }
}
