package com.example.tradingapp.controller;

import com.example.tradingapp.model.Order;
import com.example.tradingapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  @Autowired
  OrderService orderService;

  @GetMapping("/order/{orderid}")
  private Order getOrder(@PathVariable("orderid") int orderid) {
    return orderService.findById(orderid);
  }

  @DeleteMapping("/order/{orderid}")
  private void deleteOrder(@PathVariable("orderid") int orderid) {
    orderService.deleteOrder(orderid);
  }

  @PostMapping("/order")
  private int saveOrder(@RequestBody Order order) {
    orderService.saveOrUpdate(order);
    return order.getId();
  }

  @PostMapping("/buyOrder")
  private int buyOrder(@RequestBody Order order) {
    orderService.buyOrder(order);
    return order.getId();
  }
}
