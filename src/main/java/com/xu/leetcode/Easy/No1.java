package com.xu.leetcode.Easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class No1 {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap();
		for(int i=0,length=nums.length;i<length;i++){
			if(map.get(nums[i])!=null){
				return new int[] {map.get(nums[i]),i};
			}
			map.put((target-nums[i]),i);
		}
		return new int [] {};
	}

	@Test
	public void test(){
		int[] ints = twoSum(new int[]{3, 5, 7, 1}, 12);
		Assert.assertArrayEquals(new int[]{1,2},ints);
	}

}
