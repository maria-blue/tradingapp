package com.example.tradingapp;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.example.tradingapp.model.Security;
import com.example.tradingapp.model.TradingUser;
import com.example.tradingapp.service.OrderService;
import com.example.tradingapp.service.SecurityService;
import com.example.tradingapp.service.TradeService;
import com.example.tradingapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TradingApplicationTests {

  @Autowired
  OrderService orderService;
  @Autowired
  TradeService tradeService;
  @Autowired
  UserService userService;
  @Autowired
  SecurityService securityService;

  @Test
  void testUserStory() throws NoSuchAlgorithmException, InvalidKeySpecException {
    // Given
    Security security = new Security();
    security.setName("WSB");
    securityService.saveOrUpdate(security);
    TradingUser diamond = new TradingUser();
    diamond.setUsername("Diamond");
    diamond.setPassword("Diamond123");
    userService.saveOrUpdateUser(diamond);
    TradingUser paper = new TradingUser();
    paper.setUsername("Paper");
    paper.setPassword("Paper1234");
    userService.saveOrUpdateUser(paper);

    // When
    //orderService.buyOrder(diamond, wsb, 101, 50);
    //tradingService.sellAnOrder(paper, wsb, 100, 100);

    // Then
  }

  private byte[] generatePasswordHash(String password)
      throws NoSuchAlgorithmException, InvalidKeySpecException {
    SecureRandom random = new SecureRandom();
    byte[] salt = new byte[16];
    random.nextBytes(salt);
    KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    return factory.generateSecret(spec).getEncoded();
  }
}
