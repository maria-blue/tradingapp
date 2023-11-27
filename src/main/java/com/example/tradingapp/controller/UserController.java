package com.example.tradingapp.controller;

import com.example.tradingapp.model.TradingUser;
import com.example.tradingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/user/{userid}")
  private TradingUser getUser(@PathVariable("userid") int userid) {
    return userService.findById(userid);
  }

  @DeleteMapping("/user/{userid}")
  private void deleteUser(@PathVariable("userid") int userid) {
    userService.deleteUser(userid);
  }

  @PostMapping("/user")
  private int saveUser(@RequestBody TradingUser user) {
    userService.saveOrUpdateUser(user);
    return user.getId();
  }

  @PutMapping("/user")
  private TradingUser updateUser(@RequestBody TradingUser user) {
    userService.saveOrUpdateUser(user);
    return user;
  }

}
