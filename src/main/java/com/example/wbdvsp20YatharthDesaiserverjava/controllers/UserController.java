package com.example.wbdvsp20YatharthDesaiserverjava.controllers;


import com.example.wbdvsp20YatharthDesaiserverjava.models.User;
import com.example.wbdvsp20YatharthDesaiserverjava.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {
  @Autowired
  UserRepository repository;

  @PostMapping("/logout")
  public void logout(HttpSession session){
    session.invalidate();
  }

  @PostMapping("/login")
  public User login (HttpSession session, @RequestBody User user) {
    User profile = repository.findUserByCredentials(user.getUsername(),user.getPassword());
    session.setAttribute("profile", profile);
    return profile;
  }

  @PostMapping("/register")
  public User register(HttpSession session,
                       @RequestBody User user) {
    User newUser = repository.save(user);
    newUser.setPassword("***");
    session.setAttribute("profile", newUser);
    return newUser;
  }

  @PostMapping("/profile")
  public User profile(HttpSession session) {
    User profile = (User)session.getAttribute("profile");
    return profile;
  }
}
