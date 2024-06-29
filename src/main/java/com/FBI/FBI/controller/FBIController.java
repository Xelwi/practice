package com.FBI.FBI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.FBI.FBI.entity.FBI;
import com.FBI.FBI.service.FBIService;

@Controller
public class FBIController {

    private FBIService fbiService;

    public FBIController(FBIService fbiService) {
        super();
        this.fbiService = fbiService;
    }

    // handler method to handle list students and return mode and view
    @GetMapping("/fbis")
    public String listFBI(Model model) {
        model.addAttribute("fbis", fbiService.getAllFBI());
        return "fbis";
    }

    @GetMapping("/fbis/new")
    public String createFBIForm(Model model) {

        // create student object to hold student form data
        FBI fbi = new FBI();
        model.addAttribute("fbi", fbi);
        return "create_fbi";

    }

    @PostMapping("/fbis")
    public String saveFBI(@ModelAttribute("fbi") FBI fbi) {
        fbiService.saveFBI(fbi);
        return "redirect:/fbis";
    }

    @GetMapping("/fbis/edit/{id}")
    public String editFBIForm(@PathVariable Long id, Model model) {
        model.addAttribute("fbi", fbiService.getFBIById(id));
        return "edit_fbi";
    }

    @PostMapping("/fbis/{id}")
    public String updateFBI(@PathVariable Long id,
                                @ModelAttribute("fbi") FBI fbi,
                                Model model) {

        // get student from database by id
        FBI existingFBI = fbiService.getFBIById(id);
        existingFBI.setId(id);
        existingFBI.setFirstName(fbi.getFirstName());
        existingFBI.setLastName(fbi.getLastName());
        existingFBI.setEmail(fbi.getEmail());

        // save updated student object
        fbiService.updateFBI(existingFBI);
        return "redirect:/fbis";
    }

    // handler method to handle delete student request

    @GetMapping("/fbis/{id}")
    public String deleteFBI(@PathVariable Long id) {
        fbiService.deleteFBIById(id);
        return "redirect:/fbis";
    }

}