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

    public void desaffecterPersonnelDuRayon(Long idPersonnel){
        Personnel personnel =personnelRepository.findById(idPersonnel).get();
        if(personnel.getTypePersonnel()==TypePersonnel.BIBLIOTHECAIRE){
            Rayon rayon=personnel.getRayon_Bibliothecaire();
            personnel.setRayon_Bibliothecaire(null);
            List<Personnel> personnelList=rayon.getPersonnelSet();
            personnelList.remove(personnel);
            rayonRepository.save(rayon);
        }else{
            Rayon rayon=personnel.getRayonResp();
            personnel.setRayonResp(null);
            rayon.setPersonnel(null);
            rayonRepository.save(rayon);
        }
        personnelRepository.save(personnel);
    }
}
