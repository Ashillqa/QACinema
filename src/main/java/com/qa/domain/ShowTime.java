package com.qa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ShowTime {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "showTime_name", unique = true)
    @NotNull
    @Size(min = 0, max = 55)
    private String name;

    @NotNull
    private String colour;

    @NotNull
    private String habitat;

    @Min(0)
    @Max(30)
    private int age;

    @ManyToOne(targetEntity = Movie.class)
    private Movie movie;

    public ShowTime(String name, String colour, String habitat) {
        super();
        this.name = name;
        this.colour = colour;
        this.habitat = habitat;
    }

    public ShowTime() {
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

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ShowTime other = (ShowTime) obj;
        if (colour == null) {
            if (other.colour != null)
                return false;
        } else if (!colour.equals(other.colour))
            return false;
        if (habitat == null) {
            if (other.habitat != null)
                return false;
        } else if (!habitat.equals(other.habitat))
            return false;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}