package edu.drexel.se320;

import edu.drexel.se320.Combination;

// Hamcrest
import static org.hamcrest.MatcherAssert.assertThat;

// Core JUnit 5
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import org.checkerframework.common.value.qual.IntRangeFromPositive;
import org.junit.jupiter.api.Test;

// Jqwik
import net.jqwik.api.*;
import net.jqwik.api.constraints.*;

public class CombinationTest {
    /**
     * This unit test used assertEquals() to test the actual value is equal expected value
     */
    @Test
    public void assertTest1() {
        int expected = 1;
        int actual = Combination.combination(0, 0);
        assertEquals(expected, actual);
    }

    /**
     * This unit test used assertEquals() to test the actual value is equal expected value
     */
    @Test
    public void assertTest2() {
        int expected = 126;
        int actual = Combination.combination(9, 4);
        assertEquals(expected, actual);
    }

    /**
     * This unit test used matcher statement asserThat() to test the value (first argument) is match
     * with matcher statement (second argument)
     */
    @Test
    public void matcher1() {
        assertThat(Combination.combination(9,8), is(9));
    }

    /**
     * This unit test used matcher statement asserThat() to test the value (first argument) is match
     * with matcher statement (second argument)
     */
    @Test
    public void matcher2() {
        assertThat(Combination.combination(9,8), is(not(equalTo(19))));
    }

    /**
     * This unit test used assertThrows() to test the IllegalArgumentException exception
     */
    @Test
    public void testExceptions1() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Combination.combination(-1,-5));
        assertEquals("Error: both n and k are negative value", exception.getMessage());
    }

    /**
     * This unit test used assertThrows() to test the IllegalArgumentException exception
     */
    @Test
    public void testExceptions2() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Combination.combination(-1,5));
        assertEquals("Error: the value of n is less than 0", exception.getMessage());
    }

    @Property
    public void propertyTest1(@ForAll @IntRange(min = 1, max = 10) int x, @ForAll @IntRange(min = 11, max = 20)  int y) {
        assertThat(Combination.combination(x,y), greaterThanOrEqualTo(0));

    }

    @Property
    public void propertyTest2(@ForAll @IntRange(min = 0, max = 20) int x, @ForAll @IntRange(min = 21, max = 40)  int y) {
        assertTrue(Combination.combination(x,y) >= 0);

    }

}

