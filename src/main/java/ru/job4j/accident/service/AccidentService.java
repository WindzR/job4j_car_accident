package ru.job4j.accident.service;

import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.List;

public interface AccidentService {

    List<Accident> getAllAccidents();

    void addAccident(Accident accident);

    Accident accidentById(Integer id);

    List<AccidentType> allAccidentsTypes();

    List<Rule> findAllRules();

    Accident setRules(String[] ids, Accident accident);
}
