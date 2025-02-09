import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Chiedo all'utente i dettagli dell'evento
        System.out.println("Inserisci il titolo dell'evento...");
        String titolo = scanner.nextLine();

        System.out.println("Inserisci la data dell'evento (yyyy-MM-dd)...");
        String dataString = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataString);

        System.out.println("Inserisci il numero dei posti totali...");
        int postiTotali = scanner.nextInt();

        //Creo un nuovo evento
        Evento evento = new Evento(titolo, data, postiTotali);
    }
}
