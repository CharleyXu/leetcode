package com.xu.base;


import org.junit.Assert;
import org.junit.Test;


/**
 * Java is Pass by Value and Not Pass by Reference
 */
public class ReferenceTest {
//	//exp1
//	public void badSwap(Object var1, Object var2) {
//		Object temp = var1;
//		var1 = var2;
//		var2 = temp;
//	}
//
//	@Test
//	public void swapValueTest() {
//		int var1 = 10;
//		int var2 = 100;
//		badSwap(var1, var2);
//		System.out.println(var1 + " " + var2);
//	}
//
//	//exp2
//	public void tricky(Point arg1, Point arg2) {
//		arg1.x = 100;
//		arg1.y = 100;
//		Point temp = arg1;
//		arg1 = arg2;
//		arg2 = temp;
//	}

//	@Test
//	public void trickyTest() {
//		Point pnt1 = new Point(0, 0);
//		Point pnt2 = new Point(0, 0);
//		System.out.println("X: " + pnt1.x + " , Y: " + pnt1.y);
//		System.out.println("X: " + pnt2.x + " , Y: " + pnt2.y);
//		tricky(pnt1, pnt2);
//		System.out.println("X: " + pnt1.x + " , Y:" + pnt1.y);
//		System.out.println("X: " + pnt2.x + " , Y: " + pnt2.y);
//
//
//		People p1 = new People();
//		p1.setName("old");
//		People p2 = p1 ;
//		p1 = new People();
//		p1.setName("new");
//		System.out.println("p1 :"+p1.getName() + "\t\n" +"p2 : "+ p2.getName());
//	}

//	static class Point {
//		private int x;
//		private int y;
//
//		public Point() {
//		}
//
//		public Point(int x, int y) {
//			this.x = x;
//			this.y = y;
//		}
//	}

  //exp3
  public void modify(int a) {
    System.out.println(a);
  }

  @Test
  public void modifyTest() {
    int a = 10;
    modify(a);
    Assert.assertEquals(10, a);

  }

  //exp4
//	@Test
//	public void swapObjectTest() {
//		People amy = new People("amy");
//		People kate = new People("kate");
//
//		badSwap(amy, kate);
//		System.out.println(amy.getName() + "" + kate.getName());
//		fool(kate);
//		System.out.println(kate.getName());
//	}

  public void fool(People people) {
    people.setName("changed");
  }

  static class People {

    private String name;

    private People(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
  /**
   * Java中赋值都是值赋值。
   *	将一个对象类型的引用s1赋值给另一个对象类型的引用s2，
   *	就是将这个对象类型的引用s1的值（对象地址）赋值给s2。
   *
   * 简而言之，将一个变量赋值给另一个变量，这两个变量没有任何直接关系。
   * 进一步讲是将一个变量的副本赋值给了另一个变量。（这里所讲的副本是为了区分c语言中的地址）
   *
   *
   */
}
