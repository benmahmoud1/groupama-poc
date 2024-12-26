package com.poc.springbatch.model;


import com.poc.springbatch.misc.BackOffice;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static com.poc.springbatch.misc.Queries.*;

@SqlResultSetMapping(name = "mapSelectSequenceFlux",
        classes = {
                @ConstructorResult(targetClass = String.class, columns = {
                        @ColumnResult(name = "valeur_rubrique", type = String.class)
                })
        })
@NamedNativeQuery(
        name = "query.SELECT_SEQUENCE_FLX",
        query = SELECT_SEQUENCE_FLX,
        resultSetMapping = "mapSelectSequenceFlux"
)

@SqlResultSetMapping(name = "updateResult", columns = { @ColumnResult(name = "count") })
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "query.UPDATE_FORMAT_FIX_STATUT",
                query = UPDATE_FORMAT_FIX_STATUT,
                resultSetMapping = "updateResult"
        ),
        @NamedNativeQuery(
                name = "query.UPDATE_SEQUENCE_FLX",
                query = UPDATE_SEQUENCE_FLX,
                resultSetMapping = "updateResult"
        ),
        @NamedNativeQuery(
                name = "query.SELECT_PRESENCE_PREV",
                query = SELECT_PRESENCE_PREV,
                resultSetMapping = "updateResult"
        )
})


/*
SELECT_FORMULE
SELECT_TARIF_CATEG
SELECT_PRESENCE_PREV
*/

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Builder
@Entity
@Table(name = "t_flux_brut_fmnt_fixe")
//@IdClass(FluxId.class)
public class TFluxBrutFmntFixe {

    @Id
    @EmbeddedId
    private FluxId fluxId;


    @Enumerated(EnumType.STRING)
    @Column(name = "source_flx", nullable = false)
    private BackOffice sourceFlx;

    @Column(name = "type_flx", length = 90)
    private String typeFlx;

    @Column(name = "type_ligne", length = 50)
    private String typeLigne;

    @Column(name = "cle_ident", length = 150)
    private String cleIdent;

    @Column(name = "id_rappro", length = 90)
    private String idRappro;

    @Column(name = "dt_crea")
    private LocalDateTime dtCrea;

    @Column(name = "dt_upd")
    private LocalDateTime dtUpd;

    @Column(name = "statut_flx")
    private String statutFlx;

    @Lob
    @Column(name = "valeur_ligne")
    private String valeurLigne;
}
