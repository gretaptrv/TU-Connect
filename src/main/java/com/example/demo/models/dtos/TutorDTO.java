package com.example.demo.models.dtos;

import com.example.demo.models.Tutor;
import lombok.Builder;
import lombok.Data;

@Data
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
        TutorDTO.TutorDTOBuilder builder = TutorDTO.builder().id(tutor.getId());

        if (tutor.getFirstName() != null) {
            builder.firstName(tutor.getFirstName());
        } else {
            builder.firstName("");
        }
        if (tutor.getLastName() != null) {
            builder.lastName(tutor.getLastName());
        } else {
            builder.lastName("");
        }
        if (tutor.getPhoneNum() != null) {
            builder.phoneNum(tutor.getPhoneNum());
        } else {
            builder.phoneNum("");
        }
        if (tutor.getRoomNum() != null) {
            builder.roomNum(tutor.getRoomNum());
        } else {
            builder.roomNum("");
        }
        if (tutor.getVisitingHours() != null) {
            builder.startTime(tutor.getVisitingHours().getStart().toString());
        } else {
            builder.startTime("");
        }
        if (tutor.getVisitingHours() != null) {
            builder.endTime(tutor.getVisitingHours().getEnd().toString());
        } else {
            builder.endTime("");
        }
        if (tutor.getFaculty() != null && tutor.getFaculty().getName() != null) {
            builder.facultyName(tutor.getFaculty().getName());
        } else {
            builder.facultyName("");
        }

        return builder.build();
    }

}