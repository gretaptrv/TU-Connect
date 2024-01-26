package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ThesisDto {
    private Long tutorId;
    private String studentId;
    private String content;
    private String email;
}
