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

/**
 *
 * @author mirek
 */
public class DanePodatnika {

    public static final int WYNIK_BRAK_DANYCH = 0;
    public static final int WYNIK_PODATNIK_CZYNNY = 1;
    public static final int WYNIK_PODATNIK_ZWOLNIONY = 2;

    private String nip;
    private String nrb;
    private String nrbWirtualny;
    private int wynikWeryfikacji;

    public DanePodatnika(String nip, String nrb) {
        this.nip = nip;
        this.nrb = nrb;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNrb() {
        return nrb;
    }

    public void setNrb(String nrb) {
        this.nrb = nrb;
    }

    public int getWynikWeryfikacji() {
        return wynikWeryfikacji;
    }

    public void setWynikWeryfikacji(int wynikWeryfikacji) {
        this.wynikWeryfikacji = wynikWeryfikacji;
    }

    public String getNrbWirtualny() {
        return nrbWirtualny;
    }

    public void setNrbWirtualny(String nrbWirtualny) {
        this.nrbWirtualny = nrbWirtualny;
    }

    public String wynikWeryfikacjiTekst() {
        switch (wynikWeryfikacji) {
            case WYNIK_BRAK_DANYCH:
                return "brak danych";
            case WYNIK_PODATNIK_CZYNNY:
                return "podatnik czynny";
            case WYNIK_PODATNIK_ZWOLNIONY:
                return "podatnik zwolniony";
            default:
                return "błędny wynik weryfikacji";
        }
    }

    @Override
    public String toString() {
        return "DanePodatnika{" + "nip=" + nip + ", nrb=" + nrb + ", nrbWirtualny=" + nrbWirtualny + ", wynikWeryfikacji=" + wynikWeryfikacji + " ["+wynikWeryfikacjiTekst()+"]}";
    }

}
