package com.example.student_library_management_system.converter;

import com.example.student_library_management_system.model.Student;
import com.example.student_library_management_system.requestdto.StudentRequestDto;

public class StudentConverter {

    // Converter -> it converts the request dto into model classes so that model class gets saved in database as table data

    public static Student covertStudentRequestDtoIntoStudent(StudentRequestDto studentRequestDto){

        Student student = new Student();

        student.setName(studentRequestDto.getName());
        student.setAddress(studentRequestDto.getAddress());
        student.setDept(studentRequestDto.getDept());
        student.setDob(studentRequestDto.getDob());
        student.setEmail(studentRequestDto.getEmail());
        student.setGender(studentRequestDto.getGender());
        student.setSem(studentRequestDto.getSem());
        student.setMobile(studentRequestDto.getMobile());

        return student;
    }
}
