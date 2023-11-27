package com.example.tradingapp;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.example.tradingapp.model.Security;
import com.example.tradingapp.model.TradingUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TradingappApplicationTests {

	@Test
	void contextLoads() {

	}


	private Security createSecurity(String name) {
		Security security = new Security();
		security.setName("WSB");
		return securityService.createSecurity(security);
	}

	private TradingUser createUser(String username, String password)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		TradingUser tradingUser = new TradingUser();
		tradingUser.setUsername(username);
		tradingUser.setPassword(generatePasswordHash(password));
		return userService.createUser(tradingUser);
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
