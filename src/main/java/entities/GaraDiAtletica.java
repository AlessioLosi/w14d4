package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "gara_atletica")

public class GaraDiAtletica extends Event {
    private List<Person> atleti;
    private Person vincitore;

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, List<Person> atleti, Person vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public List<Person> atleti() {
        return atleti;
    }

    public void setAtleti(List<Person> atleti) {
        this.atleti = atleti;
    }

    public Person vincitore() {
        return vincitore;
    }

    public void setVincitore(Person vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "atleti=" + atleti +
                ", vincitore=" + vincitore +
                '}';
    }
}
