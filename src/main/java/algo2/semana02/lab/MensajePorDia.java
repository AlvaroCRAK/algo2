package algo2.semana02.lab;

import java.util.Scanner;

public class MensajePorDia {
    private String[] nombreDia = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
    private String[] mensajeDia = {"Algo2", "GPS", "MAE", "...", "MAE", "...", "..."};

    public static void main(String[] args) throws Exception {
        MensajePorDia m = new MensajePorDia();
        m.mostrarMenu();
        int dia = m.leerDiaValido();  // Cambiado para asegurar que se ingrese un día válido
        m.mostrarMensaje(dia);
    }

    // Método para mostrar los días de la semana
    void mostrarMenu() {
        System.out.println("Seleccione un día de la semana:");
        for (int i = 0; i < nombreDia.length; i++) {
            System.out.println((i + 1) + ". " + nombreDia[i]);
        }
    }

    // Método para asegurar que el día ingresado sea válido
    int leerDiaValido() {
        int dia;
        Scanner scanner = new Scanner(System.in);  // Usamos Scanner
        while (true) {  // Bucle infinito hasta que se ingrese un día válido
            try {
                dia = leerDia(scanner);  // Leer el día
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
        return dia > 0 && dia <= nombreDia.length;
    }

    // Método para mostrar el mensaje correspondiente al día
    void mostrarMensaje(int dia) {
        // Usando el arreglo mensajeDia para mostrar el mensaje basado en el día seleccionado
        System.out.println("El día seleccionado es " + nombreDia[dia - 1] + ": " + mensajeDia[dia - 1]);
    }
}
