package org.example.test.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.test.models.Bibliotheque;
import org.example.test.models.Rayon;
import org.example.test.repositories.BibliothequeRepository;
import org.example.test.repositories.RayonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class RayonService {
    @Autowired
    RayonRepository rayonRepository;
    @Autowired
    BibliothequeRepository bibliothequeRepository;

    public Rayon ajouterRayonEtAffecterABibliotheque (Rayon rayon, Long idBibliotheque){
        if(bibliothequeRepository.findById(idBibliotheque).isPresent()){
            Bibliotheque bibliotheque= bibliothequeRepository.findById(idBibliotheque).get();
            rayon.setBibliotheque(bibliotheque);
        }
        return rayonRepository.save(rayon);
    }
}
