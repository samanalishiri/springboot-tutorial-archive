package com.springboot.tutorial.step005;

import com.springboot.tutorial.step005.business.service.CustomPasswordEncoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Step005ApplicationTests {

	@Autowired
	private CustomPasswordEncoder encoder;


	@Test
	public void contextLoads() {
		String password = encoder.encode("password");
		System.out.println("password = " + password);
	}

}
