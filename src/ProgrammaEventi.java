import java.time.LocalDate;
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

    //Metodo che aggiunge alla lista un Evento, passato come parametro
    public void aggiungiEvento(Evento evento) {
        eventi.add(evento);
    }

    //Metodo che restituisce una lista con tutti gli eventi presenti in una certa data
    public List<Evento> eventiInData(LocalDate data) {
        List<Evento> eventiInData = new ArrayList<>();
        for(Evento e : eventi) {
            if (e.getData().equals(data)) {
                eventiInData.add(e);
            }
        }
        return eventiInData;
    }

    //Metodo che restituisce quanti eventi sono presenti nel programma
    public int getNumeroEventi() {
        return eventi.size();
    }

    //Metodo che svuota la lista di eventi
    public void svuotaLista(){
        eventi.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(titolo).append("\n");
        eventi.sort((e1, e2) -> e1.getData().compareTo(e2.getData()));
        for (Evento e : eventi){
            sb.append(e.toString()).append("\n");
        }
        
        return sb.toString();
    }
}
