package com.qa.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MovieDTO {

    private Long id;

    private String status;

    private List<ShowTimeDTO> showTimes = new ArrayList<>();

    public MovieDTO(String status) {
        this.status = status;
    }

    public MovieDTO(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    public MovieDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ShowTimeDTO> getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(List<ShowTimeDTO> showTimes) {
        this.showTimes = showTimes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDTO movieDTO = (MovieDTO) o;
        return Objects.equals(id, movieDTO.id) &&
                Objects.equals(status, movieDTO.status) &&
                Objects.equals(showTimes, movieDTO.showTimes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, showTimes);
    }


}