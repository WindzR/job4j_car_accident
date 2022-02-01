package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.repository.AccidentTypeRepository;
import ru.job4j.accident.repository.RuleRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
@Transactional(transactionManager = "transactionManager")
 */
@Service
public class AccidentServiceImpl implements AccidentService {

    private final AccidentRepository accidentDAO;

    private final AccidentTypeRepository accidentTypeDAO;

    private final RuleRepository ruleDAO;

    public AccidentServiceImpl(AccidentRepository accidentDAO,
                               AccidentTypeRepository accidentTypeDAO,
                               RuleRepository ruleDAO) {
        this.accidentDAO = accidentDAO;
        this.accidentTypeDAO = accidentTypeDAO;
        this.ruleDAO = ruleDAO;
    }

    public List<Accident> getAllAccidents() {
        return accidentDAO.findAll();
    }

    public void addAccident(Accident accident) {
        accidentDAO.save(accident);
    }

    public Accident accidentById(Integer id) {
        if (accidentDAO.findById(id).isPresent()) {
            return accidentDAO.findById(id).get();
        }
        return defaultAccident();
    }

    public List<AccidentType> allAccidentsTypes() {
        List<AccidentType> accidentTypes = new ArrayList<>();
        accidentTypeDAO.findAll().forEach(accidentTypes::add);
        return accidentTypes;
    }

    public List<Rule> findAllRules() {
        List<Rule> rules = new ArrayList<>();
        ruleDAO.findAll().forEach(rules::add);
        return rules;
    }

    public Accident setRules(String[] ids, Accident accident) {
        List<Rule> rules = findAllRules();
        for (String ruleId : ids) {
            Rule rule = rules.get(Integer.parseInt(ruleId) - 1);
            accident.addRule(rule);
        }
        return accident;
    }

    public Accident setType(Accident accident) {
        List<AccidentType> types = allAccidentsTypes();
        AccidentType newType = types.get(accident.getType().getId() - 1);
        accident.setType(newType);
        return accident;
    }

    private Accident defaultAccident() {
        Rule rule = Rule.of(0, "default");
        Set<Rule> rules = new HashSet<Rule>();
        rules.add(rule);
        return new Accident(0, "default", "default", "default", rules);
    }
}
