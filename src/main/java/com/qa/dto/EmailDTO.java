package com.qa.dto;

import java.util.Objects;

public class EmailDTO {

    private Long id;
    private String username;
    private String email;
    private String subject;
    private String body;

    public EmailDTO() {
    }

    public EmailDTO(Long id, String username, String email, String subject, String body) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.subject = subject;
        this.body = body;
    }

    public EmailDTO(String username, String email, String subject, String body) {
        this.username = username;
        this.email = email;
        this.subject = subject;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailDTO that = (EmailDTO) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(username, that.username) &&
               Objects.equals(email, that.email) &&
               Objects.equals(subject, that.subject) &&
               Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, subject, body);
    }
}
