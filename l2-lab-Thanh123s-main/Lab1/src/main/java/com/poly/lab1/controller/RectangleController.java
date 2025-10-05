package com.poly.lab1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.poly.lab1.model.Rectangle;

@Controller
public class RectangleController {

    @GetMapping("/rectangle")
    public String showCalculatorForm(Model model) {
        model.addAttribute("rectangle", new Rectangle());
        return "rectangle/calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@ModelAttribute Rectangle rectangle, Model model) {
        model.addAttribute("rectangle", rectangle);
        return "rectangle/result";
    }
}
