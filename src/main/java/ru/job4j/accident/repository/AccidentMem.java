package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {

    private final AtomicInteger count = new AtomicInteger(3);

    private final Map<Integer, Accident> accidents = new HashMap<>();

    private final Map<Integer, AccidentType> types = new HashMap<>();

    public AccidentMem() {
        Accident collision = Accident.of(1, "Авария",
                "статья 113, 189",
                "Столкновение 2х легковых транспотных средств",
                "Москва, Проспект Мира 112");
        AccidentType col = AccidentType.of(1, "Две машины");
        collision.setType(col);
        Accident overSpeed = Accident.of(2, "Превышение скоростного режима",
                "статья 34",
                "Превышение скоростного режима более чем на 20 км/ч",
                "Москва, Ярославское шоссе, 13 км");
        AccidentType speed = AccidentType.of(4, "Одно транспортное средство");
        overSpeed.setType(speed);
        accidents.put(1, collision);
        accidents.put(2, overSpeed);
        types.put(1, AccidentType.of(1, "Две машины"));
        types.put(2, AccidentType.of(2, "Машина и человек"));
        types.put(3, AccidentType.of(3, "Машина и велосипед"));
        types.put(4, AccidentType.of(4, "Одно транспортное средство"));
    }

    public void addAccident(Accident accident) {
        if (accidents.containsKey(accident.getId())) {
            AccidentType newType = types.get(accident.getType().getId());
            accident.setType(newType);
            accidents.replace(accident.getId(), accident);
            return;
        }
        AccidentType newType = types.get(accident.getType().getId());
        accident.setType(newType);
        accident.setId(count.getAndIncrement());
        accidents.put(accident.getId(), accident);
    }

    public List<Accident> getAllAccidents() {
        return new ArrayList<>(accidents.values());
    }

    public Accident findAccidentById(int id) {
        return accidents.get(id);
    }

    public List<AccidentType> findAllAccidentType() {
        return new ArrayList<>(types.values());
    }
}
