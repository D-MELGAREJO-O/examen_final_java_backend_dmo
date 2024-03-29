package com.ef_java_backend.repo;

import com.ef_java_backend.model.Enrollment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface IEnrollmentRepo extends IGenericRepo<Enrollment,Integer> {

}
