package com.yanghui.study;

import org.junit.Test;

public class TestClass {

	@Test
	public void test1() {
		Integer i = 1;
		Object s = "sss";
		System.out.println(i.equals(1)); 
		boolean boo1 = (Object)1 instanceof Integer;
		boolean boo2 = (Object)1L instanceof Long;
		boolean boo3 = s instanceof Integer;
		System.out.println(boo1);
		System.out.println(boo2);
		System.out.println(boo3);
		long lala = 1;
		Long l = new Long(1);
		System.out.println(l.equals(1L));
		System.out.println(l.equals(lala));

		System.out.println(i.intValue()==1);
	}
}
