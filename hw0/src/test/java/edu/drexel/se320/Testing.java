package edu.drexel.se320;

// Hamcrest
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.lessThan;

// Core JUnit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

// Jqwik
import net.jqwik.api.*;
import net.jqwik.api.constraints.*;

public class Testing {

    @Test
    public void testmin1() { assertEquals(0, 0); }

    @Test
    public void testshouldfail() {
        assertEquals(34, 34);
    }

    @Test
    public void matchStuff() {
        assertThat(0, is(0));

        assertThat(4, anyOf(is(9), is(4)));
    }

    @Test
    public void testExceptions() {
	Exception exception = assertThrows(UnsupportedOperationException.class,
			/* The bit between this and the next comment is a 
			 * *lambda expression*: https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#syntax
			 * If you've taken PL, this is Java's lambda.
			 * If not, this is like special syntax for a function object with one method.
			 * Notice the form is:
			 *   _args_ -> { body } */
			() -> { throw new UnsupportedOperationException("Bad jasdf;lkasdjlfk"); }
			/* end of lambda expression. The () at the beginning is the (empty)
			 * argument list of the lambda */
			); // <-- This is closing off the call to assertThrows
	// Here you can use any methods on the Exception type to inspect whether the right exception was thrown.
     	assertEquals("Bad Operation", exception.getMessage());   
    }

    @Property
    public void simpleProperty(@ForAll @IntRange(min=1, max=10) int x, @ForAll @IntRange(min=11, max=20) int y) {
	assertThat(y, lessThan(x));
    }

    
}

