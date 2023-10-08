package com.example.demo.services;

import com.example.demo.enums.booked.meeting.Status;
import com.example.demo.models.BookedMeeting;
import com.example.demo.dtos.BookedMeetingDto;
import com.example.demo.repos.BookingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

  BookingRepository bookings;

  public void saveBookings(BookedMeetingDto bookingDto) {
    BookedMeeting booking = new ModelMapper().map(bookingDto, BookedMeeting.class);
    booking.setEnd(bookingDto.getEnd());
    booking.setStart(bookingDto.getEnd());
    booking.setReason(bookingDto.getReason());
    booking.setRoomNum(bookingDto.getRoomNum());
    booking.setStudentFN(bookingDto.getStudentFN());
    booking.setTutorFN(bookingDto.getTutorFN());
    booking.setStatus(Status.PENDING);
    bookings.save(booking);
  }

}
