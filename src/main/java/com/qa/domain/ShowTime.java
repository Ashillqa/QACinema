package com.qa.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class ShowTime {

    @Id
    @GeneratedValue
    private Long id;

    private String time;

    @ManyToMany(mappedBy = "showTimes",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private final List<Movie> movie = new ArrayList<>();

    public ShowTime(String time) {
        super();
        this.time = time;
    }

    public ShowTime(Long id, String time) {
        super();
        this.id = id;
        this.time = time;
    }

    public ShowTime() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String name) {
        this.time = name;
    }

    public List<Movie> getMovie() {
        return movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShowTime showTime = (ShowTime) o;
        return Objects.equals(id, showTime.id) &&
                Objects.equals(time, showTime.time) &&
                Objects.equals(movie, showTime.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, movie);
    }
}