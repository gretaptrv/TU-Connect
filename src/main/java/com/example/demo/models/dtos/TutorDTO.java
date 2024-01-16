package com.example.demo.models.dtos;

import com.example.demo.models.Tutor;
import lombok.Builder;

@Builder
public class TutorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNum;
    private String roomNum;
    private String startTime;
    private String endTime;
    private String facultyName;

    public static TutorDTO convert(Tutor tutor) {
        return TutorDTO.builder()
            .id(tutor.getId())
            .firstName(tutor.getFirstName())
            .lastName(tutor.getLastName())
            .phoneNum(tutor.getPhoneNum())
            .roomNum(tutor.getRoomNum())
            .startTime(tutor.getVisitingHours().getStart().toString())
            .endTime(tutor.getVisitingHours().getEnd().toString())
            .facultyName(tutor.getFaculty().getName())
            .build();
    }
}