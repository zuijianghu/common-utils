package net.vlaba.util.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EntityBuildUtil {
	
	private static final int CREATE_STRING_LENGTH = 4;
	private static final String CREATE_STRING_TEMPLATE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static <T> T randomEnitiy(Class<T> clazz) {
		T newInstance = null;
		try {
			newInstance = clazz.newInstance();
			Method[] methods = clazz.getMethods();
			for (Method method : methods) {
				if (method.getName().startsWith("get") && !method.getName().equals("getClass")) {
					String setMethodName = "set" + method.getName().substring(3);
					Class<?> returnType = method.getReturnType();
					Object value = createRandomValueByResultType(returnType);
					ReflectionUtils.invokeMethod(newInstance, setMethodName, new Class<?>[]{returnType}, new Object[]{value});
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return newInstance;
		}
		return newInstance;
	}
	
	public static <T> List<T> randomEntityList(Class<T> clazz, int size) {
		List<T> list = new ArrayList<T>();
		try {
			for (int i = 0; i < size; i++) {
				T newInstance = clazz.newInstance();
				Method[] methods = clazz.getMethods();
				for (Method method : methods) {
					if (method.getName().startsWith("get") && !method.getName().equals("getClass")) {
						String setMethodName = "set" + method.getName().substring(3);
						Class<?> returnType = method.getReturnType();
						Object value = createRandomValueByResultType(returnType);
						ReflectionUtils.invokeMethod(newInstance, setMethodName, new Class<?>[]{returnType}, new Object[]{value});
					}
				}
				list.add(newInstance);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		}
		return list;
	}
	
	private static Object createRandomValueByResultType(Class<?> returnType) {
		Object result = null;
		if (returnType == String.class) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < CREATE_STRING_LENGTH; i++) {
				sb.append(CREATE_STRING_TEMPLATE.charAt((int) (Math.random() * (CREATE_STRING_TEMPLATE.length() - 1))));
			}
			result = sb.toString();
		} else if (returnType == Byte.class) {
			result = (byte) (Math.random() * 100);
		} else if (returnType == Short.class) {
			result = (short) (Math.random() * 100);
		} else if (returnType == Integer.class) {
			result = (int) (Math.random() * 100);
		} else if (returnType == Long.class) {
			result = (long) (Math.random() * 100);
		} else if (returnType == Double.class) {
			result = (double) (Math.random() * 100);
		} else if (returnType == Float.class) {
			result = (float) (Math.random() * 100);
		} else if (returnType == Boolean.class) {
			boolean[] booleanArr = {true, false};
			result = booleanArr[(int) (Math.random() * 2)];
		} else if (returnType == Date.class) {
			result = new Date();
		} else {
			// 枚举类
			Object[] enums = returnType.getEnumConstants();
			result = enums[(int) (Math.random() * enums.length)];
		}
		return result;
	}
	
}
