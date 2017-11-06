package com.zero.sama.utils;

import java.io.Serializable;

import org.testng.annotations.Test;

/**
 * 
 * @date 2017年11月6日 上午11:34:22
 * @author zero
 */
public class CopyUtilTest {
	
	@Test
	public void testSpend() {
		Student s = new Student("zero", 21);
		long start1 = System.currentTimeMillis();
		int n = 10000;
		for(int i=0; i<n; i++) {
			CopyUtil.clone(s);
		}
		System.out.println("clone spend: " + (System.currentTimeMillis()-start1) + "ms");
		long start2 = System.currentTimeMillis();
		for(int i=0; i<n; i++) {
			CopyUtil.clonePro(s);
		}
		System.out.println("clonePro spend: " + (System.currentTimeMillis()-start2) + "ms");
	}
	
	static class Student implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String name;
		int age;
		public Student(String n, int a) {
			name = n;
			age = a;
		}
		@Override
		public String toString() {
			return "name=" + name + ", age=" + age;
		}
	}
	
}
