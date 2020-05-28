package com.qa.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    private String status;

    private Long apiID;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "movie_line", joinColumns = {
            @JoinColumn(name = "movie_id", referencedColumnName = "id",
                    nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "showtime_id", referencedColumnName = "id",
                            nullable = false,updatable = false)
            })
    private final List<ShowTime> showTimes = new ArrayList<>();

    public Movie(Long apiID, String status) {
        this.apiID = apiID;
        this.status = status;
    }

    public Long getApiID() {
        return apiID;
    }

    public void setApiID(Long apiID) {
        this.apiID = apiID;
    }

    public Movie(Long id, Long apiID, String status) {
        this.apiID = apiID;
        this.id = id;
        this.status = status;
    }

    public Movie() {
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

    public void setStatus(String name) {
        this.status = name;
    }

    public List<ShowTime> getShowTimes() {
        return showTimes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) &&
                Objects.equals(status, movie.status) &&
                Objects.equals(apiID, movie.apiID) &&
                Objects.equals(showTimes, movie.showTimes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, apiID, showTimes);
    }
}