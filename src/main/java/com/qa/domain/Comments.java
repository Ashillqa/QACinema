package com.qa.domain;

import javax.persistence.*;


@Entity
@Table(name = "Comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;
    private Long rating;
    private String comment;

    public Comments() {
    }

    public Comments(String userName, Long rating, String comment) {
        this.userName = userName;
        this.rating = rating;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comments)) return false;

        Comments comments = (Comments) o;

        if (!getId().equals(comments.getId())) return false;
        if (!getUserName().equals(comments.getUserName())) return false;
        if (!getRating().equals(comments.getRating())) return false;
        return getComment().equals(comments.getComment());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getUserName().hashCode();
        result = 31 * result + getRating().hashCode();
        result = 31 * result + getComment().hashCode();
        return result;
    }
}
