import java.util.ArrayList;
import java.util.List;

public class ProgrammaEventi {

    private String titolo;
    private List<Evento> eventi;

    //Costruttore
    public ProgrammaEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

}
