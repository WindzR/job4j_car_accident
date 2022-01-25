package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.service.AccidentServiceImpl;

import java.util.List;

@Controller
public class AccidentControl {

    private final AccidentServiceImpl accidents;

    public AccidentControl(AccidentServiceImpl accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String create() {
        return "accident/create";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("accId") int id, Model model) {
        Accident accident = accidents.accidentById(id);
        model.addAttribute("accident", accident);
        return "redirect:/index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("accident") Accident accident) {
        accidents.addAccident(accident);
        System.out.println("Accident from form ----- " + accident);
        List<Accident> accFromStorage = accidents.getAllAccidents();
        System.out.println("STORAGE from AccidentMem ----- " + accFromStorage);
        return "redirect:/index";
    }
}
