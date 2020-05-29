package com.qa.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.dto.ShowTimeDTO;
import com.qa.domain.ShowTime;
import com.qa.repo.ShowTimeRepo;
import com.qa.service.ShowTimeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShowTimeServiceIntegrationTest {

    @Autowired
    private ShowTimeService service;

    @Autowired
    private ShowTimeRepo repo;

    private ShowTime testShowTime;

    private ShowTime testShowTimeWithID;

    @Autowired
    private ModelMapper mapper;

    private ShowTimeDTO mapToDTO(ShowTime showTime) {
        return this.mapper.map(showTime, ShowTimeDTO.class);
    }

    @Before
    public void init() {
        this.testShowTime = new ShowTime("27/04/2020 14:30");

        this.repo.deleteAll();

        this.testShowTimeWithID = this.repo.save(this.testShowTime);
    }

    @Test
    public void testCreateShowTime() {
        assertEquals(this.mapToDTO(this.testShowTimeWithID), this.service.createShowTime(testShowTime));
    }

    @Test
    public void testDeleteShowTime() {
        assertThat(this.service.deleteShowTime(this.testShowTimeWithID.getId())).isFalse();
    }

    @Test
    public void testFindShowTimeByID() {
        assertThat(this.service.findShowTimeByID(this.testShowTimeWithID.getId())).isEqualTo(this.mapToDTO(this.testShowTimeWithID));
    }

    @Test
    public void testReadShowTimes() {
        assertThat(this.service.readShowTimes()).isEqualTo(Stream.of(this.mapToDTO(testShowTimeWithID)).collect(Collectors.toList()));
    }

    @Test
    public void testUpdateShowTime() {
        ShowTime newShowTime = new ShowTime("27/04/2020 14:20");
        ShowTime updatedShowTime = new ShowTime(newShowTime.getTime());
        updatedShowTime.setId(this.testShowTimeWithID.getId());

        assertThat(this.service.updateShowTime(newShowTime, this.testShowTimeWithID.getId())).isEqualTo(this.mapToDTO(updatedShowTime));
    }

}