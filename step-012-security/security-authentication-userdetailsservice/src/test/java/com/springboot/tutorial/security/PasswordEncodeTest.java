package com.springboot.tutorial.security;

import com.springboot.tutorial.security.business.service.CustomPasswordEncoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordEncodeTest {

	@Autowired
	private CustomPasswordEncoder encoder;


	@Test
	public void contextLoads() {
		String password = encoder.encode("admin");
		System.out.println("password = " + password);
	}

}
