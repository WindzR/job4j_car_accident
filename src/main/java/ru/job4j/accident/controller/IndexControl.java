package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexControl {

    @RequestMapping("/index")
    public String index(Model model) {
        System.out.println("****Working controller Index****");
        Accident collision = Accident.of(1, "Авария",
                "статья 113, 189",
                "Столкновение 2х легковых транспотных средств",
                "Москва, Проспект Мира 112");
        Accident overSpeed = Accident.of(2, "Превышение скоростного режима",
                "статья 34",
                "Превышение скоростного режима более чем на 20 км/ч",
                "Москва, Ярославское шоссе, 13 км");
        AccidentMem store = new AccidentMem();
        store.addAccident(collision);
        store.addAccident(overSpeed);
        List<Accident> accidents = new ArrayList<>(store.getAccidents().values());
        System.out.println(accidents);
        model.addAttribute("itemsList", accidents);
        return "index";
    }
}
