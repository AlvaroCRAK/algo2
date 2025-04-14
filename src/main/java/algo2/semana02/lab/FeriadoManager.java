package algo2.semana02.lab;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class FeriadoManager {
  private final List<LocalDate> feriados = new ArrayList<>();
  private final String archivoFeriados = "feriados.txt";
  private final String archivoFormato = "formato.txt";
  private DateTimeFormatter formatoVisual;
  private final Scanner scanner;

  public FeriadoManager(Scanner scanner) {
    this.scanner = scanner;
    this.formatoVisual = DateTimeFormatter.ofPattern("EEEE dd/MM/yyyy", Locale.getDefault());
    cargarDatos();
  }

  public void mostrarMenu() {
    while (true) {
      System.out.println("\n--- Submenú Feriados ---");
      System.out.println("1. Agregar feriado");
      System.out.println("2. Eliminar feriado");
      System.out.println("3. Buscar feriado");
      System.out.println("4. Mostrar feriados");
      System.out.println("5. Cambiar formato visualización");
      System.out.println("6. Guardar cambios");
      System.out.println("7. Regresar al menú principal");
      System.out.print("Seleccione una opción: ");

      int opcion = leerEntero();
      switch (opcion) {
        case 1 -> agregarFeriado();
        case 2 -> eliminarFeriado();
        case 3 -> buscarFeriado();
        case 4 -> mostrarFeriados();
        case 5 -> cambiarFormato();
        case 6 -> guardarDatos();
        case 7 -> {
          return;
        }
        default -> System.out.println("Opción no válida.");
      }
    }
  }

  private void agregarFeriado() {
    System.out.print("Ingrese la fecha (d/M): ");
    String entrada = scanner.nextLine().trim();
    if (!entrada.matches("\\d{1,2}/\\d{1,2}")) {
      System.out.println("Formato inválido. Use d/M.");
      return;
    }

    try {
      LocalDate fecha = LocalDate.parse(entrada + "/" + Year.now().getValue(), DateTimeFormatter.ofPattern("d/M/yyyy"));
      if (feriados.contains(fecha)) {
        System.out.println("La fecha ya está registrada.");
      } else {
        feriados.add(fecha);
        System.out.println("Feriado agregado.");
      }
    } catch (DateTimeParseException e) {
      System.out.println("Fecha inválida.");
    }
  }

  private void eliminarFeriado() {
    System.out.print("Ingrese la fecha a eliminar (d/M): ");
    String entrada = scanner.nextLine().trim();
    try {
      LocalDate fecha = LocalDate.parse(entrada + "/" + Year.now().getValue(), DateTimeFormatter.ofPattern("d/M/yyyy"));
      if (feriados.remove(fecha)) {
        System.out.println("Feriado eliminado.");
      } else {
        System.out.println("Feriado no encontrado.");
      }
    } catch (DateTimeParseException e) {
      System.out.println("Fecha inválida.");
    }
  }

  private void buscarFeriado() {
    System.out.print("Ingrese la fecha a buscar (d/M): ");
    String entrada = scanner.nextLine().trim();
    try {
      LocalDate fecha = LocalDate.parse(entrada + "/" + Year.now().getValue(), DateTimeFormatter.ofPattern("d/M/yyyy"));
      if (feriados.contains(fecha)) {
        System.out.println("Feriado registrado: " + fecha.format(formatoVisual));
      } else {
        System.out.println("No es feriado.");
      }
    } catch (DateTimeParseException e) {
      System.out.println("Fecha inválida.");
    }
  }

  private void mostrarFeriados() {
    if (feriados.isEmpty()) {
      System.out.println("No hay feriados registrados.");
      return;
    }

    System.out.println("¿Cómo desea ordenar?");
    System.out.println("1. Orden de ingreso");
    System.out.println("2. Orden cronológico");
    int opcion = leerEntero();

    List<LocalDate> copia = new ArrayList<>(feriados);
    if (opcion == 2)
      copia.sort(Comparator.naturalOrder());

    for (LocalDate fecha : copia) {
      System.out.println(fecha.format(formatoVisual));
    }
  }

  private void cambiarFormato() {
    System.out.print("Ingrese el nuevo formato (ej. EEEE dd MMMM yyyy): ");
    String nuevo = scanner.nextLine().trim();
    try {
      formatoVisual = DateTimeFormatter.ofPattern(nuevo, Locale.getDefault());
      System.out.println("Formato actualizado.");
    } catch (IllegalArgumentException e) {
      System.out.println("Formato inválido.");
    }
  }

  private void guardarDatos() {
    try (PrintWriter fw = new PrintWriter(archivoFeriados);
        PrintWriter fmt = new PrintWriter(archivoFormato)) {
      for (LocalDate f : feriados) {
        fw.println(f.toString());
      }
      fmt.println(formatoVisual.toString());
      System.out.println("Datos guardados.");
    } catch (IOException e) {
      System.out.println("Error al guardar datos.");
    }
  }

  private void cargarDatos() {
    try (BufferedReader br = new BufferedReader(new FileReader(archivoFeriados))) {
      String linea;
      while ((linea = br.readLine()) != null) {
        feriados.add(LocalDate.parse(linea));
      }
    } catch (IOException ignored) {
    }

    try (BufferedReader br = new BufferedReader(new FileReader(archivoFormato))) {
      String formato = br.readLine();
      if (formato != null) {
        formatoVisual = DateTimeFormatter.ofPattern(formato, Locale.getDefault());
      }
    } catch (IOException | IllegalArgumentException ignored) {
    }
  }

  private int leerEntero() {
    try {
      return Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
      return -1;
    }
  }
}
