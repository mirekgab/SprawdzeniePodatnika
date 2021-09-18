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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mirek
 */
public class DaneTestoweSerwis {

    public List<DanePodatnika> wczytaj(String plik) throws FileNotFoundException, IOException {
        List<DanePodatnika> lista = new ArrayList<>();
     
        FileInputStream fis = new FileInputStream(plik);
        InputStreamReader isr = new InputStreamReader(fis);

        BufferedReader br = new BufferedReader(isr);
        String linia;
        int licznik = 0;
        while ((linia = br.readLine()) != null) {
            if (licznik > 1) {
                String[] rekord = linia.split("\t");
                DanePodatnika dt = new DanePodatnika(rekord[0], rekord[1]);
                lista.add(dt);
            }
            licznik++;
        }
        return lista;
    }
}
