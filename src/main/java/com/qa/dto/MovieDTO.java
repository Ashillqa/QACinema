package com.qa.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MovieDTO {

    private Long id;

    private String status;

    private Long apiID;

    private String rating;

    private List<ShowTimeDTO> showTimes = new ArrayList<>();

    public MovieDTO(Long id, String status, Long apiID, String rating) {
        this.id = id;
        this.status = status;
        this.apiID = apiID;
        this.rating = rating;
    }

    public MovieDTO(String status, Long apiID, String rating) {
        this.status = status;
        this.apiID = apiID;
        this.rating = rating;
    }

    public MovieDTO() {
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Long getApiID() {
        return apiID;
    }

    public void setApiID(Long apiID) {
        this.apiID = apiID;
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
                Objects.equals(apiID, movieDTO.apiID) &&
                Objects.equals(showTimes, movieDTO.showTimes) &&
                Objects.equals(rating, movieDTO.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, apiID, showTimes, rating);
    }
}