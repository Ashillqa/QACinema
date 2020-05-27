package com.qa.dto;

import java.util.ArrayList;
import java.util.List;

public class MovieDTO {

    private Long id;

    private String name;

    private List<ShowTimeDTO> showTimes = new ArrayList<>();

    public MovieDTO(String name) {
        this.name = name;
    }

    public MovieDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ShowTimeDTO> getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(List<ShowTimeDTO> showTimes) {
        this.showTimes = showTimes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((showTimes == null) ? 0 : showTimes.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MovieDTO other = (MovieDTO) obj;
        if (showTimes == null) {
            if (other.showTimes != null)
                return false;
        } else if (!showTimes.equals(other.showTimes))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}