package com.xu.base;


import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Test2.run();
		Map<Long, Integer> policyThread = Test2.map;
		System.out.println("123 " + policyThread);

		System.out.println("123 " + policyThread);
		System.out.println("123 " + Test2.map);

		Unsafe unsafe = getUnsafe();
		System.out.println("policyThread address : " + addressOf(unsafe, policyThread));
		System.out.println("Test2.map address :" + addressOf(unsafe, Test2.map));

//		System.out.println("transObject address:" + addressOf(unsafe, transObject(Test2.map)));

		System.out.println("arr address:" + addressOf(unsafe, new int[]{1, 2, 3}));
	}

//	public static Object transObject(Object obj){
//		Object returnObj = new Object();
//		returnObj = obj;
//		return returnObj;
//	}

	public static Unsafe getUnsafe() {
		try {
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			return (Unsafe) field.get(null);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static long addressOf(Unsafe unsafe, Object o) {
		Object[] array = new Object[]{o};

		long baseOffset = unsafe.arrayBaseOffset(Object[].class);
		int addressSize = unsafe.addressSize();
		long objectAddress;
		switch (addressSize) {
			case 4:
				objectAddress = unsafe.getInt(array, baseOffset);
				break;
			case 8:
				objectAddress = unsafe.getLong(array, baseOffset);
				break;
			default:
				throw new Error("unsupported address size: " + addressSize);
		}
		return (objectAddress);
	}


}
