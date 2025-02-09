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
            System.out.println("Il numero dei posti totale deve essere positivo!");
        
        } else {
            this.titolo = titolo;
            this.data = data;
            this.postiTotali = postiTotali;
            this.postiPrenotati = 0;
        }

    }

    //Getter and setter
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
            this.data = data;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    //Metodo per prenotare un posto
    public void prenota(int posti) {
        if (data.isBefore(LocalDate.now())) {
            System.out.println("L'evento è gia passato!");
        } else if (postiPrenotati + posti < postiTotali) {
            postiPrenotati += posti;
            System.out.println("Hai prenotato con successo!");
        } else {
            System.out.println("Se vuoi prenotare un posto devi inserire un numero che deve essere minore o uguale a " + postiTotali);
        }
    }

    //Metodo per disdire un posto
    public void disdici(int posti) {
        if (data.isBefore(LocalDate.now())) {
            System.out.println("L'evento è gia passato!");
        } else if (postiPrenotati - posti > 0) {
            postiPrenotati -= posti;
            System.out.println("Hai disdetto con successo!");
        } else {
            System.out.println("Se vuoi disdire un posto devi inserire un numero che deve essere minore o uguale a " + postiPrenotati);
        }
    }

    @Override
    public String toString() {
        return data.toString() + "-" + titolo;
    }
}
