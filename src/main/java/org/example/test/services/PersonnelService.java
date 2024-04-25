package org.example.test.services;

import org.example.test.models.Personnel;
import org.example.test.models.Rayon;
import org.example.test.models.TypePersonnel;
import org.example.test.repositories.PersonnelRepository;
import org.example.test.repositories.RayonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class PersonnelService {
    @Autowired
    PersonnelRepository personnelRepository;
    @Autowired
    RayonRepository rayonRepository;

    public Personnel ajouterPersonnelEtAffecterARayon(Personnel personnel, String codeRayon){
        Rayon rayon=rayonRepository.findByCodeRayon(codeRayon);
        if(personnel.getTypePersonnel()== TypePersonnel.BIBLIOTHECAIRE){
            personnel.setRayon_Bibliothecaire(rayon);
            List<Personnel> personnelList=new ArrayList<>();
            if(!rayon.getPersonnelSet().isEmpty())
                personnelList=rayon.getPersonnelSet();
            personnelList.add(personnel);
            rayon.setPersonnelSet(personnelList);

        }else{
            personnel.setRayonResp(rayon);
        }

        return personnelRepository.save(personnel);
    }
}
