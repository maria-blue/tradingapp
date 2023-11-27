package com.example.tradingapp.controller;

import java.util.List;

import com.example.tradingapp.model.Security;
import com.example.tradingapp.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

  @Autowired
  SecurityService securityService;

  @GetMapping("/security")
  private List<Security> getAllSecurities() {
    return securityService.getAllSecurities();
  }

  @GetMapping("/security/{securityid}")
  private Security getSecurity(@PathVariable("securityid") int securityid) {
    return securityService.findById(securityid);
  }

  @DeleteMapping("/security/{securityid}")
  private void deleteSecurity(@PathVariable("securityid") int securityid) {
    securityService.delete(securityid);
  }

  @PostMapping("/security")
  private int saveSecurity(@RequestBody Security security) {
    securityService.saveOrUpdate(security);
    return security.getId();
  }

  @PutMapping("/security")
  private Security update(@RequestBody Security security) {
    securityService.saveOrUpdate(security);
    return security;
  }
}
