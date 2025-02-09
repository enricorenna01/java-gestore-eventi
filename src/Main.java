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

        // Mostra l'evento creato
        System.out.println("Evento creato: " + evento);

        // Gestione delle prenotazioni e disdette
        while (true) {
            System.out.println("\nVuoi fare una prenotazione o una disdetta? (P per prenotare, D per disdire, Q per uscire)");
            String scelta = scanner.nextLine().toUpperCase();

            if (scelta.equals("P")) {
                System.out.print("Quanti posti vuoi prenotare? ");
                int posti = Integer.parseInt(scanner.nextLine());
                evento.prenota(posti);
                
                System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
                System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
        
            } else if (scelta.equals("D")) {
                System.out.print("Quanti posti vuoi disdire? ");
                int posti = Integer.parseInt(scanner.nextLine());
                evento.disdici(posti);

                System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
                System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
                
            } else if (scelta.equals("Q")) {
                System.out.println("Grazie per aver usato il sistema. Arrivederci!");
                break; // Esce dal ciclo e termina il programma
            } else {
                System.out.println("Opzione non valida. Scegli P per prenotare, D per disdire o Q per uscire.");
            }
        }

        //Chiudo scanner
        scanner.close();
    }
}
