package com.poc.springbatch.misc;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
@Slf4j
@NoArgsConstructor(access= AccessLevel.PRIVATE)
public final class UtilsTools {

    public final static  String GARANTIE_DECES_PREVOYANCE = "02GD1";
    public final static  String PATTERN_ENTIER = "[0-9]*";
    public final static  String FORMAT_DATETIME = "yyyyMMddHHmmss";
    public final static  String FORMAT_DATE = "yyyyMMdd";
    public final static  String FORMAT_DATE000000 = "yyyyMMdd000000";

    private static Map<String, String> positifSignCharacters() {
        Map<String,String> returnMap = new HashMap<>();
        returnMap.put("{", "0");
        returnMap.put("A", "1");
        returnMap.put("B", "2");
        returnMap.put("C", "3");
        returnMap.put("D", "4");
        returnMap.put("E", "5");
        returnMap.put("F", "6");
        returnMap.put("G", "7");
        returnMap.put("H", "8");
        returnMap.put("I", "9");
        return returnMap;
    }

    private static Map<String, String> negatifSignCharacters() {
        Map<String,String> returnMap = new HashMap<>();
        returnMap.put("}", "0");
        returnMap.put("J", "1");
        returnMap.put("K", "2");
        returnMap.put("L", "3");
        returnMap.put("M", "4");
        returnMap.put("N", "5");
        returnMap.put("O", "6");
        returnMap.put("P", "7");
        returnMap.put("Q", "8");
        returnMap.put("R", "9");
        return returnMap;
    }

    public static Double rivageStringToDecimal(String pToConvert) {

        if (pToConvert == null  ) return  null;

        String toConvert = pToConvert.trim();
        var caracterADroite = toConvert.substring(pToConvert.trim().length() -1);

        log.info("caracterADroite : " + caracterADroite);
        log.info("partieGauche : " + toConvert.substring(0, toConvert.length() -1));

        if (!Pattern.matches(PATTERN_ENTIER, toConvert.substring(0, toConvert.length() -1))) {
           throw new ArithmeticException("Format <" + pToConvert + "> non compatible !");
        }
        toConvert = pToConvert;
        if (positifSignCharacters().containsKey(caracterADroite)) {
            for (var entry : positifSignCharacters().entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                toConvert = toConvert.replace(key, value);
            }
        } else if (negatifSignCharacters().containsKey(caracterADroite)) {
            for (var entry : negatifSignCharacters().entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                toConvert = toConvert.replace(key, value);
            }
            toConvert = "-" + toConvert;
        } else {
            throw new ArithmeticException("Format non compatible !");
        }
        log.info("Résultat : " + toConvert);
        return Double.parseDouble(toConvert)/100.0;
    }
}
