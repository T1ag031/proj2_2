package com.example.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class clienteComprarcontroller {
    private Scene scene;
    private Stage stage;
    @FXML
    private TextField qtdTextField;
    @FXML
    private ComboBox<?> comboBoxnome;
    @FXML
    void comprar(ActionEvent event) throws IOException {

    }
    @FXML
    void voltar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("menuPrincipalCliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
