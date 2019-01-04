package utils;

import java.text.Normalizer;

public class OUtils {
    public static String makeUriFriendly(String str){
        return Normalizer.normalize(str, Normalizer.Form.NFD)
                .replaceAll("\\p{Mn}", "")
                .replace('ı','i')
                .replace("'", "")
                .replace("’", "")
                .replaceAll("[,/]", " ")
                .replaceAll("[\\s.]+","_")
                .toLowerCase();
    }
}
