package com.qa.service;

import java.util.List;
import java.util.stream.Collectors;

import com.qa.service.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.dto.BookingDTO;
import com.qa.exceptions.BookingNotFoundException;
import com.qa.domain.Booking;
import com.qa.repo.BookingRepository;
import com.qa.utils.MyBeanUtils;

@Service
public class BookingService  {

	private BookingRepository repo;

	private Mapper<Booking, BookingDTO> mapper;

	@Autowired
	public BookingService(BookingRepository repo, ModelMapper mapper) {
		this.repo = repo;
		this.mapper = (Booking booking) -> mapper.map(booking, BookingDTO.class);
	}

	public BookingDTO createBooking(Booking booking) {
		return this.mapper.mapToDTO(this.repo.save(booking));
	}

	public boolean deleteBooking(Long id) {
		if (!this.repo.existsById(id)) {
			throw new BookingNotFoundException();
		}
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}

	public BookingDTO findBookingByID(Long id) {
		return this.mapper.mapToDTO(this.repo.findById(id).orElseThrow(BookingNotFoundException::new));
	}

	public List<BookingDTO> readBookings() {
		return this.repo.findAll().stream().map(this.mapper::mapToDTO).collect(Collectors.toList());
	}

	public BookingDTO updateBooking(Booking booking, Long id) {
		Booking toUpdate = this.repo.findById(id).orElseThrow(BookingNotFoundException::new);
		MyBeanUtils.mergeNotNull(booking, toUpdate);
		return this.mapper.mapToDTO(this.repo.save(toUpdate));
	}

}