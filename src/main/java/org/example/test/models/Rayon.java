package org.example.test.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rayon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRayon;
    private String codeRayon;
    private String nomRayon;

    @ManyToOne
    private Bibliotheque bibliotheque;

    @OneToMany(mappedBy = "rayon",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Livre> livreList;

    @OneToMany
    private List<Personnel> personnelSet;



    @OneToOne(mappedBy = "rayonResp")
    private Personnel personnel;


}
