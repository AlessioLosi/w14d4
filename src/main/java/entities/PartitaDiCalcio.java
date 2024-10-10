package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "partita_di_calcio")
public class PartitaDiCalcio extends Event {

    private String squadraCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int numeroGolSquadraCasa;
    private int numeroGolSquadraOspite;

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, String squadraCasa, String squadraOspite, String squadraVincente, int numeroGolSquadraCasa, int numeroGolSquadraOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.numeroGolSquadraCasa = numeroGolSquadraCasa;
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;

        if (numeroGolSquadraCasa > numeroGolSquadraOspite) {
            this.squadraVincente = squadraCasa;
        } else if (numeroGolSquadraCasa < numeroGolSquadraOspite) {
            this.squadraVincente = squadraOspite;
        } else {
            this.squadraVincente = null;
        }
    }

    public String squadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String squadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String squadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int numeroGolSquadraCasa() {
        return numeroGolSquadraCasa;
    }

    public void setNumeroGolSquadraCasa(int numeroGolSquadraCasa) {
        this.numeroGolSquadraCasa = numeroGolSquadraCasa;
    }

    public int numeroGolSquadraOspite() {
        return numeroGolSquadraOspite;
    }

    public void setNumeroGolSquadraOspite(int numeroGolSquadraOspite) {
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraCasa='" + squadraCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", numeroGolSquadraCasa=" + numeroGolSquadraCasa +
                ", numeroGolSquadraOspite=" + numeroGolSquadraOspite +
                '}';
    }
}
