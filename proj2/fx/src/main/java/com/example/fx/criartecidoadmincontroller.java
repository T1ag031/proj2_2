package com.example.fx;

import com.example.bd.BLL.FornecedorBLL;
import com.example.bd.BLL.TecidoBLL;
import com.example.bd.DAL.Fornecedor;
import com.example.bd.DAL.Tecido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
public class criartecidoadmincontroller implements Initializable {
    @FXML
    private Label label;

    @FXML
    private TextField codfornTextField;

    @FXML
    private TableColumn<Fornecedor, String> codpostalcol;

    @FXML
    private TextField descTextField;

    @FXML
    private TableView<Fornecedor> fornecedores;

    @FXML
    private TableColumn<Fornecedor, Integer> idcol;

    @FXML
    private TableColumn<Fornecedor, Integer> nifcol;

    @FXML
    private TableColumn<Fornecedor, String> nomecol;

    private Scene scene;
    private Stage stage;
    private int id;

    public ObservableList<Fornecedor> getForns(){
        ObservableList<Fornecedor> forns = FXCollections.observableArrayList();
        List<Fornecedor> forn = FornecedorBLL.findFornecedorEntities();
        forns.addAll(forn);
        return forns;
    }
    @FXML
    void criar(ActionEvent event) {
        if (descTextField.getText().equals("") || codfornTextField.getText().equals("")){
            noSuccessAlert();
        } else {
            Tecido t = new Tecido();
            t.setDescricao(descTextField.getText());
            t.setCodfornecedor(Integer.parseInt(codfornTextField.getText()));
            TecidoBLL.create(t);
            successAlert(t.getIdtecido());
        }
    }
    @FXML
    void voltar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("gerirtecidosAdmin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idcol.setCellValueFactory(new PropertyValueFactory<Fornecedor, Integer>("codfornecedor"));
        nomecol.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("nome"));
        nifcol.setCellValueFactory(new PropertyValueFactory<Fornecedor, Integer>("nif"));
        codpostalcol.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("codpostal"));
        fornecedores.setItems(getForns());
    }
    public void successAlert(int tec){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Tecido criado com sucesso");
        alert.setContentText("O Tecido com ID: " + tec + " foi criado com sucesso");
        alert.show();
    }

    public void noSuccessAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Não foi possível criar o tecido");
        alert.setContentText("Existem campos em branco que necessitam de estar preenchidos");
        alert.show();
    }

}