package com.bms.schoolmanagementsystemapp.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class StudentSaveDTO
{
    private String studentname;
    private String address;
    private String phone;
}