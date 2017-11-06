package com.zero.sama.utils;

import java.util.Collections;
import java.util.List;

/**
 * 集合类型工具类
 * @date 2017年10月30日 下午4:20:18
 * @author zero
 */
public class CollectionUtil {
	
	
	/**
	 * The same with {@linkplain Collections#indexOfSubList(List, List)}
	 * @param source
	 * @param target
	 * @return
	 */
	public static <T> int indexOfSubList(List<T> source, List<T> target) {
		int sourceSize = source.size();
		int targetSize = target.size();
		int maxCandidate = sourceSize - targetSize;
		nextCand:
			for(int candidate = 0; candidate <= maxCandidate; candidate++) {
				for(int i=0, j=candidate; i<targetSize; i++, j++) {
					if(!source.get(j).equals(target.get(i))) {
						continue nextCand;
					}
				}
				return candidate;
			}
		return -1;
	}
	
}
