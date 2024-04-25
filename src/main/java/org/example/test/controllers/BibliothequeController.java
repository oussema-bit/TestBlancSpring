package org.example.test.controllers;

import org.example.test.models.Bibliotheque;
import org.example.test.services.BibliothequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bibliotheque")
public class BibliothequeController {
    @Autowired
    BibliothequeService bibliothequeService;
    @PostMapping("/add")
    public Bibliotheque add(@RequestBody Bibliotheque bibliotheque){
        return bibliothequeService.ajouterBibliotheque(bibliotheque);
    }
}
