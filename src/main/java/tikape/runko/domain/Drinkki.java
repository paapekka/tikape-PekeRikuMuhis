/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tikape.runko.domain;

/**
 *
 * @author pekka
 */
public class Drinkki {
    private String nimi;
    private Integer id;
    private double vahvuus;
    private String tekotapa;
    private String lasi;
    private String ajankohta;
    private String ohje;
    
    public Drinkki(String nimi, Integer id, double vahvuus, String tekotapa, String lasi,String ohje, String ajankohta) {
        this.nimi = nimi;
        this.id = id;
        this.vahvuus = vahvuus;
        this.tekotapa = tekotapa;
        this.lasi = lasi;
        this.ajankohta = ajankohta;
        this.ohje=ohje;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getVahvuus() {
        return vahvuus;
    }

    public void setVahvuus(double vahvuus) {
        this.vahvuus = vahvuus;
    }

    public String getTekotapa() {
        return tekotapa;
    }

    public void setTekotapa(String tekotapa) {
        this.tekotapa = tekotapa;
    }

    public String getLasi() {
        return lasi;
    }

    public void setLasi(String lasi) {
        this.lasi = lasi;
    }

    public String getAjankohta() {
        return ajankohta;
    }

    public void setAjankohta(String ajankohta) {
        this.ajankohta = ajankohta;
    }
    
     public String getOhje() {
        return ohje;
    }

    public void setOhje(String ohje) {
        this.ohje = ohje;
    }
}
