package com.bms.schoolmanagementsystemapp.repo;

import com.bms.schoolmanagementsystemapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StudentRepo extends JpaRepository<Student, Integer> {
}