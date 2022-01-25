package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.service.AccidentServiceImpl;

import java.util.List;

@Controller
public class IndexControl {

    @RequestMapping("/index")
    public String index(Model model) {
        System.out.println("****Working controller Index****");
        AccidentServiceImpl accidentService = new AccidentServiceImpl();
        List<Accident> accidents = accidentService.getAllAccidents();
        System.out.println(accidents);
        model.addAttribute("itemsList", accidents);
        return "index";
    }
}
