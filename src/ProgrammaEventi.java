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
    public List<Evento> eventiInData(String data) {
            List<Evento> eventiInData = new ArrayList<>();
            for(Evento e : eventi) {
                if (e.getData().toString().equals(data)) {
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

    //Metodo che restituisce la lista di eventi ordinata
    public String getDettaglioEventi() {
        StringBuilder sb = new StringBuilder();
        sb.append(titolo).append("\n");
        eventi.sort((e1, e2) -> e1.getData().compareTo(e2.getData()));
        for (Evento e : eventi){
            sb.append(e.toString()).append("\n");
        }
        
        return sb.toString();
    }

    //Main
    public static void main(String[] args) {
        ProgrammaEventi programma = new ProgrammaEventi("Programma Eventi 2025");

        Evento evento1 = new Evento("Concerto BTR", LocalDate.of(2025, 06, 25), 500);
        Evento evento2 = new Evento("La Commedia", LocalDate.of(2025, 04, 15), 300);
        Evento evento3 = new Evento("Conferenza Apple", LocalDate.of(2025, 07, 14), 1000);

        //Aggiungi evento al programma
        programma.aggiungiEvento(evento1);
        programma.aggiungiEvento(evento2);
        programma.aggiungiEvento(evento3);

        //Lista di eventi di una certa data
        List<Evento> eventiInData = programma.eventiInData("2025-06-25");
        for (Evento e : eventiInData) {
            System.out.println("Ecco i seguenti eventi di una data precisa: " + e);
        }

        //Stampa numero di eventi
        System.out.println("Il numero di eventi è: " + programma.getNumeroEventi());

        //Lista di eventi ordinata
        System.out.println(programma.getDettaglioEventi());

        //Svuota la lista
        programma.svuotaLista();
        System.out.println("Eventi dopo lo svuotamento: " + programma.getNumeroEventi());
    }
}
