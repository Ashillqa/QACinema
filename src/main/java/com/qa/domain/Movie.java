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

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    private List<ShowTime> showTimes = new ArrayList<>();

    public Movie(String status) {
        this.status = status;
    }

    public Movie(Long id, String status) {
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

    public void setShowTimes(List<ShowTime> showTimes) {
        this.showTimes = showTimes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) &&
                Objects.equals(status, movie.status) &&
                Objects.equals(showTimes, movie.showTimes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, showTimes);
    }
}