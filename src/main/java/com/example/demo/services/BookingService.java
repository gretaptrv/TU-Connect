package  com.example.demo.services;

import com.example.demo.enums.status.MeetingStatus;
import com.example.demo.models.BookedMeeting;
import com.example.demo.models.Student;
import com.example.demo.models.Tutor;
import com.example.demo.repos.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

  @Autowired
  private BookingRepository bookingRepository;

  public List<BookedMeeting> getAllMeetingsForStudent(Student student) {
    return bookingRepository.findAllByStudent(student);
  }

  // Get all booked meetings for a tutor
  public List<BookedMeeting> getAllMeetingsForTutor(Tutor tutor) {
    return bookingRepository.findAllByTutor(tutor);
  }

  // Book a meeting
  public BookedMeeting bookMeeting(BookedMeeting meeting) {
    meeting.setStatus(MeetingStatus.REQUESTED);
    return bookingRepository.save(meeting);
  }

  public BookedMeeting acceptMeeting(Long meetingId) {
    BookedMeeting meeting = bookingRepository.findById(meetingId).orElseThrow(() -> new DataRetrievalFailureException("Could not find information about meeting."));
    meeting.setStatus(MeetingStatus.ACCEPTED);
    return bookingRepository.save(meeting);
  }

  public BookedMeeting acceptMeetingWithChanges(Long meetingId, BookedMeeting updatedMeeting) {
    BookedMeeting meeting = bookingRepository.findById(meetingId).orElseThrow(() -> new DataRetrievalFailureException("Could not find information about meeting."));
    meeting.setStart(updatedMeeting.getStart());
    meeting.setEnd(updatedMeeting.getEnd());
    meeting.setRoomNum(updatedMeeting.getRoomNum());
    meeting.setStatus(MeetingStatus.ACCEPTED);
    return bookingRepository.save(meeting);
  }

  public void declineMeeting(Long meetingId) {
    BookedMeeting meeting = bookingRepository.findById(meetingId).orElseThrow(() -> new DataRetrievalFailureException("Could not find information about meeting."));
    meeting.setStatus(MeetingStatus.DECLINED);
    bookingRepository.save(meeting);
  }
}
