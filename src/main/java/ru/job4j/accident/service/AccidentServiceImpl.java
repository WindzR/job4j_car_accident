package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentJdbcTemplate;
import ru.job4j.accident.repository.AccidentMem;
import java.util.List;

@Service
public class AccidentServiceImpl implements AccidentService {

    private AccidentJdbcTemplate accidentMem;

    public AccidentServiceImpl(AccidentJdbcTemplate accidentMem) {
        this.accidentMem = accidentMem;
    }

    @Override
    public List<Accident> getAllAccidents() {
        return accidentMem.getAllAccidents();
    }

    @Override
    public void addAccident(Accident accident) {
        accidentMem.addAccident(accident);
    }

    @Override
    public Accident accidentById(int id) {
        return accidentMem.findAccidentById(id);
    }

    @Override
    public List<AccidentType> allAccidentsTypes() {
        return accidentMem.findAllAccidentType();
    }

    @Override
    public List<Rule> findAllRules() {
        return accidentMem.findAllRules();
    }

    @Override
    public Accident setRules(String[] ids, Accident accident) {
        List<Rule> rules = accidentMem.findAllRules();
        for (String ruleId : ids) {
            Rule rule = rules.get(Integer.parseInt(ruleId) - 1);
            accident.addRule(rule);
        }
        return accident;
    }
}
