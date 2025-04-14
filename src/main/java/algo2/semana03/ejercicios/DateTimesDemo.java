package algo2.semana03.ejercicios;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimesDemo {

  public static void main(String[] args) {
    showAhora();
    showFechasConocidas();
    showFeriados();
    showFechasDiversas();
  }

  public static void showAhora() {
    System.out.println("=== Fecha y hora actual ===");
    ZonedDateTime ahora = ZonedDateTime.now();

    // En formato inglés
    Locale localeEn = Locale.ENGLISH;
    System.out.println("En inglés:");
    System.out.println(ahora.format(DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy HH:mm:ss", localeEn)));

    // En formato español
    Locale localeEs = Locale.of("es", "ES");
    System.out.println("En español:");
    System.out.println(ahora.format(DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy, HH:mm:ss", localeEs)));

    System.out.println("\nEste momento en otras ciudades:");
    ZonedDateTime sydney = ahora.withZoneSameInstant(ZoneId.of("Australia/Sydney"));
    ZonedDateTime utcMinus7 = ahora.withZoneSameInstant(ZoneId.of("UTC-07:00"));

    System.out.println("Sydney: " + sydney.format(DateTimeFormatter.ofPattern("EEEE d MMM yyyy HH:mm:ss", localeEs)));
    System.out.println(
        "Zona UTC-07:00: " + utcMinus7.format(DateTimeFormatter.ofPattern("EEEE d MMM yyyy HH:mm:ss", localeEn)));
  }

  public static void showFechasConocidas() {
    System.out.println("\n=== Fechas conocidas ===");
    LocalDate independenciaPeru = LocalDate.of(1821, 7, 28);
    LocalDate llegadaALaLuna = LocalDate.of(1969, 7, 20);
    LocalDate inicioWW2 = LocalDate.of(1939, 9, 1);

    System.out.printf("Independencia del Perú: %s%n", formatDate(independenciaPeru));
    System.out.printf("Llegada a la Luna: %s%n", formatDate(llegadaALaLuna));
    System.out.printf("Inicio de la Segunda Guerra Mundial: %s%n", formatDate(inicioWW2));
  }

  public static void showFeriados() {
    System.out.println("\n=== Feriados Nacionales ===");
    DateTimeFormatter formatoFeriado = DateTimeFormatter.ofPattern("EEE dd/MM/yyyy", Locale.of("es", "ES"));

    LocalDate[] feriados = {
        LocalDate.of(2024, 1, 1),
        LocalDate.of(2024, 4, 1),
        LocalDate.of(2024, 5, 1),
        LocalDate.of(2024, 6, 29),
        LocalDate.of(2024, 7, 28),
        LocalDate.of(2024, 7, 29),
        LocalDate.of(2024, 12, 25)
    };

    for (LocalDate f : feriados) {
      System.out.println(f.format(formatoFeriado));
    }
  }

  public static void showFechasDiversas() {
    System.out.println("\n=== Fechas diversas ===");
    LocalDate hoy = LocalDate.now();
    LocalDate mañana = hoy.plusDays(1);
    LocalDate haceUnaSemana = hoy.minusWeeks(1);
    LocalDate dentroDeUnAño = hoy.plusYears(1);
    LocalDate hace10Años = hoy.minusYears(10);

    System.out.printf("Hoy: %s%n", formatDate(hoy));
    System.out.printf("Mañana: %s%n", formatDate(mañana));
    System.out.printf("Hace una semana: %s%n", formatDate(haceUnaSemana));
    System.out.printf("Dentro de un año: %s%n", formatDate(dentroDeUnAño));
    System.out.printf("Hace 10 años: %s%n", formatDate(hace10Años));
  }

  private static String formatDate(LocalDate date) {
    return date.format(DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy", Locale.of("es", "ES")));
  }
}
