package algo2.semana01.intro;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculadorBinarioTest {
  private CalculadorBinario calculadora;

  @Before
  public void setUp() {
    calculadora = new CalculadorBinario();
  }

  @Test
  public void testOperacionAnd() {
    calculadora.setOp1(5);
    calculadora.setOp2(3);
    calculadora.setOperando("AND");

    String resultado = calculadora.getResultado();

    assertEquals("1", resultado);
  }

  @Test
  public void testOperacionOr() {
    calculadora.setOp1(5);
    calculadora.setOp2(3);
    calculadora.setOperando("OR");

    String resultado = calculadora.getResultado();

    assertEquals("111", resultado);
  }

  @Test
  public void testOperacionXor() {
    calculadora.setOp1(5);
    calculadora.setOp2(3);
    calculadora.setOperando("XOR");

    String resultado = calculadora.getResultado();

    assertEquals("110", resultado);
  }

  @Test
  public void testOperacionNot() {
    calculadora.setOp1(5);
    calculadora.setOperando("NOT");

    String resultado = calculadora.getResultado();

    resultado = resultado.length() > 4 ? resultado.substring(resultado.length() - 4) : resultado;

    assertEquals("1010", resultado);
  }

  @Test
  public void testOperacionInvalida() {
    calculadora.setOp1(5);
    calculadora.setOp2(3);
    calculadora.setOperando("INVALID");

    String resultado = calculadora.getResultado();
    assertEquals("Operando no válido", resultado);
  }
}