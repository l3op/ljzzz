package com.yy.game.ljzzz.common;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HMacSHA1Test {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void signatureByteArrayByteArray() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void signatureStringString() throws Exception {
		String auth = "KEY123456789";
		String signature = HMacSHA1.signature("13778000zhyxhd21843290813880539986253232717", auth);
		assertEquals("02a013a26f257a5e3163644de8e0f6d71e1e30b6", signature);
	}

}
