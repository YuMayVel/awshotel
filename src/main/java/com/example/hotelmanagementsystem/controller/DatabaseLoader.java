package com.example.hotelmanagementsystem.controller;

import com.example.hotelmanagementsystem.model.Gender;
import com.example.hotelmanagementsystem.model.Role;
import com.example.hotelmanagementsystem.model.UserProfile;
import com.example.hotelmanagementsystem.repository.RoleRepository;
import com.example.hotelmanagementsystem.repository.UserProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final RoleRepository roleRepository;
  private final UserProfileRepository userProfileRepository;

  public DatabaseLoader(BCryptPasswordEncoder bCryptPasswordEncoder,
                        RoleRepository roleRepository,
                        UserProfileRepository userProfileRepository) {
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    this.roleRepository=roleRepository;
    this.userProfileRepository=userProfileRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Role userRole=new Role();
    userRole.setName("ROLE_USER");
    Role adminRole=new Role();
    adminRole.setName("ROLE_ADMIN");


    UserProfile userProfile=new UserProfile();
    userProfile.setEmail("kyaw@gmail.com");
    userProfile.setFirstName("Kyaw");
    userProfile.setLastName("Lwin");
    userProfile.setGender(Gender.MALE);
    userProfile.setPhoneNumber("1234567");
    userProfile.addRole(adminRole);
    userProfile.setPassword(bCryptPasswordEncoder.encode("kyaw"));


   /* this.roleRepository.save(adminRole);
    this.roleRepository.save(userRole);
    this.userProfileRepository.save(userProfile);
    */
  }
}
