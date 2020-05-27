package com.qa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.dto.ShowTimeDTO;
import com.qa.exceptions.ShowTimeNotFoundException;
import com.qa.domain.ShowTime;
import com.qa.repo.ShowTimeRepo;
import com.qa.utils.MyBeanUtils;

@Service
public class ShowTimeService  {

    private ShowTimeRepo repo;

    private Mapper<ShowTime, ShowTimeDTO> mapper;

    @Autowired
    public ShowTimeService(ShowTimeRepo repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = (ShowTime showTime) -> mapper.map(showTime, ShowTimeDTO.class);
    }

    public ShowTimeDTO createShowTime(ShowTime showTime) {
        return this.mapper.mapToDTO(this.repo.save(showTime));
    }

    public boolean deleteShowTime(Long id) {
        if (!this.repo.existsById(id)) {
            throw new ShowTimeNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

    public ShowTimeDTO findShowTimeByID(Long id) {
        return this.mapper.mapToDTO(this.repo.findById(id).orElseThrow(ShowTimeNotFoundException::new));
    }

    public List<ShowTimeDTO> readShowTimes() {
        return this.repo.findAll().stream().map(this.mapper::mapToDTO).collect(Collectors.toList());
    }

    public ShowTimeDTO updateShowTime(ShowTime showTime, Long id) {
        ShowTime toUpdate = this.repo.findById(id).orElseThrow(ShowTimeNotFoundException::new);
        MyBeanUtils.mergeNotNull(showTime, toUpdate);
        return this.mapper.mapToDTO(this.repo.save(toUpdate));
    }

}