import java.text.DecimalFormat;
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

    //Getter and setter
    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    //Metodo per formattare data
    public String getDataFormattata() {
        return getData().toString();
    }

    //Metodo per formattare ora
    public String getOraFormattata() {
    return getOra().toString();
    }

    //Metodo per formattare prezzo
    public String getPrezzoFormattato() {
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return decimalFormat.format(prezzo) + "€";
    }

    @Override
    public String toString() {
        return getDataFormattata() + " " + getOraFormattata() + " - " + getTitolo() + " - " + getPrezzoFormattato();
    }
}
