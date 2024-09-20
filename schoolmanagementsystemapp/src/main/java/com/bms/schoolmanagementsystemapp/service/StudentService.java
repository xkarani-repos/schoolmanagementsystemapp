package com.bms.schoolmanagementsystemapp.service;

import java.util.List;
import com.bms.schoolmanagementsystemapp.dto.StudentSaveDTO;
import com.bms.schoolmanagementsystemapp.dto.StudentDTO;
import com.bms.schoolmanagementsystemapp.dto.StudentUpdateDTO;

public interface StudentService {
    String addStudent(StudentSaveDTO studentSaveDTO);
    List<StudentDTO> getAllStudents();
}