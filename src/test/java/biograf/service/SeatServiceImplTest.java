package biograf.service;

import biograf.model.Seat;
import biograf.model.ShowTime;
import biograf.repositories.SeatRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SeatServiceImplTest {

    //Generate seats tests line 42-70
    // booking seat test line 75 - 110
    // get list of booked seats tests line 115 - 165


    @Mock
    private SeatRepository seatRepository;

    @InjectMocks
    private SeatServiceImpl seatService;

    private ShowTime showTime;

    @BeforeEach
    void setUp() {
        showTime = new ShowTime();
        showTime.setShowTimeID(1);
    }

    /*
    @Test
    void generateSeatsForShowTime_ShouldReturnExistingSeats_WhenAlreadyPresent() {
        // Arrange
        List<Seat> existingSeats = List.of(new Seat("A1"), new Seat("A2"));
        when(seatRepository.findByShowTime_ShowTimeIDAndIsBookedTrue(showTime.getShowTimeID())).thenReturn(existingSeats);

        // Act
        List<Seat> seats = seatService.generateSeatsForShowTime(showTime);

        // Assert
        assertEquals(2, seats.size());  // Should return only the 2 existing seats
        verify(seatRepository, never()).saveAll(anyList()); // Should NOT save new seats
        System.out.println("Seats when already present: " + seats);
    }
    */
     /*

    @Test
    void generateSeatsForShowTime_ShouldGenerateAndSaveSeats_WhenNoExistingSeats() {
        // Arrange
        when(seatRepository.findByShowTime_ShowTimeIDAndIsBookedTrue(showTime.getShowTimeID())).thenReturn(List.of()); // No existing seats
        when(seatRepository.saveAll(anyList())).thenAnswer(invocation -> invocation.getArgument(0)); // Simulate DB save

        // Act
        List<Seat> newSeats = seatService.generateSeatsForShowTime(showTime);

        // Assert
        assertEquals(50, newSeats.size());  // 5 rows * 10 columns = 50 seats
        verify(seatRepository, times(1)).saveAll(anyList()); // Verify saveAll() was called once
        System.out.println("Seats when no existing seats: " + newSeats);
    }
    */


    //booking tests

    @Test
    void bookSeat_shouldSetSeatAsBooked_andSaveIt() {
        // Given
        int seatID = 1;
        Seat mockSeat = new Seat("A1");
        mockSeat.setSeatID(seatID);
        mockSeat.setBooked(false);

        when(seatRepository.findById(seatID)).thenReturn(Optional.of(mockSeat));

        // When
        seatService.bookSeat(seatID);

        // Then
        assertTrue(mockSeat.isBooked(), "Seat should be marked as booked");
        verify(seatRepository, times(1)).save(mockSeat);

        // Console Output
        System.out.println("✅ Test Passed: bookSeat_shouldSetSeatAsBooked_andSaveIt");
        System.out.println("Seat ID: " + seatID + " is now booked: " + mockSeat.isBooked());
    }

    @Test
    void bookSeat_shouldNotSave_whenSeatNotFound() {
        // Given
        int seatID = 2;
        when(seatRepository.findById(seatID)).thenReturn(Optional.empty());

        // When
        seatService.bookSeat(seatID);

        // Then
        verify(seatRepository, never()).save(any(Seat.class));

        // Console Output
        System.out.println("✅ Test Passed: bookSeat_shouldNotSave_whenSeatNotFound");
        System.out.println("No seat found with ID: " + seatID + ". Save operation was not called.");
    }

        //List of booked seats test

    @Test
    void getBookedSeatsForShowTime_shouldReturnBookedSeats() {
        // Given
        int showTimeID = 1;
        Seat bookedSeat = new Seat("A1");
        bookedSeat.setBooked(true);
        ShowTime showTime = new ShowTime();
        showTime.setShowTimeID(showTimeID);
        bookedSeat.setShowTime(showTime);

        Seat unbookedSeat = new Seat("B1");
        unbookedSeat.setBooked(false);
        unbookedSeat.setShowTime(showTime);

        when(seatRepository.findAll()).thenReturn(List.of(bookedSeat, unbookedSeat));

        // When
        List<Seat> bookedSeats = seatService.getBookedSeatsForShowTime(showTimeID);

        // Then
        assertEquals(1, bookedSeats.size(), "There should be 1 booked seat");
        assertTrue(bookedSeats.get(0).isBooked(), "The seat should be booked");

        // Console Output
        System.out.println("✅ Test Passed: getBookedSeatsForShowTime_shouldReturnBookedSeats");
        System.out.println("Booked Seats for ShowTime ID: " + showTimeID);
        bookedSeats.forEach(seat -> System.out.println("Seat " + seat.getSeatNameID() + " is booked."));
    }

    @Test
    void getBookedSeatsForShowTime_shouldReturnEmptyList_whenNoBookedSeats() {
        // Given
        int showTimeID = 1;

        // Create a ShowTime object
        ShowTime showTime = new ShowTime();
        showTime.setShowTimeID(showTimeID);  // Set the ShowTimeID for the ShowTime object

        // Create Seat objects and assign the ShowTime object to them
        Seat unbookedSeat1 = new Seat("A1");
        unbookedSeat1.setBooked(false);
        unbookedSeat1.setShowTime(showTime);  // Set the ShowTime object for the seat

        Seat unbookedSeat2 = new Seat("B1");
        unbookedSeat2.setBooked(false);
        unbookedSeat2.setShowTime(showTime);  // Set the ShowTime object for the seat

        when(seatRepository.findAll()).thenReturn(List.of(unbookedSeat1, unbookedSeat2));

        // When
        List<Seat> bookedSeats = seatService.getBookedSeatsForShowTime(showTimeID);

        // Then
        assertTrue(bookedSeats.isEmpty(), "There should be no booked seats");

        // Console Output
        System.out.println("✅ Test Passed: getBookedSeatsForShowTime_shouldReturnEmptyList_whenNoBookedSeats");
        System.out.println("No booked seats found for ShowTime ID: " + showTimeID);
    }

}




