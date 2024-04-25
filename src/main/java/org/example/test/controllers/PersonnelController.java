package org.example.test.controllers;

import org.example.test.models.Personnel;
import org.example.test.services.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personnel")
public class PersonnelController {
    @Autowired
    PersonnelService personnelService;

    @PostMapping("/ajouterPersonnelEtAffecterARayon/{idRayon}")
    public Personnel ajouterPersonnelEtAffecterARayon(@RequestBody Personnel personnel, @PathVariable("idRayon")String idRayon){
        return personnelService.ajouterPersonnelEtAffecterARayon(personnel,idRayon);
    }
}
