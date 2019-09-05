package com.example.hotelmanagementsystem.service;

import com.example.hotelmanagementsystem.model.Bookings;
import com.example.hotelmanagementsystem.repository.BookingsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingServiceImpl implements BookingsService {

  private final BookingsRepository bookingsRepository;

  public BookingServiceImpl(BookingsRepository bookingsRepository) {
    this.bookingsRepository = bookingsRepository;
  }

  @Override
  public Bookings create(Bookings bookings) {
    return this.bookingsRepository.save(bookings);
  }

  @Override
  public List<Bookings> findAll() {
    return bookingsRepository.findAll();
  }
}
