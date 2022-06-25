package com.example.fx;

import com.example.bd.BLL.AdminBLL;
import com.example.bd.BLL.FuncionarioBLL;
import com.example.bd.DAL.Admin;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class logincontroller {
    private Stage stage;
    private Scene scene;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField textField;
    @FXML
    public void login(ActionEvent event) throws IOException{
        List<Funcionario> lFor = FuncionarioBLL.findFuncionarioEntities();
        List<Admin> ladm = AdminBLL.findAdminEntities();
        for (Admin a : ladm){
            for (Funcionario f : lFor) {
                if (a.getUsername().equals(textField.getText()) && a.getPassword().equals(passwordField.getText())) {
                    Parent root1 = FXMLLoader.load(getClass().getResource("menuAdmin.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root1);
                    stage.setScene(scene);
                    stage.show();
                }else if (f.getUsername().equals(textField.getText()) && f.getPassword().equals(passwordField.getText())){
                    Parent root2 = FXMLLoader.load(getClass().getResource("menuFuncionario.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root2);
                    stage.setScene(scene);
                    stage.show();
                }
            }
        }
    }

    @FXML
    public void voltar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("primeirapagina.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void loginAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Inicio de Sessão falhou");
        alert.setHeaderText("Username ou Password errados");
        alert.setContentText("Tente novamente");
        alert.show();
    }
}