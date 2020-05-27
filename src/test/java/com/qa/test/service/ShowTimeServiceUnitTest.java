package com.qa.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.dto.ShowTimeDTO;
import com.qa.domain.ShowTime;
import com.qa.repo.ShowTimeRepo;
import com.qa.service.ShowTimeService;

@RunWith(SpringRunner.class)
public class ShowTimeServiceUnitTest {

    @InjectMocks
    private ShowTimeService service;

    @Mock
    private ShowTimeRepo repo;

    @Mock
    private ModelMapper mapper;

    private List<ShowTime> showTimeList;

    private ShowTime testShowTime;

    private ShowTime testShowTimeWithID;

    private ShowTimeDTO showTimeDTO;

    final long id = 1L;

    @Before
    public void init() {
        this.showTimeList = new ArrayList<>();
        this.showTimeList.add(testShowTime);
        this.testShowTime = new ShowTime("27/04/2020 14:30");
        this.testShowTimeWithID = new ShowTime(testShowTime.getTime());
        this.testShowTimeWithID.setId(id);
        this.showTimeDTO = new ModelMapper().map(testShowTimeWithID, ShowTimeDTO.class);
    }

    @Test
    public void createShowTimeTest() {
        when(this.repo.save(testShowTime)).thenReturn(testShowTimeWithID);
        when(this.mapper.map(testShowTimeWithID, ShowTimeDTO.class)).thenReturn(showTimeDTO);

        assertEquals(this.showTimeDTO, this.service.createShowTime(testShowTime));

        verify(this.repo, times(1)).save(this.testShowTime);
    }

    @Test
    public void deleteShowTimeTest() {
        when(this.repo.existsById(id)).thenReturn(true, false);

        this.service.deleteShowTime(id);

        verify(this.repo, times(1)).deleteById(id);
        verify(this.repo, times(2)).existsById(id);
    }

    @Test
    public void findShowTimeByIDTest() {
        when(this.repo.findById(this.id)).thenReturn(Optional.of(this.testShowTimeWithID));
        when(this.mapper.map(testShowTimeWithID, ShowTimeDTO.class)).thenReturn(showTimeDTO);

        assertEquals(this.showTimeDTO, this.service.findShowTimeByID(this.id));

        verify(this.repo, times(1)).findById(this.id);
    }

    @Test
    public void readShowTimesTest() {

        when(repo.findAll()).thenReturn(this.showTimeList);
        when(this.mapper.map(testShowTimeWithID, ShowTimeDTO.class)).thenReturn(showTimeDTO);

        assertFalse("Controller has found no showTimes", this.service.readShowTimes().isEmpty());

        verify(repo, times(1)).findAll();
    }

    @Test
    public void updateShowTimesTest() {
        // given
        ShowTime newShowTime = new ShowTime("27/04/2020 13:30");

        ShowTime updatedShowTime = new ShowTime(newShowTime.getTime());
        updatedShowTime.setId(this.id);

        ShowTimeDTO updatedDTO = new ModelMapper().map(updatedShowTime, ShowTimeDTO.class);


        when(this.repo.findById(this.id)).thenReturn(Optional.of(this.testShowTimeWithID));
        when(this.mapper.map(updatedShowTime, ShowTimeDTO.class)).thenReturn(updatedDTO);

        // You NEED to configure a .equals() method in ShowTime.java for this to work
        when(this.repo.save(updatedShowTime)).thenReturn(updatedShowTime);

        assertEquals(updatedDTO, this.service.updateShowTime(newShowTime, this.id));

        verify(this.repo, times(1)).findById(1L);
        verify(this.repo, times(1)).save(updatedShowTime);
    }

}