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

import java.util.List;

/**
 *
 * @author mirek
 */
public class WynikJson {
    private String dataGenerowaniaDanych;
    private Integer liczbaTransformacji;
    private String schemat;
    private List<String> skrotyPodatnikowCzynnych;
    private List<String> skrotyPodatnikowZwolnionych;
    private List<String> maski;   

    public String getDataGenerowaniaDanych() {
        return dataGenerowaniaDanych;
    }

    public void setDataGenerowaniaDanych(String dataGenerowaniaDanych) {
        this.dataGenerowaniaDanych = dataGenerowaniaDanych;
    }

    public Integer getLiczbaTransformacji() {
        return liczbaTransformacji;
    }

    public void setLiczbaTransformacji(Integer liczbaTransformacji) {
        this.liczbaTransformacji = liczbaTransformacji;
    }

    public String getSchemat() {
        return schemat;
    }

    public void setSchemat(String schemat) {
        this.schemat = schemat;
    }

    public List<String> getSkrotyPodatnikowCzynnych() {
        return skrotyPodatnikowCzynnych;
    }

    public void setSkrotyPodatnikowCzynnych(List<String> skrotyPodatnikowCzynnych) {
        this.skrotyPodatnikowCzynnych = skrotyPodatnikowCzynnych;
    }

    public List<String> getSkrotyPodatnikowZwolnionych() {
        return skrotyPodatnikowZwolnionych;
    }

    public void setSkrotyPodatnikowZwolnionych(List<String> skrotyPodatnikowZwolnionych) {
        this.skrotyPodatnikowZwolnionych = skrotyPodatnikowZwolnionych;
    }

    public List<String> getMaski() {
        return maski;
    }

    public void setMaski(List<String> maski) {
        this.maski = maski;
    }

    @Override
    public String toString() {
        return "WynikJson{" + "dataGenerowaniaDanych=" + dataGenerowaniaDanych + ", liczbaTransformacji=" + liczbaTransformacji + ", schemat=" + schemat + '}';
    }
    
    
}
