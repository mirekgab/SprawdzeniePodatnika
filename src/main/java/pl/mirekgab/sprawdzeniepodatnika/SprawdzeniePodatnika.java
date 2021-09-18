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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, FileNotFoundException, ParseException {
        System.out.println("Sprawdzenie podatnika");
        
        if (args==null || args.length!=2) {
            System.out.println("Wywołanie programu: SprawdzeniePodatnika \"plikDane\" \"plikPlaski\"");
            System.exit(0);
        }
        
        String plikDane = args[0];
        String  plikPlaski = args[1];
        
        DaneTestoweSerwis daneTestowe = new DaneTestoweSerwis();
        List<DanePodatnika> lista = daneTestowe.wczytaj(plikDane);

        WynikJson plikJson = PlikJsonSerwis.wczytaj(plikPlaski);
        
        String data = plikJson.getDataGenerowaniaDanych();
        int liczbaTransformacji = plikJson.getLiczbaTransformacji();

        System.out.println("wczytano");
        System.out.println(plikJson.getSkrotyPodatnikowCzynnych().size()+" czynnych");
        System.out.println(plikJson.getSkrotyPodatnikowZwolnionych().size()+" zwolnionych");
        System.out.println(plikJson.getMaski().size()+" maski");        

        for (DanePodatnika d : lista) {
            int b = PlikJsonSerwis.szukaj(plikJson, ObliczHash.obliczHash(data, d.getNip(), d.getNrb(), liczbaTransformacji));
            d.setWynikWeryfikacji(b);
        }

        //teraz sprawdzam podatników, którzy nie byli na liście czynnych i zamkniętych
        for (DanePodatnika d : lista) {
            //jeżeli brak danych do tej pory, to sprawdzam maski rachunków bankowych
            if (d.getWynikWeryfikacji() == 0) {
                int wynik = Funkcje.sprawdzDane(plikJson, d, plikJson.getMaski());
                d.setWynikWeryfikacji(wynik);
            }
        }

        for (DanePodatnika d : lista) {
            System.out.println(d);
        }
    }

}
