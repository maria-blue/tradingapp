package com.example.tradingapp.service;

import com.example.tradingapp.model.TradingUser;
import com.example.tradingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public TradingUser saveOrUpdateUser(TradingUser tradingUser) {
    return userRepository.save(tradingUser);
  }

  public TradingUser findById(int id) {
    return userRepository.findById(id).orElseThrow();
  }

  public void deleteUser(int userId) {
    userRepository.deleteById(userId);
  }
}
