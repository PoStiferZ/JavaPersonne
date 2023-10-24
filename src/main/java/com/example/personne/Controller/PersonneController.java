package com.example.personne.Controller;

import com.example.personne.DAO.AvocatDAO;
import com.example.personne.DAO.PermanentDAO;
import com.example.personne.DAO.VacataireDAO;
import com.example.personne.DAO.VendeurDAO;
import com.example.personne.Model.*;
import com.example.personne.Util.Database;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class PersonneController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label nomDuStandLabel;
    @FXML
    private Label ancienneteLabel;
    @FXML
    private Label adresseCabinetLabel;
    @FXML
    private Label nombreAffairesLabel;
    @FXML
    private Label nombreCoursLabel;
    @FXML
    private Label specialiteLabel;
    @FXML
    private Label choiceBox2Label;

    @FXML
    private Label numeroBureauLabel;
    @FXML
    private Label nombreVacationsLabel;

    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private ChoiceBox<String> choiceBox2;
    @FXML
    private TextField nomField;
    @FXML
    private TextField numeroSecuField;
    @FXML
    private TextField nombreAffairesField;
    @FXML
    private TextField adresseCabinetField;
    @FXML
    private DatePicker anciennetePicker;
    @FXML
    private TextField nomDuStandField;
    @FXML
    private TextField nombreCoursField;
    @FXML
    private TextField specialiteField;

    @FXML
    private TextField nombreVacationsField;
    @FXML
    private TextField numeroBureauField;

    @FXML
    private Button create;


    public void initialize() {
        choiceBox.getItems().addAll("Avocat", "Vendeur", "Enseignant");
        choiceBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                onChoiceBoxSelected();
            }
        });

        choiceBox2.getItems().addAll("Permanent", "Vacataire");
        choiceBox2.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                onChoiceBoxSelected2();
            }
        });

        Connection connection = Database.getConnection();

        if (connection != null) {
            System.out.println("Connexion à la base de données établie avec succès.");

            // Vous pouvez ajouter ici le code pour effectuer des opérations sur la base de données.

            Database.closeConnection(); // N'oubliez pas de fermer la connexion lorsque vous avez fini.
        } else {
            System.err.println("Échec de la connexion à la base de données.");
        }
    }
    @FXML
    protected void onChoiceBoxSelected() {
        String selectedOption = choiceBox.getValue();

        create.setVisible(true);

        if (selectedOption.equals("Avocat")) {
            nombreAffairesLabel.setVisible(true);
            nombreAffairesField.setVisible(true);
            adresseCabinetLabel.setVisible(true);
            adresseCabinetField.setVisible(true);

            nomDuStandLabel.setVisible(false);
            nomDuStandField.setVisible(false);
            ancienneteLabel.setVisible(false);
            anciennetePicker.setVisible(false);

            nombreCoursLabel.setVisible(false);
            nombreCoursField.setVisible(false);
            specialiteLabel.setVisible(false);
            specialiteField.setVisible(false);
            choiceBox2Label.setVisible(false);
            choiceBox2.setVisible(false);
            create.setLayoutY(490);

        } else if (selectedOption.equals("Vendeur")) {
            ancienneteLabel.setVisible(true);
            anciennetePicker.setVisible(true);
            nomDuStandLabel.setVisible(true);
            nomDuStandField.setVisible(true);

            nombreAffairesLabel.setVisible(false);
            nombreAffairesField.setVisible(false);
            adresseCabinetLabel.setVisible(false);
            adresseCabinetField.setVisible(false);

            nombreCoursLabel.setVisible(false);
            nombreCoursField.setVisible(false);
            specialiteLabel.setVisible(false);
            specialiteField.setVisible(false);
            choiceBox2Label.setVisible(false);
            choiceBox2.setVisible(false);
            create.setLayoutY(490);

        } else if (selectedOption.equals("Enseignant")) {
            ancienneteLabel.setVisible(false);
            anciennetePicker.setVisible(false);
            nomDuStandLabel.setVisible(false);
            nomDuStandField.setVisible(false);

            nombreAffairesLabel.setVisible(false);
            nombreAffairesField.setVisible(false);
            adresseCabinetLabel.setVisible(false);
            adresseCabinetField.setVisible(false);

            nombreCoursLabel.setVisible(true);
            nombreCoursField.setVisible(true);
            specialiteLabel.setVisible(true);
            specialiteField.setVisible(true);
            choiceBox2Label.setVisible(true);
            choiceBox2.setVisible(true);

            create.setLayoutY(709);

        }

    }


    @FXML
    protected void onChoiceBoxSelected2() {
        String selectedOption = choiceBox2.getValue();

        if (selectedOption.equals("Permanent")) {
            numeroBureauLabel.setVisible(true);
            numeroBureauField.setVisible(true);

            nombreVacationsLabel.setVisible(false);
            nombreVacationsField.setVisible(false);

        } else if (selectedOption.equals("Vacataire")) {
            nombreVacationsLabel.setVisible(true);
            nombreVacationsField.setVisible(true);

            numeroBureauLabel.setVisible(false);
            numeroBureauField.setVisible(false);
        }
    }


    @FXML
    protected void createPersonButton() {
        String selectedOption = choiceBox.getValue();
        String selectedOption2 = choiceBox2.getValue();

        if (selectedOption.equals("Avocat")) {
            Avocat avocat = new Avocat(nomField.getText(), numeroSecuField.getText(), Integer.parseInt(nombreAffairesField.getText()), adresseCabinetField.getText());
            welcomeText.setText("Avocat : " + avocat);
            AvocatDAO avocatDAO = new AvocatDAO();
            avocatDAO.createPersonne(avocat);

        } else if (selectedOption.equals("Vendeur")) {
            LocalDate anciennete = anciennetePicker.getValue();
            Date ancienneteDate = Date.from(anciennete.atStartOfDay(ZoneId.systemDefault()).toInstant());
            Vendeur vendeur = new Vendeur(nomField.getText(), numeroSecuField.getText(), ancienneteDate, nomDuStandField.getText());
            welcomeText.setText("Vendeur : " + vendeur);
            VendeurDAO vendeurDAO = new VendeurDAO();
            vendeurDAO.createPersonne(vendeur);

        } else if (selectedOption.equals("Enseignant")) {
           if ( selectedOption2.equals("Permanent")) {
               Permanent permanent = new Permanent(nomField.getText(), numeroSecuField.getText(), Integer.parseInt(nombreCoursField.getText()), specialiteField.getText(), Integer.parseInt(numeroBureauField.getText()));
               welcomeText.setText("Enseignant Permanent : " + permanent);
               PermanentDAO permanentDAO = new PermanentDAO();
               permanentDAO.createPersonne(permanent);

           } else if (selectedOption2.equals("Vacataire")) {
               Vacataire vacataire = new Vacataire(nomField.getText(), numeroSecuField.getText(), Integer.parseInt(nombreCoursField.getText()), specialiteField.getText(), Integer.parseInt(nombreVacationsField.getText()));
               welcomeText.setText("Enseignant vacataire : " + vacataire);
               VacataireDAO vacataireDAO = new VacataireDAO();
               vacataireDAO.createPersonne(vacataire);

           }
        }
    }
}

