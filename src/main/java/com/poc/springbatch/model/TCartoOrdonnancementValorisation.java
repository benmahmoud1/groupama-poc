package com.poc.springbatch.model;

import jakarta.persistence.*;
import lombok.*;

import static com.poc.springbatch.misc.Queries.*;

@SqlResultSetMapping(name = "mapReglesValorisation",
            classes = {
            @ConstructorResult(targetClass = ReglesValorisation.class, columns = {
                    @ColumnResult(name = "fluxMaitre", type = String.class),
                    @ColumnResult(name = "codeCas", type = String.class),
                    @ColumnResult(name = "noSequence", type = Integer.class),
                    @ColumnResult(name = "nomChampFormatUnique", type = String.class),
                    @ColumnResult(name = "noCritere", type = Integer.class),
                    @ColumnResult(name = "obligatoire", type = String.class),
                    @ColumnResult(name = "valeurParDefaut", type = String.class),
                    @ColumnResult(name = "conditionValo", type = String.class),
                    @ColumnResult(name = "conditionValoTechnique", type = String.class),
                    @ColumnResult(name = "expressionValeur", type = String.class),
                    @ColumnResult(name = "expressionValeurTechnique", type = String.class),
                    @ColumnResult(name = "codeRegle", type = String.class),
                    @ColumnResult(name = "codeMessage", type = String.class),
                    @ColumnResult(name = "texteInfoMessage", type = String.class),
                    @ColumnResult(name = "texteErreurMessage", type = String.class)
            })
        })
@NamedNativeQuery(name = "query.SEL_REGLE_VALO",
                  query = SEL_REGLE_VALO,
                  resultSetMapping = "mapReglesValorisation")

@SqlResultSetMapping(name = "mapOrdonnancement",
        classes = {
                @ConstructorResult(targetClass = CartoOrdonnancementValorisation.class, columns = {
                        @ColumnResult(name = "fluxMaitre", type = String.class),
                        @ColumnResult(name = "numOrdre", type = Integer.class),
                        @ColumnResult(name = "codeCasPrinc", type = String.class),
                        @ColumnResult(name = "codeCasSecond", type = String.class),
                        @ColumnResult(name = "actif", type = String.class)
                })
        })
@NamedNativeQuery(
        name = "query.SEL_ORDO_VALO",
        query = SEL_ORDO_VALO,
        resultSetMapping = "mapOrdonnancement"
)

@Data  @NoArgsConstructor @AllArgsConstructor @ToString
@Builder
@Entity
@Table(name = "t_carto_ordonnancement_valorisation")
public class TCartoOrdonnancementValorisation {

    @Id
    @Column(name = "num_ordre", nullable = false)
    private Integer numOrdre;

    @ManyToOne
    @JoinColumn(name = "code_cas_princ", nullable = false)
    private TCasValorisation casPrincipal;

    @ManyToOne
    @JoinColumn(name = "code_cas_second")
    private TCasValorisation casSecondaire;

    @Column(name = "desc_ordonnancement", length = 255)
    private String descOrdonnancement;

    @Column(name = "actif", columnDefinition = "enum('O', 'N')")
    private String actif;


}
