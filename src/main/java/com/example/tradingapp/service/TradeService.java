package com.example.tradingapp.service;

import com.example.tradingapp.model.Trade;
import com.example.tradingapp.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeService {

  @Autowired
  TradeRepository tradeRepository;

  public Trade createTrade(Trade trade) {
    return tradeRepository.save(trade);
  }

  public Trade findById(int id) {
    return tradeRepository.findById(id).orElseThrow();
  }

  public void deleteTrade(Trade trade) {
    tradeRepository.delete(trade);
  }

}
