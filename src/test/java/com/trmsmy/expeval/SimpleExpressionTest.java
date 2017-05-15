package com.trmsmy.expeval;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class SimpleExpressionTest {

    private boolean testOne = false;

    @Test
    public void testSimpleStringExpression() {
        
        if(testOne) return;
        
        String x = "1", y = "0", z = "0";
        Expression e = new Expression("x = 0 && (y = 0 || z = 0 ) ");

        e.with("x", x).with("y", y).with("z", z);
        assertEquals("Result must be 0", 0, e.eval().intValue());

    }

    @Test
    public void testSimpleStringExpression2() {
        
        if(testOne) return; 
        
        String x = "0", y = "0", z = "0";
        Expression e = new Expression("x = 0 && (y = 0 || z = 0 ) ");

        e.with("x", x).with("y", y).with("z", z);
        assertEquals("Result must be 1", 1, e.eval().intValue());

    }

    @Test
    public void testSimpleStringExpressionWithString() {
        
        if(testOne) return; 
        
        String x = "a", y = "0", z = "0";
        Expression e = new Expression("x = 'a' && (y = 'b' || z = 0 ) ");

        e.with("x", x).with("y", y).with("z", z);
        assertEquals("Result must be 1", 1, e.eval().intValue());

    }
    
    @Test
    public void testSimpleStringExpressionWithString2() {
        
        if(testOne) return; 
        
        String x = "a", y = "0", z = "0";
        Expression e = new Expression("x = 'a' && (y = 'b' || z = 0 ) ");

        e.with("x", x).with("y", y).with("z", z);
        assertEquals("Result must be 1", 1, e.eval().intValue());

    }
    
    @Test
    public void testSimpleStringExpressionWithString3() {
        
        if(testOne) return; 
        
        String x = "a", y = "0", z = "c";
        Expression e = new Expression("x = 'a' && (y = 'b' || z = 0 ) ");

        e.with("x", x).with("y", y).with("z", z);
        assertEquals("Result must be 0", 0, e.eval().intValue());

    }
    
    @Test
    public void testSimpleStringExpressionWithString4() {
        
        if(testOne) return; 
        
        String x = "FIRST", y = "LAST";
        Expression e = new Expression("firstName = 'FIRST' && lastName = 'LAST'");
        e.with("firstName", x).with("lastName", y);
        assertEquals("Result must be 1", 1, e.eval().intValue());

    }

    //TODO Provide support for space in string 
    @Test
    @Ignore
    public void testSimpleStringExpressionWithString5() {
        
        if(testOne) return; 
        
        String x = "FIRST LASTNAME", y = "MALE";
        Expression e = new Expression("fullName = 'FIRST LASTNAME' && gender = 'MALE'");
        e.with("fullName", x).with("gender", y);
        assertEquals("Result must be 0", 1, e.eval().intValue());

    }

    
    @Test
    @Ignore
    //TODO Implement the functionality
    public void testSimpleStringExpressionList() {
        
        if(testOne) return; 
        
        String x = "FIRST", y = "LAST";
        Expression e = new Expression("fullName = 'FIRST' + 'LAST'");
        e.with("fullName", x+y);
        assertEquals("Result must be 1", 1, e.eval().intValue());

    }
    
    
    
    @Test
    public void test_IN_Operator() {
    	
    	// if(testOne) return; 
    	
        Expression expression = new Expression("m IN(1,2,3,40)");
        expression.with("m", "40");
        assertEquals("1", expression.eval().toPlainString());
    }
    
}
