/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tikape.runko.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tikape.runko.domain.DrinkkiAines;

/**
 *
 * @author pekka
 */
public class DrinkkiAinesDao implements Dao<DrinkkiAines,Integer> {
    
    private Database database;

    public DrinkkiAinesDao(Database database) {
        this.database = database;
    }

    @Override
    public DrinkkiAines findOne(Integer key) throws SQLException {
    
    return null;
        
    }

    @Override
    public List<DrinkkiAines> findAll() throws SQLException {

        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Drinkki");

        ResultSet rs = stmt.executeQuery();
        List<DrinkkiAines> drinkit = new ArrayList<>();
        while (rs.next()) {
            Integer id = rs.getInt("id");
            String nimi = rs.getString("nimi");
            String tekotapa = rs.getString("tekotapa");
            Double vahvuus = rs.getDouble("vahvuus");
            String lasi = rs.getString("lasi");
            String ajankohta = rs.getString("ajankohta");
            drinkit.add(new Drinkki(nimi, id, vahvuus, tekotapa, lasi, ajankohta));
        }

        rs.close();
        stmt.close();
        connection.close();

        return drinkit;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        System.out.println("Älä tee sitä");
    }
    
   /* 
    public void lisaaDrinkki(DrinkkiAines drinkkiaines) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO Drinkki (ohje, maara, drinkki_id, aines_id) values (?, ?, ?, ?)");
        
        stmt.setString(1, drinkkiaines.getOhje());
        stmt.setInt(2, drinkkiaines.getMaara());
        stmt.setInt(3, drinkkiaines.getDrinkki_id());
        stmt.setInt(4, drinkkiaines.getAinesosa_id());
        stmt.executeUpdate();
        
        stmt.close();
        connection.close();

    }*/
    
    
    
}
