package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

@Controller
public class AccidentControl {
    private final AccidentMem accidents;

    public AccidentControl(AccidentMem accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String create() {
        return "accident/create";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Accident accident) {
        accidents.addAccident(accident);
        System.out.println(accident);
        return "accident/edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("accident") Accident accident) {
        accidents.addAccident(accident);
        System.out.println("Accident from form ----- " + accident);
        return "redirect:/index";
    }
}
