package dao;

import entities.Event;
import entities.PartitaDiCalcio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartiteDiCalcioDAO {
    private EntityManager em;

    public PartiteDiCalcioDAO(EntityManager em) {
        this.em = em;
    }


    public void save(PartitaDiCalcio partita) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(partita);
            t.commit();
            System.out.println("L'Evento - " + partita.getTitolo() + " - creato!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Event findById(long id) {
        return em.find(PartitaDiCalcio.class, id);
    }

    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Event found = em.find(PartitaDiCalcio.class, id);
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
    
}
