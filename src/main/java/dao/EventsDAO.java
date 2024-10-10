package dao;

import entities.Concerto;
import entities.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;


public class EventsDAO {
    private EntityManager em;

    public EventsDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Event evento) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(evento);
            t.commit();
            System.out.println("Evento - " + evento.getTitolo() + " - creato!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Event findById(long id) {
        return em.find(Event.class, id);
    }

    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Event found = em.find(Event.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Evento eliminato");
            } else System.out.println("Evento non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Concerto> getConcertiInStreaming() {
        TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming=True", Concerto.class);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere() {
        TypedQuery<Concerto> query = em.createQuery("SELECT c.GenereConcerto FROM Concerto c", Concerto.class);
        return query.getResultList();
    }
}
