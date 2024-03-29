package com.ef_java_backend.service.Impl;

import com.ef_java_backend.model.Course;
import com.ef_java_backend.model.Student;
import com.ef_java_backend.repo.IGenericRepo;
import com.ef_java_backend.repo.ICourseRepo;
import com.ef_java_backend.repo.IStudentRepo;
import com.ef_java_backend.service.ICourseService;
import com.ef_java_backend.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course,Integer> implements ICourseService {

    private final ICourseRepo repo;
    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }
}
