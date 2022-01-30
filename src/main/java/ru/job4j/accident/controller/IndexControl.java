package ru.job4j.accident.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.service.AccidentServiceImpl;

import java.util.List;

@Controller
public class IndexControl {

    private final AccidentServiceImpl accidents;

    public IndexControl(AccidentServiceImpl accidents) {
        this.accidents = accidents;
    }

    @RequestMapping("/index")
    public String index(Model model) {
        System.out.println("****Working controller Index****");
        model.addAttribute("user", SecurityContextHolder
                .getContext().getAuthentication().getPrincipal());
        List<Accident> list = accidents.getAllAccidents();
        System.out.println(list);
        model.addAttribute("itemsList", list);
        return "index";
    }
}
