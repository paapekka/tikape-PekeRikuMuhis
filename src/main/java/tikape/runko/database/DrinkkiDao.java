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
import tikape.runko.domain.Drinkki;

/**
 *
 * @author pekka
 */
public class DrinkkiDao implements Dao<Drinkki, Integer> {

    private Database database;

    public DrinkkiDao(Database database) {
        this.database = database;
    }

    @Override
    public Drinkki findOne(Integer key) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Drinkki WHERE id = ?");
        stmt.setObject(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        Integer id = rs.getInt("id");
        String nimi = rs.getString("nimi");
        String tekotapa = rs.getString("tekotapa");
        Double vahvuus = rs.getDouble("vahvuus");
        String lasi = rs.getString("lasi");
        String ajankohta = rs.getString("ajankohta");
        String ohje = rs.getString("ohje");

        Drinkki o = new Drinkki(nimi, id, vahvuus, tekotapa, lasi, ohje, ajankohta);

        rs.close();
        stmt.close();
        connection.close();

        return o;
    }

    @Override
    public List<Drinkki> findAll() throws SQLException {

        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Drinkki");

        ResultSet rs = stmt.executeQuery();
        List<Drinkki> drinkit = new ArrayList<>();
        while (rs.next()) {
            Integer id = rs.getInt("id");
            String nimi = rs.getString("nimi");
            String tekotapa = rs.getString("tekotapa");
            Double vahvuus = rs.getDouble("vahvuus");
            String lasi = rs.getString("lasi");
            String ajankohta = rs.getString("ajankohta");
            String ohje = rs.getString("ohje");

            drinkit.add(new Drinkki(nimi, id, vahvuus, tekotapa, lasi,ohje, ajankohta));
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

    public void lisaaDrinkki(Drinkki drinkki) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO Drinkki (nimi, tekotapa, vahvuus, lasi, ohje, ajankohta) values (?, ?, ?, ?, ?, ?, ?)");

        stmt.setString(1, drinkki.getNimi());
        stmt.setString(2, drinkki.getTekotapa());
        stmt.setDouble(3, drinkki.getVahvuus());
        stmt.setString(4, drinkki.getLasi());
        stmt.setString(5, drinkki.getOhje());
        stmt.setString(6, drinkki.getAjankohta());
        stmt.executeUpdate();

        stmt.close();
        connection.close();

    }

}
