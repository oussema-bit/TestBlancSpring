package org.example.test.controllers;

import org.example.test.models.Livre;
import org.example.test.services.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livre")
public class LivreController {

    @Autowired
    LivreService livreService;

    @PostMapping("/ajouterLivreEtAffecterARayon/{idRayon}")
    public void ajouterLivreEtAffecterARayon(@RequestBody Livre livre, @PathVariable("idRayon") Long idRayon){
        livreService.ajouterLivreEtAffecterARayon(livre,idRayon);
    }
}
