import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento{

    //Attributi
    private LocalTime ora;
    private double prezzo;

    //Costruttore
    public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, double prezzo) {
        super(titolo, data, postiTotali);
        this.ora = ora;
        this.prezzo = prezzo;
    }

}
