package com.example.fx;

import com.example.bd.BLL.ClienteBLL;
import com.example.bd.BLL.CodPostalBLL;
import com.example.bd.DAL.Cliente;
import com.example.bd.DAL.Codpostais;
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
import java.util.List;

public class criarclientecontroller {
    @FXML
    private PasswordField PasswordField;

    @FXML
    private TextField codPostTextfield;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Text label;

    @FXML
    private TextField localidadeTextField;

    @FXML
    private TextField nPortaTextField;

    @FXML
    private TextField nifTextField;

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField ruaTextField;

    @FXML
    private TextField usernameTextField;
    private Scene scene;
    private Stage stage;

    @FXML
    void registar(ActionEvent event) {
        if(nomeTextField.getText().equals("") || nifTextField.getText().equals("") || emailTextField.getText().equals("") ||
                codPostTextfield.getText().equals("") || nPortaTextField.getText().equals("") || ruaTextField.getText().equals("") ||
                usernameTextField.getText().equals("") ||  confirmPasswordField.getText().equals("") || PasswordField.getText().equals("")){
            noSuccessAlert();
        }else {
            Cliente c = new Cliente();
            List<Codpostais> cpl= CodPostalBLL.findCodPostaisEntities();
            c.setNome(nomeTextField.getText());
            c.setNif(Integer.parseInt(nifTextField.getText()));
            c.setRua(ruaTextField.getText());
            c.setNporta(Integer.parseInt(nPortaTextField.getText()));
            c.setEmail(emailTextField.getText());
            c.setCodpostal(codPostTextfield.getText());
            c.setUsername(usernameTextField.getText());
            if (PasswordField.getText().equals(confirmPasswordField.getText())){
                c.setPassword(confirmPasswordField.getText());
            }else {
                noSuccessAlertPasswords();
                confirmPasswordField.setText("");
                PasswordField.setText("");
            }
            ClienteBLL.create(c);
            successAlert(c.getCodcliente());
            nomeTextField.setText("");
            nifTextField.setText("");
            ruaTextField.setText("");
            codPostTextfield.setText("");
            nPortaTextField.setText("");
            usernameTextField.setText("");
            emailTextField.setText("");
            confirmPasswordField.setText("");
            PasswordField.setText("");
            label.setText("");
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
        alert.setHeaderText("Cliente criado com sucesso");
        alert.setContentText("O Cliente com ID: " + tec + " foi criado com sucesso");
        alert.show();
    }

    public void noSuccessAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Não foi possível criar o cliente");
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
