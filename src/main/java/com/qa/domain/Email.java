package com.qa.domain;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Email {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String email;
    private String subject;
    private String body;

    public Email() {
    }

    public Email(Long id, String username, String email, String subject, String body) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.subject = subject;
        this.body = body;
    }

    public Email(String username, String email, String subject, String body) {
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
        if (!(o instanceof Email)) return false;
        Email email1 = (Email) o;
        return getId().equals(email1.getId()) &&
                getUsername().equals(email1.getUsername()) &&
                getEmail().equals(email1.getEmail()) &&
                getSubject().equals(email1.getSubject()) &&
                getBody().equals(email1.getBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getEmail(), getSubject(), getBody());
    }
}
