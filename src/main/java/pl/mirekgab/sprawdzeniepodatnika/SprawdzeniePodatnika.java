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
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.json.simple.parser.ParseException;

/**
 *
 * @author mirek
 */
public class SprawdzeniePodatnika {

    private WynikJson wynikJson;
    private DaneTestoweSerwis daneTestowe;
    private List<DanePodatnika> listaDane;

    public String dataGenerowaniaDanych() {
        return wynikJson.getDataGenerowaniaDanych();
    }

    public String liczbaIteracji() {
        return String.valueOf(wynikJson.getLiczbaTransformacji());
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("liczba danych testowych ")
                .append(listaDane.size())
                .append("\nliczba danych podatnik czynny ")
                .append(wynikJson.getSkrotyPodatnikowCzynnych().size())
                .append("\nliczba danych podatnik zwolniony ")
                .append(wynikJson.getSkrotyPodatnikowZwolnionych().size())
                .append("\nliczba transformacji ")
                .append(wynikJson.getLiczbaTransformacji())
                .append("\ndata generowania danych ")
                .append(wynikJson.getDataGenerowaniaDanych());
        return sb.toString();
    }

    public void wczytajPlikDanych(String plikDane, int liczbaLiniiNaglowka) throws IOException {
        DaneTestoweSerwis daneTestowe = new DaneTestoweSerwis();
        listaDane = daneTestowe.wczytaj(plikDane, liczbaLiniiNaglowka);

    }

    public void wczytajPlikJson(String plikJson) throws IOException, FileNotFoundException, ParseException {
        wynikJson = PlikJsonSerwis.wczytaj(plikJson);

        String data = wynikJson.getDataGenerowaniaDanych();
        int liczbaTransformacji = wynikJson.getLiczbaTransformacji();

    }

    public List<DanePodatnika> sprawdz() throws NoSuchAlgorithmException {
        String data = wynikJson.getDataGenerowaniaDanych();
        int liczbaTransformacji = wynikJson.getLiczbaTransformacji();

        for (DanePodatnika d : listaDane) {
            int b = PlikJsonSerwis.szukaj(wynikJson, ObliczHash.obliczHash(data, d.getNip(), d.getNrb(), liczbaTransformacji));
            d.setWynikWeryfikacji(b);
        }

        //teraz sprawdzam podatników, którzy nie byli na liście czynnych i zamkniętych
        for (DanePodatnika d : listaDane) {
            //jeżeli brak danych do tej pory, to sprawdzam maski rachunków bankowych
            if (d.getWynikWeryfikacji() == 0) {
                int wynik = Funkcje.sprawdzDane(wynikJson, d, wynikJson.getMaski());
                d.setWynikWeryfikacji(wynik);
            }
        }

        return listaDane;
    }

    public List<DanePodatnika> getListaDane() {
        return listaDane;
    }

    /**
     * @param plikDane plik z danymi NIP[tabulator]RACHUNEK_BANKOWY
     * @param liczbaLiniiNaglowka liczba linii komentarza w plikDane
     * @param plikPlaski plik json publikowany przez MF
     * @return lista obiektów DanePodatnika
     * @throws java.io.IOException
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.io.FileNotFoundException
     * @throws org.json.simple.parser.ParseException
     */
//    public List<DanePodatnika> sprawdzDane(String plikDane, int liczbaLiniiNaglowka, String plikPlaski) throws IOException, NoSuchAlgorithmException, FileNotFoundException, ParseException {
//        
//        DaneTestoweSerwis daneTestowe = new DaneTestoweSerwis();
//        List<DanePodatnika> lista = daneTestowe.wczytaj(plikDane, liczbaLiniiNaglowka);
//
//        WynikJson plikJson = PlikJsonSerwis.wczytaj(plikPlaski);
//        
//        String data = plikJson.getDataGenerowaniaDanych();
//        int liczbaTransformacji = plikJson.getLiczbaTransformacji();
//
//        System.out.println("wczytano");
//        System.out.println(plikJson.getSkrotyPodatnikowCzynnych().size()+" czynnych");
//        System.out.println(plikJson.getSkrotyPodatnikowZwolnionych().size()+" zwolnionych");
//        System.out.println(plikJson.getMaski().size()+" maski");        
//
//        for (DanePodatnika d : lista) {
//            int b = PlikJsonSerwis.szukaj(plikJson, ObliczHash.obliczHash(data, d.getNip(), d.getNrb(), liczbaTransformacji));
//            d.setWynikWeryfikacji(b);
//        }
//
//        //teraz sprawdzam podatników, którzy nie byli na liście czynnych i zamkniętych
//        for (DanePodatnika d : lista) {
//            //jeżeli brak danych do tej pory, to sprawdzam maski rachunków bankowych
//            if (d.getWynikWeryfikacji() == 0) {
//                int wynik = Funkcje.sprawdzDane(plikJson, d, plikJson.getMaski());
//                d.setWynikWeryfikacji(wynik);
//            }
//        }
//
//        return lista;
//    }
}
