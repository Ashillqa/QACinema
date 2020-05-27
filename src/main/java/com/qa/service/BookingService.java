package com.qa.service;

import java.util.List;

import com.qa.domain.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.domain.Booking;
import com.qa.exceptions.BookingNotFoundException;
import com.qa.repo.BookingRepository;

@Service
public class BookingService {
	private final BookingRepository repo;

	@Autowired
	public BookingService(BookingRepository repo) {
		this.repo = repo;
	}

	public List<Booking> readBookings(){
		return this.repo.findAll();
	}

	public Booking createBooking(Booking booking) {
		return this.repo.save(booking);
	}

	public Booking findBookingById(Long id) {
		return this.repo.findById(id).orElseThrow(BookingNotFoundException::new);
	}

	public Booking updateBooking(Long id, Booking booking) {

		Booking update = findBookingById(id);

		update.setMovieId(booking.getMovieId());
		update.setAdultNr(booking.getAdultNr());
		update.setChildNr(booking.getChildNr());
		update.setCustomerName(booking.getCustomerName());
		update.setDateTime(booking.getDateTime());
		update.setEmailAddress(booking.getEmailAddress());
		update.setMovieName(booking.getMovieName());
		update.setPhoneNumber(booking.getPhoneNumber());
		update.setStudentNr(booking.getStudentNr());
		update.setTotalPrice(booking.getTotalPrice());

		return this.repo.save(update);
	}

	public boolean deleteBooking(Long id) {
		if (!this.repo.existsById(id)) {
			throw new BookingNotFoundException();
		}
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}

}
