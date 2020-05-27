package com.qa.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.qa.dto.ShowTimeDTO;
import com.qa.domain.ShowTime;
import com.qa.repo.ShowTimeRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ShowTimeControllerIntegrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private ShowTimeRepo repo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ObjectMapper mapper;

    private long id;

    private ShowTime testShowTime;

    private ShowTime testShowTimeWithID;

    private ShowTimeDTO showTimeDTO;

    private ShowTimeDTO mapToDTO(ShowTime showTime) {
        return this.modelMapper.map(showTime, ShowTimeDTO.class);
    }

    @Before
    public void init() {
        this.repo.deleteAll();
        this.testShowTime = new ShowTime("27/04/2020 14:30");
        this.testShowTimeWithID = this.repo.save(this.testShowTime);
        this.id = this.testShowTimeWithID.getId();
        this.showTimeDTO = this.mapToDTO(testShowTimeWithID);
    }

    @Test
    public void testCreateShowTime() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/showTime/createShowTime");
        mockRequest.contentType(MediaType.APPLICATION_JSON);
        mockRequest.content(this.mapper.writeValueAsString(testShowTime));
        mockRequest.accept(MediaType.APPLICATION_JSON);

        ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
        ResultMatcher matchContent = MockMvcResultMatchers.content().json(this.mapper.writeValueAsString(showTimeDTO));
        this.mock.perform(mockRequest)
                .andExpect(matchStatus).andExpect(matchContent);

    }

    @Test
    public void testDeleteShowTime() throws Exception {
        this.mock.perform(request(HttpMethod.DELETE, "/showTime/deleteShowTime/" + this.id)).andExpect(status().isNoContent());
    }

    @Test
    public void testGetAllShowTimes() throws Exception {
        List<ShowTimeDTO> showTimeList = new ArrayList<>();
        showTimeList.add(this.showTimeDTO);

        String content = this.mock.perform(request(HttpMethod.GET, "/showTime/getAll").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals(this.mapper.writeValueAsString(showTimeList), content);
    }

    @Test
    public void testUpdateShowTime() throws Exception {
        ShowTime newShowTime = new ShowTime("27/04/2020 14:50");
        ShowTime updatedShowTime = new ShowTime(newShowTime.getTime());
        updatedShowTime.setId(this.id);

        String result = this.mock
                .perform(request(HttpMethod.PUT, "/showTime/updateShowTime/?id=" + this.id).accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(newShowTime)))
                .andExpect(status().isAccepted()).andReturn().getResponse().getContentAsString();

        assertEquals(this.mapper.writeValueAsString(this.mapToDTO(updatedShowTime)), result);
    }

}