package com.qa.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;


@Entity
public class Booking {

    @Id
    @GeneratedValue
    private Long id;

    private Long movieId;
    private String movieName;
    private String dateTime;
    private BigDecimal totalPrice;
    private String emailAddress;
    private String phoneNumber;
    private String customerName;
    private Integer adultNr;
    private Integer childNr;
    private Integer studentNr;

    public Booking(Long movieId, String movieName, String dateTime, BigDecimal totalPrice, String emailAddress, String phoneNumber, String customerName, Integer adultNr, Integer childNr, Integer studentNr) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.dateTime = dateTime;
        this.totalPrice = totalPrice;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.customerName = customerName;
        this.adultNr = adultNr;
        this.childNr = childNr;
        this.studentNr = studentNr;
    }

    public Booking(Long id, Long movieId, String movieName, String dateTime, BigDecimal totalPrice, String emailAddress, String phoneNumber, String customerName, Integer adultNr, Integer childNr, Integer studentNr) {
        this.id = id;
        this.movieId = movieId;
        this.movieName = movieName;
        this.dateTime = dateTime;
        this.totalPrice = totalPrice;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.customerName = customerName;
        this.adultNr = adultNr;
        this.childNr = childNr;
        this.studentNr = studentNr;
    }

    public Booking() {
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getAdultNr() {
        return adultNr;
    }

    public void setAdultNr(Integer adultNr) {
        this.adultNr = adultNr;
    }

    public Integer getChildNr() {
        return childNr;
    }

    public void setChildNr(Integer childNr) {
        this.childNr = childNr;
    }

    public Integer getStudentNr() {
        return studentNr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentNr(Integer studentNr) {
        this.studentNr = studentNr;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Booking bookings = (Booking) object;
        return id.equals(bookings.id) &&
                java.util.Objects.equals(movieId, bookings.movieId) &&
                java.util.Objects.equals(movieName, bookings.movieName) &&
                java.util.Objects.equals(dateTime, bookings.dateTime) &&
                java.util.Objects.equals(totalPrice, bookings.totalPrice) &&
                java.util.Objects.equals(emailAddress, bookings.emailAddress) &&
                java.util.Objects.equals(phoneNumber, bookings.phoneNumber) &&
                java.util.Objects.equals(customerName, bookings.customerName) &&
                java.util.Objects.equals(adultNr, bookings.adultNr) &&
                java.util.Objects.equals(childNr, bookings.childNr) &&
                java.util.Objects.equals(studentNr, bookings.studentNr);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), id, movieId, movieName, dateTime, totalPrice, emailAddress, phoneNumber, customerName, adultNr, childNr, studentNr);
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + "," +
                "\"movieId\":" + movieId + "," +
                "\"movieName\":\"" + movieName + "\"," +
                "\"dateTime\":\"" + dateTime + "\"," +
                "\"totalPrice\":" + totalPrice + "," +
                "\"emailAddress\":\"" + emailAddress + "\"," +
                "\"phoneNumber\":\"" + phoneNumber + "\"," +
                "\"customerName\":\"" + customerName + "\"," +
                "\"adultNr\":" + adultNr + "," +
                "\"childNr\":" + childNr + "," +
                "\"studentNr\":" + studentNr + "}";
    }

    public String listToJsonString(List<Booking> bookingList) {
        StringBuilder stringBuilder = new StringBuilder("[");

        for (Booking value : bookingList) {
            stringBuilder.append(value.toString());
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
