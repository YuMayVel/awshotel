package com.example.hotelmanagementsystem.service;

import com.example.hotelmanagementsystem.model.Role;
import com.example.hotelmanagementsystem.model.UserProfile;
import com.example.hotelmanagementsystem.repository.RoleRepository;
import com.example.hotelmanagementsystem.repository.UserProfileRepository;
import org.aspectj.weaver.bcel.BcelAccessForInlineMunger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserProfileRepository userProfileRepository;
  private final RoleRepository roleRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public UserDetailsServiceImpl(UserProfileRepository userProfileRepository
  , RoleRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userProfileRepository = userProfileRepository;
    this.roleRepository=repository;
    this.bCryptPasswordEncoder=bCryptPasswordEncoder;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    return userProfileRepository.findByEmail(email)
            .orElseThrow(() ->new UsernameNotFoundException(email + " Not Found!"));

  }

  public UserProfile register(UserProfile userProfile){
    Role role=roleRepository.findByName("ROLE_USER");
    userProfile.addRole(role);
    userProfile
            .setPassword(bCryptPasswordEncoder
                    .encode(userProfile.getPassword()));
    return this.userProfileRepository.save(userProfile);

  }

  public UserProfile findById(long id){
    return this.userProfileRepository.getOne(id);
  }

}
