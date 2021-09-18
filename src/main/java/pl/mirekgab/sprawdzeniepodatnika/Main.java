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

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author mirek
 */
public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Sprawdzenie podatnika");

            if (args == null || args.length != 3) {
                System.out.println("Wywołanie programu: SprawdzeniePodatnika \"plikDane\" liczbaLiniiNaglowka \"plikPlaski\"");
                System.exit(0);
            }

            String plikDane = args[0];
            Integer liczbaLiniiNaglowka = Integer.parseInt(args[1]);
            String plikPlaski = args[2];

            SprawdzeniePodatnika sp = new SprawdzeniePodatnika();
            sp.wczytajPlikDanych(plikDane, liczbaLiniiNaglowka);
            sp.wczytajPlikJson(plikPlaski);
            
            List<DanePodatnika> lista = sp.sprawdz();

            for (DanePodatnika d : lista) {
                System.out.println(d);
            }

        } catch (IOException | NoSuchAlgorithmException | ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
