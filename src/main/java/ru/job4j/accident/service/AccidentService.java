package ru.job4j.accident.service;

import ru.job4j.accident.model.Accident;

import java.util.List;

public interface AccidentService {

    public List<Accident> getAllAccidents();

    public void addAccident(Accident accident);

    public Accident accidentById(int id);
}
