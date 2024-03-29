package com.ef_java_backend.service.Impl;

import com.ef_java_backend.model.Student;
import com.ef_java_backend.repo.IGenericRepo;
import com.ef_java_backend.repo.IStudentRepo;
import com.ef_java_backend.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student,Integer> implements IStudentService {

    private final IStudentRepo repo;
    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }

    //Listar estudiantes ordenados por edad de manera descendente:
    @Override
    public List<Student> getStudentsOrderByAgeDesc() {
        List<Student> byStudent = repo.findAll()
                .stream()
                .sorted(Comparator.comparing(Student::getAge).reversed()) //Compara la edad y la odena de manera descendente
                .collect(toList());

        //Se aplica el sorted para el ordenamiento de manera descendente con .reverseOrder()
        return byStudent;
    }
    }
