package com.example.tradingapp.repository;

import com.example.tradingapp.model.TradingUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<TradingUser, Integer> {

}
