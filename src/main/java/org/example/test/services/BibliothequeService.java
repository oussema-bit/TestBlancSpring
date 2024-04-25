package org.example.test.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.test.models.Bibliotheque;
import org.example.test.repositories.BibliothequeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class BibliothequeService {
    @Autowired
    BibliothequeRepository bibliothequeRepository;
    public Bibliotheque ajouterBibliotheque(Bibliotheque bibliotheque){
        return bibliothequeRepository.save(bibliotheque);
    }

}
