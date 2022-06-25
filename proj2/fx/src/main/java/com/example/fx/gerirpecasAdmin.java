package com.example.fx;


import com.example.bd.BLL.PecaBLL;
import com.example.bd.DAL.Peca;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class gerirpecasAdmin implements Initializable {

    @FXML
    private TableView<Peca> pecas;

    @FXML
    private TableColumn<Peca, Integer> idcol;

    @FXML
    private TextField nomeTextField;

    @FXML
    private TableColumn<Peca, String> nomecol;

    @FXML
    private TableColumn<Peca, Float> precocol;

    @FXML
    private TextField qtdTextField;

    @FXML
    private TableColumn<Peca, Integer> qtdcol;

    @FXML
    private TextField valorTextField1;

    private Scene scene;
    private Stage stage;

    private int id;
    private int idF;


    public ObservableList<Peca> getPeca(){
        ObservableList<Peca> encs = FXCollections.observableArrayList();
        List<Peca> enc = PecaBLL.findPecaEntities();
        encs.addAll(enc);

        return encs;
    }

    @FXML
    void editar(ActionEvent event) throws IOException {
        if (!(nomeTextField.getText().equals("") && qtdTextField.getText().equals("") && valorTextField1.getText().equals(""))){
            PecaBLL.editNomePeca( id,nomeTextField.getText());
            PecaBLL.editQtdPeca(id, Integer.parseInt(qtdTextField.getText()));
            PecaBLL.editValorPeca(id, Integer.parseInt(valorTextField1.getText()));
            valorTextField1.setText("");
            nomeTextField.setText("");
            qtdTextField.setText("");
            initialize(null, null);
            successAlert(id);
        }else {
            noSuccessAlert();
        }
    }
    @FXML
    void limpar(ActionEvent event) {
        valorTextField1.setText("");
        nomeTextField.setText("");
        qtdTextField.setText("");
    }

    @FXML
    void criar(ActionEvent event) {
        if (nomeTextField.getText().equals("") || qtdTextField.getText().equals("") || valorTextField1.getText().equals("")){
            noSuccessAlertcreate();
        }else {
            Peca p = new Peca();
            p.setNome(nomeTextField.getText());
            p.setQtd(Integer.parseInt(qtdTextField.getText()));
            p.setPrecopeca(Integer.parseInt(valorTextField1.getText()));
            PecaBLL.create(p);
            successAlertcreate(p.getIdpeca());
        }
        valorTextField1.setText("");
        nomeTextField.setText("");
        qtdTextField.setText("");
        initialize(null, null);
    }
    @FXML
    void voltar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menuAdmin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void selectedRow(MouseEvent event) {
        Peca clickedpeca = pecas.getSelectionModel().getSelectedItem();
        id = clickedpeca.getIdpeca();
        nomeTextField.setText(clickedpeca.getNome());
        qtdTextField.setText(String.valueOf(clickedpeca.getQtd()));
        valorTextField1.setText(String.valueOf(clickedpeca.getPrecopeca()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idcol.setCellValueFactory(new PropertyValueFactory<Peca, Integer>("idpeca"));
        nomecol.setCellValueFactory(new PropertyValueFactory<Peca, String>("nome"));
        qtdcol.setCellValueFactory(new PropertyValueFactory<Peca, Integer>("qtd"));
        precocol.setCellValueFactory(new PropertyValueFactory<Peca, Float>("precopeca"));
        pecas.setItems(getPeca());
    }

    public void successAlert(int tec){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Peça editada com sucesso");
        alert.setContentText("A Peça com ID: " + tec + " foi criada com sucesso");
        alert.show();
    }

    public void noSuccessAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Não foi possível editar a Peça");
        alert.setContentText("Existem campos em branco que necessitam de estar preenchidos");
        alert.show();
    }

    public void successAlertcreate(int tec){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Peça criada com sucesso");
        alert.setContentText("A Peça com ID: " + tec + " foi criada com sucesso");
        alert.show();
    }

    public void noSuccessAlertcreate(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Não foi possível criar a Peça");
        alert.setContentText("Existem campos em branco que necessitam de estar preenchidos");
        alert.show();
    }
}