package com.bms.schoolmanagementsystemapp.service.IMPL;


import com.bms.schoolmanagementsystemapp.dto.StudentSaveDTO;
import com.bms.schoolmanagementsystemapp.dto.StudentUpdateDTO;
import com.bms.schoolmanagementsystemapp.dto.StudentDTO;
import com.bms.schoolmanagementsystemapp.entity.Student;
import com.bms.schoolmanagementsystemapp.repo.StudentRepo;
import com.bms.schoolmanagementsystemapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import java.util.List;

@Service


public class StudentServiceIMPL implements StudentService {
    @Autowired
    private  StudentRepo studentRepo;

    @Override
    public String addStudent(StudentSaveDTO studentSaveDTO) {

        Student student = new Student(
                studentSaveDTO.getStudentname(),
                studentSaveDTO.getAddress(),
                studentSaveDTO.getPhone()

        );
        studentRepo.save(student);
        return student.getStudentname();
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> getStudents  = studentRepo.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for(Student student:getStudents)
        {
            StudentDTO studentDTO = new StudentDTO(
                    student.getStudentid(),
                    student.getStudentname(),
                    student.getAddress(),
                    student.getPhone()
            );
            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }

    @Override
    public String updateStudent(StudentUpdateDTO studentUpdateDTO) {
        if(studentRepo.existsById(studentUpdateDTO.getStudentid()))
        {
            Student student = studentRepo.getById(studentUpdateDTO.getStudentid());
            student.setStudentname(studentUpdateDTO.getStudentname());
            student.setAddress(studentUpdateDTO.getAddress());
            student.setPhone(studentUpdateDTO.getPhone());
            studentRepo.save(student);
            return student.getStudentname();
        }
        else
        {
            System.out.println("Student ID Not Found");
        }
        return null;
    }
    @Override
    public boolean deleteStudent(int id) {
        if(studentRepo.existsById(id))
        {
            studentRepo.deleteById(id);
        }
        else
        {
            System.out.println("Student ID Not Found");
        }
        return false;
    }
}
