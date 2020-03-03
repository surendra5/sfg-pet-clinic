package com.springframeworkguru.sfgpetclinic.controller;

import com.springframeworkguru.sfgpetclinic.services.springdatajpa.OwnerSDJpaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerSDJpaService ownerSDJpaService;

    public OwnerController(OwnerSDJpaService ownerSDJpaService) {
        this.ownerSDJpaService = ownerSDJpaService;
    }

    @RequestMapping({"","/","index","index.html"})
    public String listOwners(Model model){
        model.addAttribute("owners", ownerSDJpaService.findAll());
        return "owner/index";
    }

    @RequestMapping("/find")
    public String findOwners(){
        return "notimplemented";
    }
}
