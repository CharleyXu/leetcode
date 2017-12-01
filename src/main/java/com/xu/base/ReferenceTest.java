package com.xu.base;


import org.junit.Assert;
import org.junit.Test;


/**
 * Java is Pass by Value and Not Pass by Reference
 */
public class ReferenceTest {
	//exp1
	public void badSwap(Object var1, Object var2) {
		Object temp = var1;
		var1 = var2;
		var2 = temp;
	}

	@Test
	public void swapValueTest() {
		int var1 = 10;
		int var2 = 100;
		badSwap(var1, var2);
		System.out.println(var1 + " " + var2);
	}

	//exp2
	public void tricky(Point arg1, Point arg2) {
		arg1.x = 100;
		arg1.y = 100;
		Point temp = arg1;
		arg1 = arg2;
		arg2 = temp;
	}

	@Test
	public void trickyTest() {
		Point pnt1 = new Point(0, 0);
		Point pnt2 = new Point(0, 0);
		System.out.println("X: " + pnt1.x + " , Y: " + pnt1.y);
		System.out.println("X: " + pnt2.x + " , Y: " + pnt2.y);
		tricky(pnt1, pnt2);
		System.out.println("X: " + pnt1.x + " , Y:" + pnt1.y);
		System.out.println("X: " + pnt2.x + " , Y: " + pnt2.y);
	}

	class Point {
		private int x;
		private int y;

		public Point() {
		}

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	//exp3
	public void modify(int a) {
		a++;
	}

	@Test
	public void modifyTest() {
		int a = 10;
		modify(a);
		Assert.assertEquals(10, a);

	}

	//exp4
	@Test
	public void swapObjectTest() {
		People amy = new People("amy");
		People kate = new People("kate");

		badSwap(amy, kate);
		System.out.println(amy.getName() + "" + kate.getName());
		fool(kate);
		System.out.println(kate.getName());
	}

	public void fool(People people) {
		people.setName("changed");
		people = new People("neo");
		people.setName("wolf");
	}

	class People {
		private String name;

		public People() {
		}

		public People(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
