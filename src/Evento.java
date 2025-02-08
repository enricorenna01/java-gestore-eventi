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
        if (data.isBefore(LocalDate.now())) {
            System.out.println("La data dell'evento non può essere nel passato");
        } else {
            this.data = data;
        }
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }
}
