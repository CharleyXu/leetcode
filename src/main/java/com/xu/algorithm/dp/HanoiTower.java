package com.xu.algorithm.dp;

/**
 * @author charlie Created on 2018/2/12.
 *
 * 汉诺塔算法	递归
 *
 * A上有n个盘子
 *
 * 如果n=1，则将圆盘从A直接移动到C。
 *
 * 如果n=2，则：
 *
 * （1）将A上的第n-1（等于1）个圆盘移到B上；
 *
 * （2）再将A上的一个圆盘移到C上；
 *
 * （3）最后将B上的第n-1（等于1）个圆盘移到C上。
 *
 *
 * 当n大于等于2时， 移动的过程可分解为三个步骤：
 *
 * 第一步 把A上的第n-1个圆盘移到B上；第二步 把A上的一个圆盘移到C上；第三步 把B上的第n-1个圆盘移到C上；其中第一步和第三步是类同的。
 *
 * 当n=3时，第一步和第三步又分解为类同的三步，即把n’-1个圆盘从一个指针移到另一个指针上，这里的n`=n-1
 */
public class HanoiTower {

  public static void main(String[] args) {
    alogrRecursive(4, 'a', 'b', 'c');
    System.out.println(alogrRecursive(4));
  }

  //移动的次数
  static long count;

  /**
   * 汉诺塔算法,将盘子从a移动到c
   *
   * @param n 盘子数目
   * @param a 柱子标识From
   * @param b 柱子标识Helper
   * @param c 柱子标识To
   */
  public static void alogrRecursive(int n, char a, char b, char c) {
    if (n == 1) {
      System.out.printf("第%d次移动：\t%c->%c\n", ++count, a, c);
      return;
    } else {
      alogrRecursive(n - 1, a, c, b);
      System.out.printf("第%d 次移动：\t%c->%c\n", ++count, a, c);
      alogrRecursive(n - 1, b, a, c);
    }
  }

  public static int alogrRecursive(int n) {
    if (n == 1) {
      return 1;
    } else {
      return 2 * alogrRecursive(n - 1) + 1;
    }
  }

}
