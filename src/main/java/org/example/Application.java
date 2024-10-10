package org.example;

import dao.EventsDAO;
import dao.LocationsDAO;
import entities.Concerto;
import entities.GenereConcerto;
import entities.Location;
import entities.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("w14d4");

    public static void main(String[] args) {
        System.out.println("Hello World!");
        EntityManager em = emf.createEntityManager();
        LocationsDAO ld = new LocationsDAO(em);
        EventsDAO ed = new EventsDAO(em);
        Location location1 = new Location("Arena", "Milano");
        Location location2 = new Location("Arena2", "Roma");
        Location location3 = new Location("Arena3", "Bologna");
        Location location4 = new Location("Arena4", "Parigi");
        ld.save(location1);
        ld.save(location2);
        ld.save(location3);
        ld.save(location4);
        Concerto concerto1 = new Concerto("Olivia Rodrigo", LocalDate.now().minusDays(12), "evento musicale", TipoEvento.PRIVATO, 233232, location1, GenereConcerto.POP, true);
        Concerto concerto2 = new Concerto("Gracie Abrams", LocalDate.now().minusMonths(3), "evento musicale", TipoEvento.PUBBLICO, 93432, location2, GenereConcerto.POP, false);
        Concerto concerto3 = new Concerto("Taylor Swift", LocalDate.now().minusMonths(1), "evento musicale", TipoEvento.PRIVATO, 567546, location3, GenereConcerto.POP, true);
        Concerto concerto4 = new Concerto("Rihanna", LocalDate.now().minusMonths(34), "evento musicale", TipoEvento.PUBBLICO, 2435432, location4, GenereConcerto.ROCK, true);
        ed.save(concerto1);
        ed.save(concerto2);
        ed.save(concerto3);
        ed.save(concerto4);
        ed.getConcertiInStreaming().forEach(System.out::println);
        ed.getConcertiPerGenere().forEach(System.out::println);

    }
}
