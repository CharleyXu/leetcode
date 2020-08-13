package com.xu.algorithm.structure.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by CharleyXu on 2020-06-17
 * <p>
 * 合并区间
 */
public class MergeSpace {

    /**
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6]
     * <p>
     * 先对start进行排序，再合并的过程
     */
    public int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
//        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (list.size() == 0 || list.getLast()[1] < intervals[i][0]) {
                list.add(intervals[i]);//集合为空，或不满足条件，向后新增
            } else {//满足条件，集合最后元素的end=最大值
                list.getLast()[1] = Math.max(list.getLast()[1], intervals[i][1]);
            }
        }
        int[][] res = new int[list.size()][2];//生成结果数组
        int index = 0;
        while (!list.isEmpty()) {//遍历集合
            res[index++] = list.removeFirst();//删除集合首元素
        }
        return res;
    }

}
