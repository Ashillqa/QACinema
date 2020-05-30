package com.qa.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.dto.BookingDTO;
import com.qa.domain.Booking;
import com.qa.repo.BookingRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BookingControllerIntegrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private BookingRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ObjectMapper mapper;

    private long id;

    private Booking testBooking;

    private Booking testBookingWithID;

    private BookingDTO bookingDTO;

    private BookingDTO mapToDTO(Booking booking) {
        return this.modelMapper.map(booking, BookingDTO.class);
    }

    @Before
    public void init() {
        this.repo.deleteAll();
        this.testBooking = new Booking(1L, "Shrek 3", "27/05/2020 15:30", BigDecimal.valueOf(13.99),"email@email.com","0044 771234123","Jeff Tester",1,1,0);
        this.testBookingWithID = this.repo.save(this.testBooking);
        this.id = this.testBookingWithID.getId();
        this.bookingDTO = this.mapToDTO(testBookingWithID);
    }

    @Test
    public void testCreateBooking() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/booking/createBooking");
        mockRequest.contentType(MediaType.APPLICATION_JSON);
        mockRequest.content(this.mapper.writeValueAsString(testBooking));
        mockRequest.accept(MediaType.APPLICATION_JSON);

        ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
        ResultMatcher matchContent = MockMvcResultMatchers.content().json(this.mapper.writeValueAsString(bookingDTO));
        this.mock.perform(mockRequest)
                .andExpect(matchStatus).andExpect(matchContent);

    }

    @Test
    public void testDeleteBooking() throws Exception {
        this.mock.perform(request(HttpMethod.DELETE, "/booking/deleteBooking/" + this.id)).andExpect(status().isNoContent());
    }

    @Test
    public void testGetAllBookings() throws Exception {
        List<BookingDTO> bookingList = new ArrayList<>();
        bookingList.add(this.bookingDTO);

        String content = this.mock.perform(request(HttpMethod.GET, "/booking/getAll").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals(this.mapper.writeValueAsString(bookingList), content);
    }

    @Test
    public void testUpdateBooking() throws Exception {
        Booking newBooking = new Booking(testBookingWithID.getId(), "Shrek 3", "28/05/2020 15:30", BigDecimal.valueOf(11.99),"email@email.com","0044 134512312","Jeff Tester",1,2,0);
        Booking updatedBooking = new Booking(newBooking.getMovieName(),newBooking.getDateTime(),newBooking.getTotalPrice(),newBooking.getEmailAddress(),newBooking.getPhoneNumber(),newBooking.getCustomerName(),newBooking.getAdultNr(),newBooking.getChildNr(),newBooking.getStudentNr());
        updatedBooking.setId(this.id);

        String result = this.mock
                .perform(request(HttpMethod.PUT, "/booking/updateBooking/?id=" + this.id).accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(newBooking)))
                .andExpect(status().isAccepted()).andReturn().getResponse().getContentAsString();

        assertEquals(this.mapper.writeValueAsString(this.mapToDTO(updatedBooking)), result);
    }

}