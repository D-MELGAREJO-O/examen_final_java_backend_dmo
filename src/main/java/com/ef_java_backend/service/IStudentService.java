package com.ef_java_backend.service;
import com.ef_java_backend.model.Student;
import java.util.List;
import java.util.Map;

public interface IStudentService extends ICRUD<Student,Integer> {

    List<Student> getStudentsOrderByAgeDesc();
}
