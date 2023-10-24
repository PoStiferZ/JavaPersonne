package com.example.personne.DAO;

import com.example.personne.Model.Avocat;
import com.example.personne.Util.Database;
import com.example.personne.Model.Personne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AvocatDAO {
    Connection connection = Database.getConnection();

    private int personneId;
    public void createPersonne(Avocat avocat) {

        String query = "INSERT INTO personne (nom, numeroSecu) VALUES (?,?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, avocat.getNom());
            preparedStatement.setString(2, avocat.getNumeroSecu());

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

        String query2 = "INSERT INTO avocat (nombreAffaires, adresseCabinet, ID_Personne) VALUES (?,?,?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query2)) {
            preparedStatement.setInt(1, avocat.getNombreAffaires());
            preparedStatement.setString(2, avocat.getAdresseCabinet());
            preparedStatement.setInt(3, personneId);

            int rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

