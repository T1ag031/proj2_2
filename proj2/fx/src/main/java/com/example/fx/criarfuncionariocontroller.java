package com.example.fx;

import com.example.bd.BLL.FuncionarioBLL;
import com.example.bd.DAL.Funcionario;
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

public class criarfuncionariocontroller {

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
    private Scene scene;
    private Stage stage;


    @FXML
    void registar(ActionEvent event) {
        if (nomeTextField.getText().equals("") || nifTextField.getText().equals("") | usernameTextField.getText().equals("") ||
                PasswordField.getText().equals("") || confirmPasswordField.getText().equals("")){
            noSuccessAlert();
        }else {
            Funcionario f = new Funcionario();
            f.setNome(nomeTextField.getText());
            f.setNif(Integer.parseInt(nifTextField.getText()));
            f.setUsername(usernameTextField.getText());
            if (confirmPasswordField.getText().equals(PasswordField.getText())){
                f.setPassword(confirmPasswordField.getText());
            }else{
                noSuccessAlertPasswords();
            }
            FuncionarioBLL.create(f);
            successAlert(f.getCodfuncionario());
            nomeTextField.setText("");
            nifTextField.setText("");
            usernameTextField.setText("");
            confirmPasswordField.setText("");
            PasswordField.setText("");
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
        alert.setHeaderText("Funcionário criado com sucesso");
        alert.setContentText("O Funcionário com ID: " + tec + " foi criado com sucesso");
        alert.show();
    }

    public void noSuccessAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Não foi possível criar o Funcionário");
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
