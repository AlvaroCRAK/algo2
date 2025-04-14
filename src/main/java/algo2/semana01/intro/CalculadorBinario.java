package algo2.semana01.intro;

import java.util.Scanner;

public class CalculadorBinario {
  private int op1;
  private int op2;
  private String operando;

  public CalculadorBinario() {
  }

  // Constructor con parámetros
  public CalculadorBinario(int op1, int op2, String operando) {
    this.op1 = op1;
    this.op2 = op2;
    this.operando = operando;
  }

  // Métodos getter y setter
  public int getOp1() {
    return op1;
  }

  public void setOp1(int op1) {
    this.op1 = op1;
  }

  public int getOp2() {
    return op2;
  }

  public void setOp2(int op2) {
    this.op2 = op2;
  }

  public String getOperando() {
    return operando;
  }

  public void setOperando(String operando) {
    this.operando = operando;
  }

  public String getResultado() {
    switch (operando.toUpperCase()) {
      case "AND":
        return Integer.toBinaryString(op1 & op2);
      case "OR":
        return Integer.toBinaryString(op1 | op2);
      case "XOR":
        return Integer.toBinaryString(op1 ^ op2);
      case "NOT":
        return Integer.toBinaryString(~op1);
      default:
        return "Operando no válido";
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    CalculadorBinario calculadora = new CalculadorBinario();

    System.out.println("########    Bienvenido al Calculador Binario     #######");

    System.out.println("Ingrese el tipo de operación (AND, OR, XOR, NOT): ");
    String operando = scanner.nextLine();

    System.out.print("Ingrese el primer número: ");
    int op1 = scanner.nextInt();

    int op2 = 0;
    if (!operando.equalsIgnoreCase("NOT")) {
      System.out.print("Ingrese el segundo número: ");
      op2 = scanner.nextInt();
    }

    calculadora.setOp1(op1);
    calculadora.setOp2(op2);
    calculadora.setOperando(operando);

    String resultado = calculadora.getResultado();
    System.out.println("El resultado de la operación es: " + resultado);

    scanner.close();
  }
}
