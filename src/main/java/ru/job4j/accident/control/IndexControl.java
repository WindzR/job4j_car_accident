package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexControl {

    @RequestMapping("/index")
    public String index(Model model) {
        System.out.println("****Working controller IndexControl****");
        List<String> list = new ArrayList<>();
        list.add("Первый элемент списка");
        list.add("Второй элемент списка");
        list.add("Третий элемент списка");
        model.addAttribute("itemsList", list);
        return "index";
    }

    @RequestMapping("/askDetails")
    public String askEmpDetails() {
        return "ask-emp-details";
    }

    @RequestMapping("/showDetails")
    public String showDetails() {
        return "show-emp-details";
    }
}
