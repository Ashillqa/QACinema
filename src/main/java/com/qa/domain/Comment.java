package com.qa.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;
    private Long rating;
    private String comment;

    public Comment(String userName, Long rating, String comment) {
        this.userName = userName;
        this.rating = rating;
        this.comment = comment;
    }

    public Comment(Long id, String userName, Long rating, String comment) {
        this.id = id;
        this.userName = userName;
        this.rating = rating;
        this.comment = comment;
    }

    public Comment(){

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
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment1 = (Comment) o;
        return Objects.equals(id, comment1.id) &&
                Objects.equals(userName, comment1.userName) &&
                Objects.equals(rating, comment1.rating) &&
                Objects.equals(comment, comment1.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, rating, comment);
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + "," +
                "\"userName\":\"" + userName + "\"," +
                "\"rating\":" + rating + "," +
                "\"comment\":\"" + comment + "\"}";
    }

    public String listToJsonString(List<Comment> commentList) {
        StringBuilder stringBuilder = new StringBuilder("[");

        for (Comment value : commentList) {
            stringBuilder.append(value.toString());
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
