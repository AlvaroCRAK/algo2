package algo2.semana01.intro;

import static org.junit.Assert.*;
import org.junit.Test;

public class FactorialTest {

  @Test
  public void testFactorialDe0() {
    assertEquals(1, Factorial.factorial(0));
  }

  @Test
  public void testFactorialDe1() {
    assertEquals(1, Factorial.factorial(1));
  }

  @Test
  public void testFactorialDe5() {
    assertEquals(120, Factorial.factorial(5));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFactorialNegativo() {
    Factorial.factorial(-3);
  }
}
