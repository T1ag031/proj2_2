package com.example.fx;

import com.example.bd.BLL.AdminBLL;
import com.example.bd.DAL.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class criaradminscontroller {
    private Scene scene;
    private Stage stage;
    @FXML
    private PasswordField PasswordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Text label;

    @FXML
    private TextField nifTextField;

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField usernameTextField;

    @FXML
    void registar(ActionEvent event) {
        if (nomeTextField.getText().equals("") || nifTextField.getText().equals("") || usernameTextField.getText().equals("") ||
                PasswordField.getText().equals("") || confirmPasswordField.getText().equals("")){
            noSuccessAlert();
        }else {
            Admin f = new Admin();
            f.setNome(nomeTextField.getText());
            f.setNif(Integer.parseInt(nifTextField.getText()));
            f.setUsername(usernameTextField.getText());
            if (confirmPasswordField.getText().equals(PasswordField.getText())){
                f.setPassword(confirmPasswordField.getText());
            }else{
                noSuccessAlertPasswords();
            }
            AdminBLL.create(f);
            successAlert(f.getCodadmin());
            usernameTextField.setText("");
            nifTextField.setText("");
            nomeTextField.setText("");
            PasswordField.setText("");
            confirmPasswordField.setText("");
        }
    }
    @FXML
    void voltar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menuAdmin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void successAlert(int tec){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Admin criado com sucesso");
        alert.setContentText("O Admin com ID: " + tec + " foi criado com sucesso");
        alert.show();
    }

    public void noSuccessAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Não foi possível criar o admin");
        alert.setContentText("Existem campos em branco que necessitam de estar preenchidos");
        alert.show();
    }

    public void noSuccessAlertPasswords(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Passwords não coicidem");
        alert.setContentText("Passwords não coicidem");
        alert.show();
    }
}