package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {

    private final AtomicInteger count = new AtomicInteger(0);

    private Map<Integer, Accident> accidents = new HashMap<>();

    public AccidentMem() {
    }

    public Map<Integer, Accident> getAccidents() {
        return accidents;
    }

    public void setAccidents(Map<Integer, Accident> accidents) {
        this.accidents = accidents;
    }

    public void addAccident(Accident accident) {
       accidents.put(count.incrementAndGet(), accident);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccidentMem that = (AccidentMem) o;
        return Objects.equals(accidents, that.accidents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accidents);
    }
}
