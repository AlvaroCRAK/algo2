package algo2.semana02.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasicLibDemo {
  private String[] opciones = { "Circulo", "Rectangulo", "Cadena(String)", "Fechas", "Lista" };
  private Scanner scanner = new Scanner(System.in); // Un solo objeto Scanner
  private final FeriadoManager feriadoManager = new FeriadoManager(scanner);

  public static void main(String[] args) {
    BasicLibDemo m = new BasicLibDemo();
    while (true) {
      m.mostrarMenu();
      int opcion = m.leerOpcionValida();
      m.procesarOpcion(opcion);
    }
  }

  // Mostrar las opciones del menú principal
  void mostrarMenu() {
    System.out.println("=== Menú Principal ===");
    int n = 1;
    for (String opc : opciones) {
      System.out.format("%d.- %s%n", n++, opc);
    }
  }

  // Leer una opción válida del usuario
  int leerOpcionValida() {
    int opc;
    while (true) {
      try {
        opc = leerOpcion();
        if (esOpcionValida(opc)) {
          return opc;
        } else {
          System.out.println("Opción no válida. Intente de nuevo.");
        }
      } catch (Exception e) {
        System.out.println("Entrada no válida. Intente de nuevo.");
      }
    }
  }

  // Leer la opción seleccionada por el usuario
  int leerOpcion() throws Exception {
    System.out.print("Seleccione una opción: ");
    int op = Integer.parseInt(scanner.nextLine());
    return op;
  }

  // Verificar si la opción es válida
  private boolean esOpcionValida(int op) {
    return op > 0 && op <= opciones.length;
  }

  // Procesar la opción seleccionada
  void procesarOpcion(int opcion) {
    List<String> lista = new ArrayList<>();
    switch (opcion) {
      case 1:
        procesarCirculo();
        break;
      case 2:
        procesarRectangulo();
        break;
      case 3:
        procesarCadena();
        break;
      case 4:
        procesarFechas();
        break;
      case 5:
        mostrarSubmenuLista(lista);
        break;
      default:
        System.out.println("Opción no válida. Saliendo...");
        System.exit(0);
        break;
    }
  }

  // Procesar el área y circunferencia de un círculo
  void procesarCirculo() {
    System.out.print("Ingrese el radio: ");
    double radio = obtenerDouble();
    double area = Math.PI * radio * radio;
    double circunferencia = 2 * Math.PI * radio;
    System.out.format("El área del círculo con radio (%.3f) es %.3f%n (3.142 * %.3f * %.3f).\n", radio, area, radio,
        radio);
    System.out.format("Resumen de datos:\n");
    System.out.format("radio: %.3f\n", radio);
    System.out.format("area: %.3f\n", area);
    System.out.format("La circunferencia del círculo es %.2f%n", circunferencia);
  }

  // Procesar el área de un rectángulo
  void procesarRectangulo() {
    System.out.print("Ingrese el ancho: ");
    double ancho = obtenerDouble();
    System.out.print("Ingrese el alto: ");
    double alto = obtenerDouble();
    double area = ancho * alto;
    System.out.format("El área del rectángulo con ancho %.2f y alto %.2f es %.2f%n", ancho, alto, area);
  }

  // Obtener un número decimal válido
  double obtenerDouble() {
    while (true) {
      try {
        return Double.parseDouble(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Entrada no válida. Por favor ingrese un número.");
      }
    }
  }

  // Procesar cadenas, comprobando que la segunda sea parte de la primera
  void procesarCadena() {
    System.out.print("Ingrese un string: ");
    String cad1 = scanner.nextLine();
    System.out.print("Ingrese otro string: ");
    String cad2 = scanner.nextLine();
    System.out.print("Escoja un carácter especial (* # . - /): ");
    String cad3 = scanner.nextLine();

    if ("*#.-/".contains(cad3)) {
      int pos = cad1.toLowerCase().indexOf(cad2.toLowerCase());
      if (pos >= 0) {
        System.out.format("La cadena '%s' es parte de '%s', y se encuentra en la posición %d%n", cad2, cad1, pos);
        System.out.format("Con la subcadena('%s') eliminada sería '%s'%n", cad2, cad1.replace(cad2, ""));
        System.out.format("Con la subcadena('%s') reemplazada por '%s' sería '%s'%n", cad2, cad3,
            cad1.replace(cad2, cad3));
      } else {
        System.out.format("La cadena '%s' NO es parte de '%s'%n", cad2, cad1);
      }
    } else {
      System.out.println("Carácter especial no válido.");
    }
  }

  // Procesar fechas (pendiente)
  void procesarFechas() {
    feriadoManager.mostrarMenu();
  }

  // Submenú de la lista: Nuevo elemento, Mostrar contenido, Eliminar, Buscar
  void mostrarSubmenuLista(List<String> lista) {
    while (true) {
      System.out.println("\n--- Submenú Lista ---");
      System.out.println("1. Agregar Nuevo Elemento");
      System.out.println("2. Mostrar Contenido");
      System.out.println("3. Eliminar Elemento");
      System.out.println("4. Buscar Elemento");
      System.out.println("5. Regresar al Menú Principal");
      System.out.print("Seleccione una opción: ");
      int opcionSubmenu = obtenerEntero();

      switch (opcionSubmenu) {
        case 1:
          agregarElementoLista(lista);
          break;
        case 2:
          mostrarContenidoLista(lista);
          break;
        case 3:
          eliminarElementoLista(lista);
          break;
        case 4:
          buscarElementoLista(lista);
          break;
        case 5:
          return; // Regresar al menú principal
        default:
          System.out.println("Opción no válida. Intente de nuevo.");
          break;
      }
    }
  }

  // Obtener un número entero válido
  int obtenerEntero() {
    while (true) {
      try {
        return Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Entrada no válida. Por favor ingrese un número entero.");
      }
    }
  }

  // Agregar un nuevo elemento a la lista
  void agregarElementoLista(List<String> lista) {
    System.out.print("Ingrese un elemento a agregar: ");
    String elemento = scanner.nextLine();
    lista.add(elemento);
    System.out.println("Elemento agregado.");
  }

  // Mostrar contenido de la lista
  void mostrarContenidoLista(List<String> lista) {
    System.out.println("Contenido de la lista:");
    if (lista.isEmpty()) {
      System.out.println("La lista está vacía.");
    } else {
      for (String elem : lista) {
        System.out.println(elem);
      }
    }
  }

  // Eliminar un elemento de la lista
  void eliminarElementoLista(List<String> lista) {
    System.out.print("Ingrese el elemento a eliminar: ");
    String elemento = scanner.nextLine();
    if (lista.remove(elemento)) {
      System.out.println("Elemento eliminado.");
    } else {
      System.out.println("Elemento no encontrado en la lista.");
    }
  }

  // Buscar un elemento en la lista
  void buscarElementoLista(List<String> lista) {
    System.out.print("Ingrese el elemento a buscar: ");
    String elemento = scanner.nextLine();
    if (lista.contains(elemento)) {
      System.out.println("Elemento encontrado en la lista.");
    } else {
      System.out.println("Elemento no encontrado en la lista.");
    }
  }
}
