package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

import java.util.List;

@Service
public class AccidentServiceImpl implements AccidentService {

    private AccidentMem accidentMem;

    public AccidentServiceImpl(AccidentMem accidentMem) {
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
}
