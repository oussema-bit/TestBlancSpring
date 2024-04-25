package org.example.test.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Personnel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersonnel;
    private String nom;
    private String prenom;
    @Enumerated(EnumType.STRING)
    private TypePersonnel typePersonnel;
    @ManyToOne
    @JsonIgnore
    private Rayon rayon_Bibliothecaire;



    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Rayon rayonResp;


}
