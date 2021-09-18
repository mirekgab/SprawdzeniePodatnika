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

import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.apache.commons.lang3.CharSequenceUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author mirek
 */
public class Funkcje {

    public static final String[] TABLICA1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

    static boolean czyJestMaska(String nrb, String maska) {
        int idx1 = StringUtils.indexOfAny(maska, TABLICA1);
        int idx2 = StringUtils.lastIndexOfAny(maska, TABLICA1);
        String kontoWzor = maska.substring(idx1, idx2 + 1);
        if (nrb.indexOf(kontoWzor) >= 0) {
            return true;
        };
        return false;
    }

    public static String konto(String maska, String konto) {
        char[] tablicaWynik = new char[konto.length()];
        char[] tablicaKonto = konto.toCharArray();
        char[] tablicaMaska = maska.toCharArray();
        for (int a = 0; a < tablicaMaska.length; a++) {
            char c = tablicaMaska[a];
            if (c == 'X') {
                tablicaWynik[a] = 'X';
            } else if (c == 'Y') {
                tablicaWynik[a] = tablicaKonto[a];
            } else if (c >= '0' && c <= '9') {
                tablicaWynik[a] = c;
            }
        }
        return String.valueOf(tablicaWynik);
    }

    static int sprawdzDane(WynikJson plikJson, DanePodatnika d, List<String> maski) throws NoSuchAlgorithmException {
        for (String m : maski) {
            if (czyJestMaska(d.getNrb(), m)) {
                d.setNrbWirtualny(konto(m, d.getNrb()));
                int b = PlikJsonSerwis.szukaj(plikJson, ObliczHash.obliczHash(
                        plikJson.getDataGenerowaniaDanych(),
                        d.getNip(), 
                        d.getNrbWirtualny(), 
                        plikJson.getLiczbaTransformacji()));
                //jeżeli b>0, to znalazłem dane w pliku i zwracam wynik;
                if (b>0) {
                    return b;
                }
            }
        }

        return 0;
    }

}
