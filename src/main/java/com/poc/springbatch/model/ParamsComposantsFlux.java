package com.poc.springbatch.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "t_params_composants_flux")
public class ParamsComposantsFlux {

    @Id
    @EmbeddedId
    private ParamComposantFluxId paramComposantFluxId;

    @Column(name = "code_cpm_flux", length = 90)
    private String codeCpmFlux;

    @Column(name = "nom_cpm_flux", length = 255)
    private String nomCpmFlux;

    @Column(name = "localisation_flux", length = 255)
    private String localisationFlux;

    @Column(name = "pattern_flux", length = 255)
    private String patternFlux;

    @Column(name = "obligatoire", length = 10)
    private String obligatoire;


    @Column(name = "desc_cpm_flux")
    private String descCpmFlux;

    @Column(name = "format_composant")
    private String formatComposant;


    @Column(name = "liste_attributs")
    private String listeAttributs;

    @Column(name = "separateur", length = 10)
    private String separateur;


    @Column(name = "critere_filtre")
    private String critereFiltre;


    @Column(name = "critere_filtre_technique")
    private String critereFiltreTechnique;

    @Column(name = "nom_table_cible", length = 255)
    private String nomTableCible;

    @Column(name = "cpm_actif", length = 10)
    private String cpmActif;

    @Column(name = "usr_crea", length = 90)
    private String usrCrea;

    @Column(name = "dat_crea")
    private LocalDateTime datCrea;

    @Column(name = "user_upd", length = 90)
    private String userUpd;

    @Column(name = "dat_upd")
    private LocalDateTime datUpd;
}
