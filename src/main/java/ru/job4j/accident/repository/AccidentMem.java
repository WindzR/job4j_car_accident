package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {

    private final AtomicInteger count = new AtomicInteger(1);

    private final Map<Integer, Accident> accidents = new HashMap<>();

    public AccidentMem() {
    }

    public static AccidentMem of() {
        AccidentMem accidentMem = new AccidentMem();
        Accident collision = Accident.of(1, "Авария",
                "статья 113, 189",
                "Столкновение 2х легковых транспотных средств",
                "Москва, Проспект Мира 112");
        Accident overSpeed = Accident.of(2, "Превышение скоростного режима",
                "статья 34",
                "Превышение скоростного режима более чем на 20 км/ч",
                "Москва, Ярославское шоссе, 13 км");
        accidentMem.addAccident(collision);
        accidentMem.addAccident(overSpeed);
        return accidentMem;
    }

    public void addAccident(Accident accident) {
        if (accidents.containsKey(accident.getId())) {
            accidents.replace(accident.getId(), accident);
            return;
        }
        accident.setId(count.getAndIncrement());
        accidents.put(accident.getId(), accident);
    }

    public List<Accident> getAllAccidents() {
        return new ArrayList<>(accidents.values());
    }

    public Accident findAccidentById(int id) {
        return accidents.get(id);
    }
}
