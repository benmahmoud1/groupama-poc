package com.poc.springbatch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_historique_traitement")
public class HistoriqueTraitement {

    @Id
    @EmbeddedId
    private HistoriqueTraitementId historiqueTraitementId;

    @Column(name = "code_regle", length = 90)
    private String codeRegle;

    @Column(name = "code_message", length = 90)
    private String codeMessage;

    @Column(name = "texte_message", columnDefinition = "TEXT")
    private String texteMessage;

    @Column(name = "user_crea", length = 90)
    private String userCrea;

    @Column(name = "dat_crea")
    private LocalDateTime datCrea;

    @Column(name = "user_upd", length = 90)
    private String userUpd;

    @Column(name = "dat_upd")
    private LocalDateTime datUpd;

}
