package com.zero.sama.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象克隆工具
 * @date 2017年11月6日 上午10:44:35
 * @author zero
 */
public class CopyUtil {
	
	/**
	 * 深度复制
	 * @param source
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T clone(T source) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(source);
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			return (T)ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
}
