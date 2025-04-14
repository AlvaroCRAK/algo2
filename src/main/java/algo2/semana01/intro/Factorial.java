package algo2.semana01.intro;

import java.util.Scanner;

public class Factorial {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Ingrese un valor: ");
    int num = scan.nextInt();
    long fact = factorial(num);
    System.out.printf("El factorial de %d es %d.", num, fact);
    scan.close();
  }

  public static long factorial(int num) {
    if (num < 0)
      throw new IllegalArgumentException("No se puede calcular factorial de negativos");
    long result = 1;
    for (int i = 2; i <= num; i++) {
      result *= i;
    }
    return result;
  }
}
