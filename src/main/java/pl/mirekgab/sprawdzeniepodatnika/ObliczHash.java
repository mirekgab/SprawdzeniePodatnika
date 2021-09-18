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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author mirek
 */
public class ObliczHash {

    public static String obliczHash(String data, String nip, String nrb, int liczbaTransformacji) throws NoSuchAlgorithmException {
        String wartoscHash;
        String dane = data+nip;
        if (nrb.length()>0) {
            dane = dane + nrb;
        }
        wartoscHash = dane;
        for (int a = 0; a < liczbaTransformacji; a++) {
            wartoscHash = hash(wartoscHash);
        }
        return wartoscHash;
    }

    public static String hash(String dane) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        byte[] wynik = md.digest(dane.getBytes());
        StringBuilder sbWynik = new StringBuilder();
        for (int a = 0; a < wynik.length; a++) {
            sbWynik.append(Integer.toString((wynik[a] & 0xff) + 0x100, 16).substring(1));
        }
        return sbWynik.toString();
    }
}
