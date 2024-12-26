package com.poc.springbatch.model;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadFiles {

    @Id
    @Column(name = "id_fic")
    private int idFic;

    @Column(name = "nom_fic", length = 255, nullable = false)
    private String nomFic;

    @Column(name = "chk_fic", length = 100, nullable = false)
    private String chkFic;

    @Column(name = "source_fic", length = 90, nullable = false)
    private String sourceFic;

    @Column(name = "user_crea", length = 90, nullable = false)
    private String userCrea;

    @Column(name = "dt_crea")
    private LocalDateTime dtCrea;

    @Column(name = "user_upd", length = 90)
    private String userUpd;

    @Column(name = "dt_upd")
    private LocalDateTime dtUpd;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut_fic", length = 2)
    private StatutFic statutFic;


}
