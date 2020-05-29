package com.qa.test.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.dto.ShowTimeDTO;
import com.qa.domain.ShowTime;
import com.qa.controller.ShowTimeController;
import com.qa.service.ShowTimeService;

@RunWith(MockitoJUnitRunner.class)
public class ShowTimeControllerUnitTest {

    @InjectMocks
    private ShowTimeController controller;

    @Mock
    private ShowTimeService service;

    private List<ShowTime> showTimeList;

    private ShowTime testShowTime;

    private ShowTime testShowTimeWithID;

    private ShowTimeDTO showTimeDTO;

    final long id = 1L;

    private ModelMapper mapper = new ModelMapper();


    private ShowTimeDTO mapToDTO(ShowTime showTime) {
        return this.mapper.map(showTime, ShowTimeDTO.class);
    }


    @Before
    public void init() {
        this.showTimeList = new ArrayList<>();
        this.testShowTime = new ShowTime("27/04/2020 14:30");
        this.showTimeList.add(testShowTime);
        this.testShowTimeWithID = new ShowTime(testShowTime.getTime());
        this.testShowTimeWithID.setId(id);
        this.showTimeDTO = this.mapToDTO(testShowTimeWithID);
    }

    @Test
    public void createShowTimeTest() {
        when(this.service.createShowTime(testShowTime)).thenReturn(this.showTimeDTO);

        assertEquals(new ResponseEntity<ShowTimeDTO>(this.showTimeDTO, HttpStatus.CREATED), this.controller.createShowTime(testShowTime));

        verify(this.service, times(1)).createShowTime(this.testShowTime);
    }

    @Test
    public void deleteShowTimeTest() {
        this.controller.deleteShowTime(id);

        verify(this.service, times(1)).deleteShowTime(id);
    }

    @Test
    public void findShowTimeByIDTest() {
        when(this.service.findShowTimeByID(this.id)).thenReturn(this.showTimeDTO);

        assertEquals(new ResponseEntity<ShowTimeDTO>(this.showTimeDTO, HttpStatus.OK), this.controller.getShowTime(this.id));

        verify(this.service, times(1)).findShowTimeByID(this.id);
    }

    @Test
    public void getAllShowTimesTest() {

        when(service.readShowTimes()).thenReturn(this.showTimeList.stream().map(this::mapToDTO).collect(Collectors.toList()));

        assertFalse("Controller has found no showTimes", this.controller.getAllShowTimes().getBody().isEmpty());

        verify(service, times(1)).readShowTimes();
    }

    @Test
    public void updateShowTimesTest() {
        // given
        ShowTime newShowTime = new ShowTime("27/04/2020 14:50");
        ShowTime updatedShowTime = new ShowTime(newShowTime.getTime());
        updatedShowTime.setId(this.id);

        when(this.service.updateShowTime(newShowTime, this.id)).thenReturn(this.mapToDTO(updatedShowTime));

        assertEquals(new ResponseEntity<ShowTimeDTO>(this.mapToDTO(updatedShowTime), HttpStatus.ACCEPTED), this.controller.updateShowTime(this.id, newShowTime));

        verify(this.service, times(1)).updateShowTime(newShowTime, this.id);
    }

}