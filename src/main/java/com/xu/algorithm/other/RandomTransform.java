package com.xu.algorithm.other;

import java.util.Random;
import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/28.
 *
 * 随机数产生转换
 *
 * 根据(1,7)随机数生成器，生成(1,10)之内的随机数
 *
 * 如果a > b,那么一定可以用Rand a去实现Rand b
 *
 * 其中,Rand a表示等概率生成1到a的函数，Rand b表示等概率生成1到b的函数
 */
public class RandomTransform {

  /**
   * random(7)
   */
  public int random7() {
    Random random = new Random();
    return random.nextInt(7) + 1;
  }

  /**
   * random(10)
   */
  public int random10() {
    //(1,49)
    int res = 49;
    while (res > 40) {
      res = 7 * (random7() - 1) + random7();
    }
    return res % 10 + 1;
  }

  @Test
  public void randomTransferTest() {
    double size = 100000;
    int[] arr = new int[11];
    for (int i = 0; i < size; i++) {
      arr[random10()] += 1;
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i] + ",概率是" + (arr[i] / size));
    }
  }
}
