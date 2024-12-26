package com.poc.springbatch.model;

import com.poc.springbatch.dto.TInfosFormule;
import com.poc.springbatch.dto.TInfosTarifCateg;
import jakarta.persistence.*;
import lombok.*;

import static com.poc.springbatch.misc.Queries.*;

@SqlResultSetMapping(name = "mapFormuleGestion",
        classes = {
                @ConstructorResult(targetClass = TInfosFormule.class, columns = {
                        @ColumnResult(name = "codeFormule", type = String.class),
                        @ColumnResult(name = "codeGtAia", type = String.class),
                })
        })
@NamedNativeQuery(
        name = "query.SELECT_FORMULE",
        query = SELECT_FORMULE,
        resultSetMapping = "mapFormuleGestion"
)

@SqlResultSetMapping(name = "mapTarfifCateg",
        classes = {
                @ConstructorResult(targetClass = TInfosTarifCateg.class, columns = {
                        @ColumnResult(name = "tarif", type = String.class),
                        @ColumnResult(name = "categorie", type = String.class),
                        @ColumnResult(name = "version", type = String.class),
                })
        })
@NamedNativeQuery(
        name = "query.SELECT_TARIF_CATEG",
        query = SELECT_TARIF_CATEG,
        resultSetMapping = "mapTarfifCateg"
)

@Data  @NoArgsConstructor @AllArgsConstructor @ToString
@Builder
@Entity
@Table(name = "t_regles_valorisation")
public class TReglesValorisation {
    @Id
    @ManyToOne
    @JoinColumn(name = "code_cas", nullable = false)
    private TCasValorisation casValorisation;

    @Id
    @Column(name = "no_sequence", nullable = false)
    private Integer noSequence;

    @Id
    @Column(name = "nom_champ_format_unique", nullable = false, length = 255)
    private String nomChampFormatUnique;

    @Id
    @Column(name = "no_critere", nullable = false)
    private Integer noCritere;

    @Column(name = "obligatoire", columnDefinition = "enum('O', 'N')")
    private String obligatoire;

    @Column(name = "valeur_par_defaut", columnDefinition = "enum('O', 'N')")
    private String valeurParDefaut;

    @Lob
    @Column(name = "condition_valo")
    private String conditionValo;

    @Lob
    @Column(name = "condition_valo_technique")
    private String conditionValoTechnique;

    @Lob
    @Column(name = "expression_valeur")
    private String expressionValeur;

    @Lob
    @Column(name = "expression_valeur_technique")
    private String expressionValeurTechnique;

    @Column(name = "code_regle", length = 90)
    private String codeRegle;

    @Column(name = "code_message", length = 90)
    private String codeMessage;

    @Lob
    @Column(name = "texte_info_message")
    private String texteInfoMessage;

    @Lob
    @Column(name = "texte_erreur_message")
    private String texteErreurMessage;


}
