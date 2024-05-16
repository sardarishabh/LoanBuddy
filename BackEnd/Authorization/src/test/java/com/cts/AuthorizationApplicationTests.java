package com.cts;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.authorization.AuthorizationApplication;

/**
 * Test - AuthServiceApplication
 */
@SpringBootTest
public class AuthorizationApplicationTests {

	@Test
	public void appplicationStarts() throws IOException {
		AuthorizationApplication.main(new String[] {});
		assertTrue(true);
	}
}
