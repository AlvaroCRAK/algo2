package algo2.semana02.lab;

import java.time.DayOfWeek;
import java.util.Locale;
import java.util.Scanner;

public class MensajePorDia {
  private String[] mensajeDia = { "Algo2", "GPS", "MAE", "...", "MAE", "...", "..." };

  public static void main(String[] args) throws Exception {
    MensajePorDia m = new MensajePorDia();
    m.mostrarMenu();
    int dia = m.leerDiaValido(); // Cambiado para asegurar que se ingrese un día válido
    m.mostrarMensaje(dia);
  }

  // Método para mostrar los días de la semana usando DayOfWeek
  void mostrarMenu() {
    System.out.println("Seleccione un día de la semana:");
    for (DayOfWeek dia : DayOfWeek.values()) {
      // Usamos getDisplayName para mostrar el nombre del día en el idioma local
      System.out.println(dia.getDisplayName(java.time.format.TextStyle.FULL, Locale.getDefault()));
    }
  }

  // Método para asegurar que el día ingresado sea válido
  int leerDiaValido() {
    int dia;
    Scanner scanner = new Scanner(System.in); // Usamos Scanner
    while (true) { // Bucle infinito hasta que se ingrese un día válido
      try {
        dia = leerDia(scanner); // Leer el día
        return dia;
      } catch (Exception e) {
        System.out.println("El día seleccionado no es válido. Intente de nuevo.");
      }
    }
  }

  // Método para leer el día desde el input
  int leerDia(Scanner scanner) throws Exception {
    System.out.print("Seleccione un día (1-7): ");
    int dia = Integer.parseInt(scanner.nextLine());
    if (diaValido(dia)) {
      return dia;
    } else {
      throw new Exception("El día seleccionado no es válido");
    }
  }

  // Método para validar si el día es válido (entre 1 y 7)
  private boolean diaValido(int dia) {
    return dia > 0 && dia <= DayOfWeek.values().length;
  }

  // Método para mostrar el mensaje correspondiente al día
  void mostrarMensaje(int dia) {
    // Usando el arreglo mensajeDia para mostrar el mensaje basado en el día
    // seleccionado
    DayOfWeek diaSemana = DayOfWeek.of(dia);
    System.out.println("El día seleccionado es "
        + diaSemana.getDisplayName(java.time.format.TextStyle.FULL, Locale.getDefault()) + ": " + mensajeDia[dia - 1]);
  }
}

