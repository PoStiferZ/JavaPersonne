package com.example.personne.DAO;

import com.example.personne.Model.Avocat;
import com.example.personne.Model.Vendeur;
import com.example.personne.Util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendeurDAO {
    Connection connection = Database.getConnection();
    private int personneId;

    public void createPersonne(Vendeur vendeur) {

        String query = "INSERT INTO personne (nom, numeroSecu) VALUES (?,?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, vendeur.getNom());
            preparedStatement.setString(2, vendeur.getNumeroSecu());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    personneId = generatedKeys.getInt(1);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String query2 = "INSERT INTO vendeur (anciennete, nomDuStand, ID_Personne) VALUES (?,?,?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query2)) {
            // Convertir java.util.Date en java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(vendeur.getAnciennete().getTime());

            preparedStatement.setDate(1, sqlDate);
            preparedStatement.setString(2, vendeur.getNomDuStand());
            preparedStatement.setInt(3, personneId);

            int rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
