package ru.job4j.accident.service;

import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.List;

public interface AccidentService {

    public List<Accident> getAllAccidents();

    public void addAccident(Accident accident);

    public Accident accidentById(int id);

    public List<AccidentType> allAccidentsTypes();

    public List<Rule> findAllRules();

    public Accident setRules(String[] ids, Accident accident);
}
