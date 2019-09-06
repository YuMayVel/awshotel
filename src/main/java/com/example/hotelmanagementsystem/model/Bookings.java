package com.example.hotelmanagementsystem.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Bookings {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String bookingNumber;
  private int numbersOfAdults;
  private int numbersOfChildren;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate fromStart;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate toEnd;
  private boolean bookingCancelled;
  private double inAdvance;
  private double fullCharges;

  @ManyToOne
  private UserProfile userProfile;



  public Bookings() {
  }

  public Bookings(String bookingNumber, int numbersOfAdults, int numbersOfChildren, LocalDate from, LocalDate to, boolean bookingCancelled, double inAdvance, double fullCharges, UserProfile userProfile) {
    this.bookingNumber = bookingNumber;
    this.numbersOfAdults = numbersOfAdults;
    this.numbersOfChildren = numbersOfChildren;
    this.fromStart = from;
    this.toEnd = to;
    this.bookingCancelled = bookingCancelled;
    this.inAdvance = inAdvance;
    this.fullCharges = fullCharges;
    this.userProfile = userProfile;

  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getBookingNumber() {
    return bookingNumber;
  }

  public void setBookingNumber(String bookingNumber) {
    this.bookingNumber = bookingNumber;
  }

  public int getNumbersOfAdults() {
    return numbersOfAdults;
  }

  public void setNumbersOfAdults(int numbersOfAdults) {
    this.numbersOfAdults = numbersOfAdults;
  }

  public int getNumbersOfChildren() {
    return numbersOfChildren;
  }

  public void setNumbersOfChildren(int numbersOfChildren) {
    this.numbersOfChildren = numbersOfChildren;
  }

  public LocalDate getFromStart() {
    return fromStart;
  }

  public boolean isBookingCancelled() {
    return bookingCancelled;
  }

  public void setBookingCancelled(boolean bookingCancelled) {
    this.bookingCancelled = bookingCancelled;
  }

  public double getInAdvance() {
    return inAdvance;
  }

  public void setInAdvance(double inAdvance) {
    this.inAdvance = inAdvance;
  }

  public double getFullCharges() {
    return fullCharges;
  }

  public void setFullCharges(double fullCharges) {
    this.fullCharges = fullCharges;
  }

  public UserProfile getUserProfile() {
    return userProfile;
  }

  public void setUserProfile(UserProfile userProfile) {
    this.userProfile = userProfile;
  }


  public void setFromStart(LocalDate fromStart) {
    this.fromStart = fromStart;
  }

  public LocalDate getToEnd() {
    return toEnd;
  }

  public void setToEnd(LocalDate toEnd) {
    this.toEnd = toEnd;
  }
}
