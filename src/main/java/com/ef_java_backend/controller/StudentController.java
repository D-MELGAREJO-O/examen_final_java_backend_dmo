package com.ef_java_backend.controller;

import com.ef_java_backend.dto.StudentDTO;
import com.ef_java_backend.model.Student;
import com.ef_java_backend.service.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> readAll() throws Exception{
        List<StudentDTO> list = service.readAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Student obj = service.readById(id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody StudentDTO dto) throws Exception{
        Student obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@Valid @RequestBody StudentDTO dto, @PathVariable("id") Integer id) throws Exception{
        Student obj = service.update(convertToEntity(dto),id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/liststudentbyagedesc")
    public ResponseEntity<List<Student>> getListStudentByAgeDesc(){
        List<Student> byStudent = service.getStudentsOrderByAgeDesc();
        return new ResponseEntity<>(byStudent,HttpStatus.OK);
    }

    private StudentDTO convertToDto(Student obj){
        return modelMapper.map(obj,StudentDTO.class);
    }
    private Student convertToEntity(StudentDTO dto){
        return modelMapper.map(dto, Student.class);
    }
}
