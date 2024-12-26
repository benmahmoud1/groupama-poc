package com.poc.springbatch.core;

import jakarta.persistence.Column;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface IValorisationFormatUnique {
    boolean isValidCodeMouvement(String codeMvt);
    String cdLot();
    String noLot();
    LocalDateTime datActe();
    LocalDate datCreatMvt();
    LocalDate datEffMvt();
    String ctrNoMaj();
    String ctrNoOrigin();
    String ctrCdTarif();
    String ctrCateg();

    String ctrCodeProduit();

    String ctrVersionTarifCateg();
    Integer ctrDureeMois();
    Integer ctrDureeAnnee();
    Integer ctrDureePaiementMois();
    LocalDate ctrDernPrimePayee();
    LocalDate mntDatEffPrime();

    LocalDate assDateNaiss();

    Double mntPpTtc();
    Double mntPpHt();
    Double mntTxFraisPp();

    LocalDate ctrDatEff();
    String ctrNoPropo();
    String assIdGrc();
    String assNom();
    String assNomJeuneFille();
    String assPrenom();

    Integer assAgeASouscr();

    String prodMatricule();
    String prodCleMatricule();
    String prodCdGeoCtrOuProd();
    String mntIdAiaPrime();
    Double mntMontantVl();
    LocalDate mntDatEffVl();
    Double mntFraisVl();
    boolean isValidRespectPrecoVl();
    String mntRespectPrecoVl();
    String mntRespectPrecoPp();
    boolean isValidTypeVers(String typeversement);
    boolean isValidFormuleGestion(String formulegestion);
    boolean existsReferenceFormuleGestion();
    boolean isSetFormuleGestion();
    String referenceFormuleGestion();

    String ctrPresenceDeGarantieDePrev();
    String ctrMotifPrincipalAvenant();

}
