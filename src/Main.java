import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Chiedo all'utente i dettagli dell'evento
        System.out.println("Inserisci il titolo dell'evento...");
        String titolo = scanner.nextLine();

        // Chiedi la data e verifica che sia valida
        LocalDate data = null;
        
        while (data == null) {  // Continua a chiedere la data finché non è valida
            System.out.print("Inserisci la data dell'evento (yyyy-MM-dd): ");
            String dataStr = scanner.nextLine();

            try {
                data = LocalDate.parse(dataStr);

                if (data.isBefore(LocalDate.now())) {
                    System.out.println("Errore: la data dell'evento è già passata. Riprova.");
                    data = null; // Imposta la data a null per ripetere il ciclo
                }
            } catch (DateTimeParseException e) {
                System.out.println("Errore: formato della data non valido. Riprova.");
            }
        }

        System.out.println("Inserisci il numero dei posti totali...");
        int postiTotali = scanner.nextInt();

        //Creo un nuovo evento
        Evento evento = new Evento(titolo, data, postiTotali);

        //Prenotazione
        System.out.println("Quante prenotazioni vuoi fare?");
        int prenotazioni = scanner.nextInt();
        for (int i = 0; i < prenotazioni; i++) {
            evento.prenota();
        }

        System.out.println("Posti prontati: " + evento.getPostiPrenotati());
        System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));

        //Disdetta
        System.out.println("Quante disdette vuoi fare?");
        int disdette = scanner.nextInt();
        for (int i = 0; i < disdette; i++) {
            evento.disdici();
        }

        System.out.println("Posti prontati: " + evento.getPostiPrenotati());
        System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));

        //Chiudo scanner
        scanner.close();
    }
}
