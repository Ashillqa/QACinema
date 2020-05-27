package com.qa.dto;

import java.util.Objects;

public class ShowTimeDTO {

    private Long id;

    private String time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ShowTimeDTO(String time) {
        this.time = time;
    }

    public ShowTimeDTO(Long id, String time) {
        this.id = id;
        this.time = time;
    }

    @Override
    public String toString() {
        return "ShowTimeDTO [id=" + id + ", name=" + time + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShowTimeDTO that = (ShowTimeDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time);
    }
}