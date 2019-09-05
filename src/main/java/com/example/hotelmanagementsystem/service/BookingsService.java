package com.example.hotelmanagementsystem.service;

import com.example.hotelmanagementsystem.model.Bookings;


import java.util.List;

public interface BookingsService {

  Bookings create(Bookings bookings);

  List<Bookings> findAll();


}
