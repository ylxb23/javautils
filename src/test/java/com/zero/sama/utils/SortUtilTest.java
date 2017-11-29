package com.zero.sama.utils;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Test case for {@link #SortUtil}
 * @date 2017年10月26日 下午5:18:58
 * @author zero
 */
public class SortUtilTest {

	
	@BeforeTest
	public void statement() {
		System.out.println("start test case for SortUtil.");
	}

	@Test
	public void testBubbleSort() {
		int times = 100;
		Integer[] arr = {3,2,4,1,6,9,5,8,7,0};
		SortUtil.display(arr);
		long start = System.currentTimeMillis();
		for(int i=0; i<=times; i++) {
			SortUtil.bubbleSort(arr);
		}
		long end = System.currentTimeMillis();
		Assert.assertEquals(arr, new Integer[] {0,1,2,3,4,5,6,7,8,9});
		SortUtil.display(arr);
		System.out.printf("bubble sort %d times spend %d ms. \n", times, (end - start));
	}
	
	@Test
	public void testQuickSort() {
		int times = 100;
		Integer[] arr = {3,2,4,1,6,9,5,8,7,0};
		SortUtil.display(arr);
		long start = System.currentTimeMillis();
		for(int i=0; i<=times; i++) {
			SortUtil.quickSort(arr, 0, arr.length-1);
		}
		long end = System.currentTimeMillis();
		SortUtil.display(arr);
		Assert.assertEquals(arr, new Integer[] {0,1,2,3,4,5,6,7,8,9});
		System.out.printf("quick sort %d times spend %d ms. \n", times, (end - start));
	}
	
	@Test
	public void testInsertSort() {
		int times = 100;
		Integer[] arr = {3,2,4,1,6,9,5,8,7,0};
		SortUtil.display(arr);
		long start = System.currentTimeMillis();
		for(int i=0; i<=times; i++) {
			SortUtil.insertSort(arr);
		}
		long end = System.currentTimeMillis();
		SortUtil.display(arr);
		Assert.assertEquals(arr, new Integer[] {0,1,2,3,4,5,6,7,8,9});
		System.out.printf("insert sort %d times spend %d ms. \n", times, (end - start));
	}
	
	@Test
	public void testHeapSort() {
		int times = 100;
		Integer[] arr = {3,2,4,1,6,9,5,8,7,0};
		SortUtil.display(arr);
		long start = System.currentTimeMillis();
		for(int i=0; i<=times; i++) {
			SortUtil.heapSort(arr);
		}
		long end = System.currentTimeMillis();
		SortUtil.display(arr);
		Assert.assertEquals(arr, new Integer[] {0,1,2,3,4,5,6,7,8,9});
		System.out.printf("heap sort %d times spend %d ms. \n", times, (end - start));
	}
}
