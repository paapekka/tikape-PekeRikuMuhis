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
    
        throw new UnsupportedOperationException("Not supported yet.");
        
    }

    @Override
    public List<DrinkkiAines> findAll() throws SQLException {

        throw new UnsupportedOperationException("Not supported yet.");

        }   

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
   
    public void muokkaaTaiLisaa (DrinkkiAines drinkkiaines) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO Drinkki (ohje, maara, drinkki_id, aines_id) values (?, ?, ?, ?)");
        
        stmt.setString(1, drinkkiaines.getOhje());
        stmt.setInt(2, drinkkiaines.getMaara());
        stmt.setInt(3, drinkkiaines.getDrinkki_id());
        stmt.setInt(4, drinkkiaines.getAinesosa_id());
        stmt.executeUpdate();
        
        stmt.close();
        connection.close();

    }
    
    
    
}
