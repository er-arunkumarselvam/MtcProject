package com.example.demo;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;

import io.jsonwebtoken.Jwts;
import jakarta.xml.bind.DatatypeConverter;

public class JwtSecretKeyMaker {
	
	@Test
	public void generateSecretKey()
	{
		SecretKey Key = Jwts.SIG.HS512.key().build();
		String encoderKey = DatatypeConverter.printHexBinary(Key.getEncoded());
		System.out.println("key in String --> " + encoderKey );
		System.out.println("Key in SecretKey -->" + Key);
	}

}

