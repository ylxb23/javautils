package com.zero.sama.utils;

/**
 * 排序算法锦集
 * 
 * @date 2017年10月26日 下午2:35:07
 * @author zero
 */
public abstract class SortUtil {
	
	/**
	 * 冒泡排序
	 * 
	 * @param arr
	 */
	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
		int len = arr.length;
		if(arr == null || len < 2) {
			return;
		}
		for(int i=0; i<len; i++) {
			for(int j=i+1; j<len; j++) {
				if(arr[i].compareTo(arr[j]) > 0) {
					T temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}
	
	/**
	 * 快速排序:
	 * 通过一趟排序将要排序的数据分割成独立的两部分，
	 * 其中一部分的所有数据都比另外一部分的所有数据都要小，
	 * 然后再按此方法对这两部分数据分别进行快速排序，
	 * 整个排序过程可以递归进行，以此达到整个数据变成有序序列。
	 * 
	 * @param arr
	 */
	public static <T extends Comparable<T>> void quickSort(T[] arr, int start, int end) {
		if(start >= end) {
			return;
		}
		int boundary = getBoundary(arr, start, end);
		
		quickSort(arr, start, boundary - 1);
		quickSort(arr, boundary + 1, end);
	}
	
	/**
	 * 插入排序:
	 * 索引从1开始假设前面的数组都是有序的，遍历将有序数组后的元素插入到有序数组中。
	 * 
	 * @param arr
	 */
	public static <T extends Comparable<T>> void insertSort(T[] arr) {
		int len = arr.length;
		if(arr == null || len < 2) {
			return;
		}
		for(int i=1; i<len; i++) {
			T current = arr[i];
			int j = i-1;
			while(j>-1 && current.compareTo(arr[j]) < 0) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = current;
		}
	}
	
	private static <T extends Comparable<T>> int getBoundary(T[] arr, int start, int end) {
		T flag = arr[start];
		while(start < end) {
			while(start < end && arr[end].compareTo(flag) >= 0) {
				end--;
			}
			arr[start] = arr[end];
			while(start < end && flag.compareTo(arr[start]) >= 0) {
				start++;
			}
			arr[end] = arr[start];
		}
		arr[end] = flag;
		return start;
	}

	/**
	 * 数组打印
	 * 
	 * @param arr
	 */
	public static <T> void display(T[] arr) {
		if(arr == null || arr.length < 1) {
			return;
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
}
