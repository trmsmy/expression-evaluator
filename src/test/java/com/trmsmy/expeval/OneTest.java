package com.trmsmy.expeval;

import org.junit.Test;

public class OneTest {

	@Test
	public void testSimpleStringExpressionWithString() {

		String x = "'b'", y = "0", z = "0";
		Expression e = new Expression("x = 'a' && (y = 'b' || z = 0 ) ");

		//[a, a, =, y, b, =, z, 0, =, ||, &&],
		
		e.with("x", x).with("y", y).with("z", z);
		System.out.println(e.eval());
		System.out.println(e.tokenExp());
		//assertEquals("Result must be 1", 1, stack);
/*
		for (SubExp ln : stack) {
			System.out.println(ln);
			System.out.println(ln.getLeft());
			System.out.println(ln.getRight());
			System.out.println(ln.getOp());
			Operand<?> eval = ln.eval();
			System.out.println(eval);
		}
		
*/
	}
}

