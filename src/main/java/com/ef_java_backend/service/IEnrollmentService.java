package com.ef_java_backend.service;

import com.ef_java_backend.model.Course;
import com.ef_java_backend.model.Enrollment;
import com.ef_java_backend.model.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public interface IEnrollmentService extends ICRUD<Enrollment,Integer> {

    List<String> getEnrollmentbyCourse();
}
