package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentHibernate;
import java.util.List;

/*
@Transactional(transactionManager = "htx")
 */
@Service
@Transactional(transactionManager = "htx")
public class AccidentServiceImpl implements AccidentService {

    private final AccidentHibernate dao;

    public AccidentServiceImpl(AccidentHibernate dao) {
        this.dao = dao;
    }

    @Override
    public List<Accident> getAllAccidents() {
        return dao.getAllAccidents();
    }

    @Override
    public void addAccident(Accident accident) {
        dao.addAccident(accident);
    }

    @Override
    public Accident accidentById(int id) {
        return dao.findAccidentById(id);
    }

    @Override
    public List<AccidentType> allAccidentsTypes() {
        return dao.findAllAccidentType();
    }

    @Override
    public List<Rule> findAllRules() {
        return dao.findAllRules();
    }

    @Override
    public Accident setRules(String[] ids, Accident accident) {
        List<Rule> rules = dao.findAllRules();
        for (String ruleId : ids) {
            Rule rule = rules.get(Integer.parseInt(ruleId) - 1);
            accident.addRule(rule);
        }
        return accident;
    }
}
