package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.service.AccidentServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class AccidentControl {

    private final AccidentServiceImpl accidents;

    public AccidentControl(AccidentServiceImpl accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String create(Model model) {
        Collection<AccidentType> types = accidents.allAccidentsTypes();
        model.addAttribute("types", types);
        List<Rule> rules = accidents.findAllRules();
        model.addAttribute("rules", rules);
        return "accident/create";
    }

    @GetMapping("/update")
    public String edit(@RequestParam("id") int id, Model model) {
        System.out.println("****Working controller UPDATE****");
        Accident accident = accidents.accidentById(id);
        Collection<AccidentType> types = accidents.allAccidentsTypes();
        List<Rule> rules = accidents.findAllRules();
        System.out.println(accident);
        model.addAttribute("rules", rules);
        model.addAttribute("types", types);
        model.addAttribute("accident", accident);
        return "accident/update";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("accident") Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        Accident accWithRules = accidents.setRules(ids, accident);
        accidents.addAccident(accWithRules);
        System.out.println("Accident from form ----- " + accWithRules);
        return "redirect:/index";
    }
}
