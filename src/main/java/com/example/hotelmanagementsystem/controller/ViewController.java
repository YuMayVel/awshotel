package com.example.hotelmanagementsystem.controller;

import com.example.hotelmanagementsystem.model.Bookings;
import com.example.hotelmanagementsystem.model.UserProfile;
import com.example.hotelmanagementsystem.service.BookingsService;
import com.example.hotelmanagementsystem.service.RoomService;
import com.example.hotelmanagementsystem.service.UserDetailsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;

@Controller
public class ViewController {


  private final RoomService roomService;
  private final UserDetailsServiceImpl userDetailsService;
  private final BookingsService bookingsService;

  public ViewController(RoomService roomService,UserDetailsServiceImpl userDetailsService
  ,BookingsService bookingsService) {
    this.roomService = roomService;
    this.userDetailsService=userDetailsService;
    this.bookingsService=bookingsService;
  }

  @GetMapping("/view/rooms")
  public String viewAllRooms(Model model){
    model.addAttribute("rooms",roomService.findAll());
    return "views/rooms";
  }

  @GetMapping("/view/rooms/{id}")
  public String viewRoomDetails(Model model,@PathVariable("id") long id){
    model.addAttribute("room",roomService.findById(id));
    this.roomId=id;
    return "views/room";
  }

  @GetMapping("/view/userprofile/{id}")
  public String userProfileCreate(Model model,@PathVariable("id") long roomid){
    model.addAttribute("userprofile",new UserProfile());
    return "views/profile";
  }

  @PostMapping("/view/userprofile")
  public String userProfileProcess(UserProfile userProfile){
     UserProfile userProfile1=this.userDetailsService.register(userProfile);
     this.userProfileId=userProfile1.getId();

     return "redirect:/view/booking";
  }

  @GetMapping("/view/booking")
  public String bookingCreate(Model model){
    model.addAttribute("bookings",new Bookings());
    return "/views/bookingFrom";
  }

  @PostMapping("/view/booking")
  public String bookingProcess(Bookings bookings){
    bookings.setUserProfile(this.userDetailsService.findById(userProfileId));
    bookings.setBookingNumber("Delux-"+ (++bookingNumber) +new Random().nextInt(1000));
    this.bookingsService.create(bookings);
    return "redirect:/home";
  }




  private long userProfileId;

  private long roomId;

  private static int bookingNumber= 111;

}
