package com.poc.springbatch.batch.processor;

import com.poc.springbatch.batch.reader.FileLine;
import com.poc.springbatch.misc.BackOffice;
import com.poc.springbatch.model.FluxId;
import com.poc.springbatch.model.TFluxBrutFmntFixe;
import com.poc.springbatch.repository.ActesGestionRepository;
import com.poc.springbatch.repository.StatutsMvtRepository;
import com.poc.springbatch.repository.TypesMvtRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class FileProcessor implements ItemProcessor<FileLine, TFluxBrutFmntFixe> {

   private final ActesGestionRepository  actesGestionRepository;
   private final StatutsMvtRepository statutsMvtRepository;
   private final TypesMvtRepository typesMvtRepository;

   public static final String CODE_BO = "RIVAGE";

    @Override
    public TFluxBrutFmntFixe process(FileLine item) throws Exception {
        long startTime = System.currentTimeMillis();
        TFluxBrutFmntFixe tFluxBrutFmntFixe = null;
        // Processing logic
        String line = item.getLine();
        String fileType = item.getFileType();

        List<String> actesGestion = actesGestionRepository.getcodeActeByCodeBO(CODE_BO);
        List<String> typesMvt     = typesMvtRepository.getcodeTypeMvtByCodeBO(CODE_BO);
        List<String> statutsMvt   = statutsMvtRepository.getcodeStatutsMvtByCodeBO(CODE_BO);

        if (fileType.equals("CRE-ADMIN")) {
            // Validation logic for CRE-ADMIN

            Optional<String> valideLine = Optional.of(line.substring(174, 174 + 30).strip())
                    .filter(cle -> line.substring(138, 138 + 2).equals("Z3"))
                    .filter(cle -> {
                        String gestionCode = line.substring(25, 25 + 4).strip();
                        return gestionCode.equals("0000") || gestionCode.equals("9999") || actesGestion.contains(cle);
                    });

            if (valideLine.isPresent()) {
                tFluxBrutFmntFixe = processCreAdmin(item, line);
            }

        } else if (fileType.equals("CRE-COMPTA")) {
            // Validation logic for CRE-COMPTA

            Optional<String> validLine = Optional.of(line.substring(174, 174 + 30).strip())
                    .filter(cle -> line.substring(138, 138 + 2).equals("Z3"))
                    .filter(cle -> {
                        String gestionCode = line.substring(25, 25 + 4).strip();
                        String typeMvt = line.substring(204, 204 + 6).strip();
                        String statutMvt = line.substring(230, 230 + 20).strip();
                        return gestionCode.equals("0000") || gestionCode.equals("9999")
                                || actesGestion.contains(cle)
                                || typesMvt.contains(typeMvt)
                                || statutsMvt.contains(statutMvt);
                    });

            if (validLine.isPresent()) {
                tFluxBrutFmntFixe = processCreCompta(item, line);
            }
        }

        long duration = System.currentTimeMillis() - startTime;
        log.info("Processed line from file type {} in {} ms", fileType, duration);

        return tFluxBrutFmntFixe;
    }

    private static TFluxBrutFmntFixe processCreAdmin(FileLine item, String line) {
        return TFluxBrutFmntFixe.builder()
                .fluxId(FluxId.builder().idFlx(item.getFileNumber()).numLigne(item.getLineNumber()).build())
                .sourceFlx(BackOffice.RIVAGE)
                .typeFlx("CRE-ADMIN")
                .typeLigne(line.substring(25, 25 + 4).strip())
                .cleIdent(line.substring(174, 174 + 30).strip())
                .idRappro(line.substring(92, 92 + 13).strip())
                .valeurLigne(line)
                .build();
    }

    private static TFluxBrutFmntFixe processCreCompta(FileLine item, String line) {
        return TFluxBrutFmntFixe.builder()
                .fluxId(FluxId.builder().idFlx(item.getFileNumber()).numLigne(item.getLineNumber()).build())
                .sourceFlx(BackOffice.RIVAGE)
                .typeFlx("CRE-COMPTA")
                .typeLigne(line.substring(25, 25 + 4).strip())
                .cleIdent(line.substring(174, 174 + 30).strip())
                .idRappro(line.substring(92, 92 + 13).strip())
                .valeurLigne(line)
                .build();
    }
}
