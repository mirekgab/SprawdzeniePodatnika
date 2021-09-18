/*
 * Copyright (C) 2021 mirek.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package pl.mirekgab.sprawdzeniepodatnika;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author mirek
 */
public class PlikJsonSerwis {

    public static WynikJson wczytaj(String plik) throws FileNotFoundException, IOException, ParseException {
        WynikJson wynikJson = new WynikJson();

        FileReader fr = new FileReader(plik);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(fr);

        JSONObject jsonNaglowek = (JSONObject) jsonObject.get("naglowek");

        wynikJson.setDataGenerowaniaDanych((String) jsonNaglowek.get("dataGenerowaniaDanych"));
        wynikJson.setLiczbaTransformacji(Integer.parseInt((String) jsonNaglowek.get("liczbaTransformacji")));
        wynikJson.setSchemat((String) jsonNaglowek.get("schemat"));

        List<String> listaPodatnikCzynny = (List<String>) jsonObject.get("skrotyPodatnikowCzynnych");
        wynikJson.setSkrotyPodatnikowCzynnych(listaPodatnikCzynny);

        List<String> listaPodatnikZwolniony = (List<String>) jsonObject.get("skrotyPodatnikowZwolnionych");
        wynikJson.setSkrotyPodatnikowZwolnionych(listaPodatnikZwolniony);

        List<String> listaMaski = (List<String>) jsonObject.get("maski");
        wynikJson.setMaski(listaMaski);

        return wynikJson;
    }

    /**
     * Metoda wyszukuje podatnika wg przełanego hasha.
     *
     * @param wynik
     * @param dane
     * @return 0 - brak danych<br>
     * 1 - podatnik jest na liście podatników czynnych<br>
     * 2 - podatnik jest na liście podatników zwolnionych<br>
     */
    public static Integer szukaj(WynikJson wynik, String dane) {
        for (String s : wynik.getSkrotyPodatnikowCzynnych()) {
            if (s.equals(dane)) {
                return DanePodatnika.WYNIK_PODATNIK_CZYNNY;
            }
        }
        for (String s : wynik.getSkrotyPodatnikowZwolnionych()) {
            if (s.equals(dane)) {
                return DanePodatnika.WYNIK_PODATNIK_ZWOLNIONY;
            }
        }
        return DanePodatnika.WYNIK_BRAK_DANYCH;
    }

}
