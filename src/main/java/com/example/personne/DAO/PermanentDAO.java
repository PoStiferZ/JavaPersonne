package com.example.personne.DAO;

import com.example.personne.Model.Permanent;
import com.example.personne.Util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PermanentDAO {

    Connection connection = Database.getConnection();
    private int personneId;
    private int enseignantId;

    public void createPersonne(Permanent permanent) {

        String query = "INSERT INTO personne (nom, numeroSecu) VALUES (?,?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, permanent.getNom());
            preparedStatement.setString(2, permanent.getNumeroSecu());

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

        String query2 = "INSERT INTO enseignant (nombreCours, specialite, ID_Personne) VALUES (?,?,?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query2, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, permanent.getNombreCours());
            preparedStatement.setString(2, permanent.getSpecialite());
            preparedStatement.setInt(3, personneId);


            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    enseignantId = generatedKeys.getInt(1);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String query3 = "INSERT INTO permanent (numeroBureau, ID_Enseignant) VALUES (?,?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query3)) {
            preparedStatement.setInt(1, permanent.getNumeroBureau());
            preparedStatement.setInt(2, enseignantId);

            int rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
