package com.example.tradingapp.service;

import java.util.ArrayList;
import java.util.List;

import com.example.tradingapp.model.Security;
import com.example.tradingapp.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

  @Autowired
  SecurityRepository securityRepository;

  public List<Security> getAllSecurities() {
    List<Security> securities = new ArrayList<>();
    securityRepository.findAll().forEach(securities::add);
    return securities;
  }

  public Security findById(int id) {
    return securityRepository.findById(id).orElseThrow();
  }

  public void saveOrUpdate(Security security) {
    securityRepository.save(security);
  }

  public void delete(int id) {
    securityRepository.deleteById(id);
  }

}
