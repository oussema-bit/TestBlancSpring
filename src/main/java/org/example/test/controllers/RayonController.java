package org.example.test.controllers;

import org.example.test.models.Rayon;
import org.example.test.services.RayonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rayon")
public class RayonController {
    @Autowired
    RayonService rayonService;

    @PostMapping("/ajoutEtAffecterBiblio/{idBiblio}")
    public Rayon ajoutEtAffecterBiblio(Rayon rayon,@PathVariable("idBiblio") Long idBiblio){
        return rayonService.ajouterRayonEtAffecterABibliotheque(rayon,idBiblio);
    }
}
