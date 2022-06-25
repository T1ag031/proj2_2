package com.example.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class menuprincipalclientecontroller {

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
    void comprar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("clienteComprar.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void editareliminar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menuCliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
