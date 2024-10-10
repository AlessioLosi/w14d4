package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "concerti")

public class Concerto extends Event {
    private GenereConcerto genereConcerto;
    private boolean inStreaming;

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, GenereConcerto genereConcerto, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genereConcerto = genereConcerto;
        this.inStreaming = inStreaming;
    }

    public GenereConcerto genereConcerto() {
        return genereConcerto;
    }

    public void setGenereConcerto(GenereConcerto genereConcerto) {
        this.genereConcerto = genereConcerto;
    }

    public boolean inStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genereConcerto=" + genereConcerto +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
