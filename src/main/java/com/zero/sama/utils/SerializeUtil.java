package com.zero.sama.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象序列化
 * @date 2017年12月3日 下午6:54:05
 * @author zero
 */
public class SerializeUtil {
	
	private SerializeUtil() {}
	
	/**
	 * 反序列化-将byte数组反序列化为Java对象
	 * @param json
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T parse(byte[] bytes, Class<T> clazz) {
		try(ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
				ObjectInputStream ois = new ObjectInputStream(bais);) {
			return (T) ois.readObject();
		} catch (Exception e) {
			throw new IllegalArgumentException("对象反序列化失败", e);
		}
	}
	
	/**
	 * 序列化-将Java对象序列化为byte数组
	 * @param obj
	 * @return
	 */
	public static <T> byte[] serialize(T obj) {
		try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(baos);) {
			oos.writeObject(obj);
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
