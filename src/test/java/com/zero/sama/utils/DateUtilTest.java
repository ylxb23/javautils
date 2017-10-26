package com.zero.sama.utils;

import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Test case for {@link #DateUtil}
 * @date 2017年10月26日 下午5:30:28
 * @author zero
 */
public class DateUtilTest {
	
	@BeforeTest
	public void statement() {
		System.out.println("start test case for {@link #DateUtil}.");
	}
	
	@Test
	public void test() {
		String text = "2017-10-26 11:16:59";
		Date date = DateUtil.parse(text, DateUtil.DATE_TIME_PATTERN_yyyy_MM_dd_HH_mm_ss);
		Assert.assertEquals(text, DateUtil.format(date));
	}
	
	private Date getTestDateTime() {
		Calendar c = Calendar.getInstance();
		c.set(2017, 9, 26, 11, 16, 59);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	
	@Test
	public void testFormat() {
		Date date = getTestDateTime();
		String formatted = DateUtil.format(date, DateUtil.DATE_TIME_PATTERN_yyyy_MM_dd_HH_mm_ss);
		Assert.assertEquals(formatted, "2017-10-26 11:16:59");
	}
}
