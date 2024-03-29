package com.ef_java_backend.repo;

import com.ef_java_backend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepo extends IGenericRepo<Student,Integer> {
}
