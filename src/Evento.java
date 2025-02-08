import java.time.LocalDate;

public class Evento {

    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati;

    //Costruttore
    public Evento(String titolo, LocalDate data, int postiTotali) {
        if (data.isBefore(LocalDate.now())) {
            System.out.println("La data dell'evento è già passata...");
        
        } else if (postiTotali <= 0) {
            System.out.println("Il numero dei posti tottale deve essere positivo!");
        
        } else {
            this.titolo = titolo;
            this.data = data;
            this.postiTotali = postiTotali;
            this.postiPrenotati = 0;
        }

    }
}
