package ru.job4j.accident.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.List;
import java.util.function.Function;

@Repository
public class AccidentHibernate {

    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public Accident addAccident(Accident accident) {
        return this.tx(
                session -> {
                    session.saveOrUpdate(accident);
                    return accident;
                }
        );
    }

    public List<Accident> getAllAccidents() {
        return this.tx(
                session -> {
                    List<Accident> accidents = null;
                    accidents = session.createQuery(
                                    "SELECT DISTINCT acc FROM Accident acc"
                                            + " JOIN FETCH acc.type"
                                            + " JOIN FETCH acc.rules ORDER BY acc.id")
                            .getResultList();
                    return accidents;
                }
        );
    }

    public Accident findAccidentById(int id) {
        return this.tx(
                session -> {
                    Accident accident = null;
                    accident = (Accident) session.createQuery(
                            "SELECT DISTINCT acc FROM Accident acc"
                            + " JOIN FETCH acc.type"
                            + " JOIN FETCH acc.rules"
                            + " WHERE acc.id = :idParam ORDER BY acc.id")
                            .setParameter("idParam", id)
                            .uniqueResult();
                    return accident;
                }
        );
    }

    public List<AccidentType> findAllAccidentType() {
        return this.tx(
                session -> {
                    List<AccidentType> types = null;
                    types = session.createQuery("FROM AccidentType", AccidentType.class)
                            .getResultList();
                    return types;
                }
        );
    }

    public List<Rule> findAllRules() {
        return this.tx(
                session -> {
                    List<Rule> rules = null;
                    rules = session.createQuery("FROM Rule", Rule.class)
                            .getResultList();
                    return rules;
                }
        );
    }

    private <T> T tx(final Function<Session, T> command) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        } finally {
            session.close();
        }
    }
}
