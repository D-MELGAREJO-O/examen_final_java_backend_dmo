package com.ef_java_backend.controller;

import com.ef_java_backend.dto.EnrollmentDTO;
import com.ef_java_backend.model.Course;
import com.ef_java_backend.model.Enrollment;
import com.ef_java_backend.model.EnrollmentDetail;
import com.ef_java_backend.model.Student;
import com.ef_java_backend.service.IEnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor

public class EnrollmentController {

    //@Autowired
    private final IEnrollmentService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> readAll() throws Exception{

        //ModelMapper modelMapper = new ModelMapper();
        List<EnrollmentDTO> list = service.readAll().stream().map(this::convertToDto).toList();


        //return new ResponseEntity<>(list, HttpStatus.OK);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Enrollment obj = service.readById(id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @PostMapping
    public ResponseEntity<EnrollmentDTO> save(@Valid @RequestBody EnrollmentDTO dto) throws Exception{
        Enrollment obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> update(@Valid @RequestBody EnrollmentDTO dto, @PathVariable("id") Integer id) throws Exception{
        Enrollment obj = service.update(convertToEntity(dto),id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/studentsbycourse")
    public ResponseEntity<List<String>> getEnrollmentStudentByCourse(){
        List<String> byCourse = service.getEnrollmentbyCourse();
        return new ResponseEntity<>(byCourse,HttpStatus.OK);
    }

    ///////////////////////////////////////////////
    private EnrollmentDTO convertToDto(Enrollment obj){
        return modelMapper.map(obj,EnrollmentDTO.class);
    }

    private Enrollment convertToEntity(EnrollmentDTO dto){
        return modelMapper.map(dto, Enrollment.class);
    }

}
