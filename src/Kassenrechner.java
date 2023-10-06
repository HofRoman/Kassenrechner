import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Artikel {
    private String name;
    private double preis;

    public Artikel(String name, double preis) {
        this.name = name;
        this.preis = preis;
    }

    public String getName() {
        return name;
    }

    public double getPreis() {
        return preis;
    }
}

public class Kassenrechner {
    public static void main(String[] args) {
        List<Artikel> warenkorb = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Geben Sie den Artikelnamen ein (oder 'q' zum Beenden): ");
            String artikelName = scanner.nextLine();

            if (artikelName.equalsIgnoreCase("q")) {
                break;
            }

            System.out.print("Geben Sie den Preis des Artikels ein: ");
            double artikelPreis = scanner.nextDouble();
            scanner.nextLine(); // Um das newline-Zeichen nach dem Preis einzulesen

            Artikel artikel = new Artikel(artikelName, artikelPreis);
            warenkorb.add(artikel);
        }

        // Berechnen Sie den Gesamtbetrag
        double gesamtBetrag = 0.0;
        System.out.println("\nWarenkorb:");

        for (Artikel artikel : warenkorb) {
            System.out.println(artikel.getName() + ": " + artikel.getPreis() + " EUR");
            gesamtBetrag += artikel.getPreis();
        }

        System.out.println("\nGesamtbetrag: " + gesamtBetrag + " EUR");

        scanner.close();
    }
}
