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
public class DrinkkiAines {
    private Integer id;
    private Integer drinkki_id; 
    private Integer ainesosa_id;
    private Integer maara;
    private String ohje;
    
    public DrinkkiAines(Integer id, Integer maara,Integer drinkki_id, Integer ainesosa_id,String ohje) {
        this.id=id;
        this.maara = maara;
        this.drinkki_id=drinkki_id;
        this.ainesosa_id= ainesosa_id;
        this.ohje=ohje;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public Integer getDrinkki_id() {
        return drinkki_id;
    }

    public void setDrinkki_id(Integer drinkki_id) {
        this.drinkki_id = drinkki_id;
    }

    public Integer getAinesosa_id() {
        return ainesosa_id;
    }

    public void setAinesosa_id(Integer ainesosa_id) {
        this.ainesosa_id = ainesosa_id;
    }

  

    public Integer getMaara() {
        return maara;
    }

    public void setMaara(Integer maara) {
        this.maara = maara;
    }

    public String getOhje() {
        return ohje;
    }

    public void setOhje(String ohje) {
        this.ohje = ohje;
    }
    
}
