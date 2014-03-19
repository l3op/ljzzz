package com.yy.game.ljzzz.common;


import static org.junit.Assert.*;

import org.junit.Test;

public class ActivityUtilTest {

	@Test
	public void contains() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void remove() throws Exception {
		String content = "123,456,789";
		assertEquals("456,789", ActivityUtil.remove(content, "123"));
		assertEquals("123,789", ActivityUtil.remove(content, "456"));
		assertEquals("123,456", ActivityUtil.remove(content, "789"));
	}

}
