package algo2.semana02.lab;

public class SeparadorDeArgs {
    public static void main(String[] args) {
        StringBuilder nombres = new StringBuilder();
        StringBuilder numeros = new StringBuilder();
        int suma = 0;

        // Recorrer los argumentos
        for (String arg : args) {
            try {
                // Intentar convertir el argumento a número
                int numero = Integer.parseInt(arg);
                if (numeros.length() > 0) {
                    numeros.append(", ");
                }
                numeros.append(numero);
                suma += numero;
            } catch (NumberFormatException e) {
                // Si no es un número, entonces es un nombre
                if (nombres.length() > 0) {
                    nombres.append(", ");
                }
                nombres.append(arg);
            }
        }

        // Mostrar los nombres
        System.out.println("Nombres: " + nombres.toString());

        // Mostrar los números
        System.out.println("Números: " + numeros.toString());

        // Mostrar la suma de los números
        System.out.println("Suma total de números: " + suma);
    }
}
