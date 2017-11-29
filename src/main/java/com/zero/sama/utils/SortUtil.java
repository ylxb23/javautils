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
		int len;
		if(arr == null || (len=arr.length) < 2) {
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
		int len;
		if(arr == null || (len=arr.length) < 2) {
			return;
		}
		for(int i=1; i<len; i++) {
			T current = arr[i];
			int j = i-1;
			while(j>-1 && current.compareTo(arr[j]) < 0) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[i] = current;
		}
	}
	
	/**
	 * 获取边界索引
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
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
	 * 堆排序
	 * @param arr
	 */
	public static <T extends Comparable<T>> void heapSort(T[] arr) {
		buildHeap(arr);
		for(int i=arr.length-1; i>0; i--) {
			T temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			heapAdjust(arr, 0, i);
		}
	}
	
	/**
	 * 初始堆进行调整
	 * 将H[0..length-1]建成堆
	 * 调整完之后第一个元素是序列的最小的元素
	 * @param arr
	 */
	private static <T extends Comparable<T>> void buildHeap(T[] arr) {
		int length = arr.length;
		// 最后一个有孩子的节点的位置 i=  (length -1) / 2
		for(int i=(length - 1) / 2; i>=0; i--) {
			heapAdjust(arr, i, length);
		}
	}
	/**
	 * 已知H[s…m]除了H[s] 外均满足堆的定义
	 * 调整H[s],使其成为大顶堆.即将对第s个结点为根的子树筛选
	 * 
	 * @param arr
	 * @param s		待调整的元素位置
	 */
	private static <T extends Comparable<T>> void heapAdjust(T[] arr, int s, int length) {
		T temp = arr[s];	// 
		int child = 2*s + 1;	// 左孩子节点的位置
		while(child < length) {
			// 如果右孩子大于左孩子(找到比当前待调整结点大的孩子结点)
			if(child+1 < length && arr[child].compareTo(arr[child+1]) < 0) {
				child++;
			}
			if(arr[s].compareTo(arr[child]) < 0) {
				arr[s] = arr[child];
				s = child;
				child = 2*s + 1;
			} else {
				break;
			}
			arr[s] = temp;
		}
	}

	/**
	 * 数组打印
	 * 
	 * @param arr
	 */
	public static <T> void display(T[] arr) {
		int len;
		if(arr == null || (len=arr.length) < 1) {
			return;
		}
		for(int i=0; i<len; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
}
