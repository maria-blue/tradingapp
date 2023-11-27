package com.example.tradingapp.repository;

import com.example.tradingapp.model.Trade;
import org.springframework.data.repository.CrudRepository;

public interface TradeRepository extends CrudRepository<Trade, Integer> {

}
