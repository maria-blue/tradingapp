package com.example.tradingapp.service;

import com.example.tradingapp.model.Order;
import com.example.tradingapp.model.TradingUser;
import com.example.tradingapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  @Autowired
  OrderRepository orderRepository;

  @Autowired
  UserService userService;

  public Order saveOrUpdate(Order order) {
    return orderRepository.save(order);
  }

  public Order findById(int id) {
    return orderRepository.findById(id).orElseThrow();
  }

  public void deleteOrder(int orderId) {
    orderRepository.deleteById(orderId);
  }

  public void buyOrder(Order order) {
    saveOrUpdate(order);
  }
}
