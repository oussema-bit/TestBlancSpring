package org.example.test.services;

import org.example.test.models.Bibliotheque;
import org.example.test.models.Livre;
import org.example.test.models.Rayon;
import org.example.test.repositories.BibliothequeRepository;
import org.example.test.repositories.LivreRepository;
import org.example.test.repositories.RayonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivreService {

    @Autowired
    LivreRepository livreRepository;
    @Autowired
    RayonRepository rayonRepository;
    @Autowired
    BibliothequeRepository bibliothequeRepository;
    public void ajouterLivreEtAffecterARayon(Livre livre, Long idRayon){
        if(rayonRepository.findById(idRayon).isPresent()){
            Rayon rayon=rayonRepository.findById(idRayon).get();
            livre.setRayon(rayon);
            List<Livre> livreList=new ArrayList<>();
            if(!rayon.getLivreList().isEmpty()){
                livreList=rayon.getLivreList();
            }
            livreList.add(livre);
            rayon.setLivreList(livreList);
            rayonRepository.save(rayon);
            livreRepository.save(livre);
        }
    }

    public List<String> titreLivreParBibliothequeEtRayon(Long idBibliotheque, Long idRayon){
        Rayon rayon=rayonRepository.findById(idRayon).get();
        Bibliotheque bibliotheque=bibliothequeRepository.findById(idBibliotheque).get();
        if(bibliotheque.getRayons().contains(rayon)){
            return rayon.getLivreList().stream()
                    .map(Livre::getTitre)
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }
}
