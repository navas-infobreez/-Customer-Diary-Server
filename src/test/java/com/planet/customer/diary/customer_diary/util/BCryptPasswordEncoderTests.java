package com.planet.customer.diary.customer_diary.util;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.planet.customer.diary.customer_diary.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BCryptPasswordEncoderTests {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserService userService;

	@Before
	public void init() {

	}

	@Test
	public void checkAllUserPasswordsAreSameAsUsernames() {
		userService.findAll().forEach(user -> {
			final String encodedValue = passwordEncoder.encode(user.getUserName());
			final String userPassword = user.getUserName();
			System.out.println(user);
			System.out.println("Password : " + encodedValue);
			assertTrue("Passwords match", userPassword.equals(userPassword));
		});
	}

}
