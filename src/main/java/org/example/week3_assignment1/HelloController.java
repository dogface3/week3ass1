package org.example.week3_assignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Locale;
import java.util.ResourceBundle;


public class HelloController {
    @FXML
    private ComboBox<String> languageComboBox;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private TextField Fname;
    @FXML
    private TextField Lname;
    @FXML
    private TextField email;
    private ResourceBundle bundle;

    @FXML
    private void initialize() {
        languageComboBox.getItems().addAll("en", "fa", "ja");
        languageComboBox.setValue("en");
        updateLanguage();
    }

    @FXML
    private void onLanguageChange() {
        updateLanguage();
    }
    private void updateLanguage() {
        String selectedLanguage = languageComboBox.getValue();

        Locale locale;
        switch (selectedLanguage) {
            case "fa":
                locale = new Locale("FR");
                break;
            case "ja":
                locale = new Locale("JP");
                break;
            default:
                locale = new Locale("EN");
                break;
        }
        bundle = ResourceBundle.getBundle("bundle", locale);
        label1.setText(bundle.getString("label1.text"));
        label2.setText(bundle.getString("label2.text"));
        label3.setText(bundle.getString("label3.text"));
}

    public void saveClick() {
        String fName = Fname.getText();
        String LName = Lname.getText();
        String Email = email.getText();
        String lang = languageComboBox.getValue();

        DbConnection dbConnector = new DbConnection();
        String insertQuery = "INSERT INTO employee_"+lang+" (first_name, last_name, email) VALUES (?, ?, ?)";
        dbConnector.executeUpdate(insertQuery, fName, LName, Email);
        dbConnector.closeConnection();
    }
    }
