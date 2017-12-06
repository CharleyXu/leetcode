package com.xu.base;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test2 {
	public static Map<Long,Integer> map = new ConcurrentHashMap<Long, Integer>();

	public static void run(){
		map.put(1L,11);
		map.put(2L,22);
		map.put(3L,33);
		map.put(4L,44);
	}

}
