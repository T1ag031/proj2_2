package com.example.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class menuadmincontroller {
    private Stage stage;
    private Scene scene;
    @FXML
    void voltar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("primeirapagina.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void geriradmins(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("gerirAdmins.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void gerirclientes(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("gerirClientes.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void gerirencomendas(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("gerirEncomendasAdmin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void gerirfuncionario(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("gerirFuncionarios.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void gerirpecas(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("gerirpecasAdmin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void gerirtecido(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("gerirtecidosAdmin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}