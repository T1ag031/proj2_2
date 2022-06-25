package com.example.fx;

import com.example.bd.BLL.EncomendaBLL;
import com.example.bd.BLL.FornecedorBLL;
import com.example.bd.DAL.Encomenda;
import com.example.bd.DAL.Fornecedor;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class gerirencomendasAdmin implements Initializable {
    ObservableList<String> estadoEnc= FXCollections.observableArrayList("Recebida", "Paga", "Entregue", "Cancelada");
    //ObservableList<Fornecedor> fornss= FXCollections.observableArrayList(FornecedorBLL.findFornecedorEntities());
    public ObservableList<Encomenda> getEncomendas(){
        ObservableList<Encomenda> encs = FXCollections.observableArrayList();
        List<Encomenda> enc = EncomendaBLL.findEncomendaEntities();
        encs.addAll(enc);

        return encs;
    }
    public ObservableList<Fornecedor> getForns(){
        ObservableList<Fornecedor> encs = FXCollections.observableArrayList();
        List<Fornecedor> enc = FornecedorBLL.findFornecedorEntities();
        encs.addAll(enc);

        return encs;
    }

    @FXML
    private TableColumn<Encomenda, Date> datecol;

    @FXML
    private TableView<Encomenda> encomendas;

    @FXML
    private ComboBox<String> estadoComboBox;

    @FXML
    private TableColumn<Encomenda, String> estadocol;


    @FXML
    private TableColumn<Encomenda, Integer> idcol;

    @FXML
    private TextField valorTextField;
    @FXML
    private TextField fornTextField;
    @FXML
    private TableColumn<Encomenda, Float> valorcol;
    @FXML
    private TableColumn<Fornecedor, Integer> idFornCol;

    @FXML
    private TableColumn<Fornecedor, String> nomeFornCol;
    @FXML
    private TextField dataTextField;

    @FXML
    private TextField dataTextField1;
    @FXML
    private TableView<Fornecedor> forns;
    private Scene scene;
    private Stage stage;

    private int id;
    private int idF;
    private int idT;

    @FXML
    void editar(ActionEvent event) throws IOException {
        if (!(dataTextField1.getText().equals("") && (dataTextField.getText().equals("")))){
            EncomendaBLL.editValorEncomenda(id, Float.parseFloat(dataTextField1.getText()));
            EncomendaBLL.editDataEncomenda(id, dataTextField.getText());
            dataTextField1.setText("");
            dataTextField.setText("");
        }else {
            noSuccessAlert();
        }
        if (estadoComboBox.getSelectionModel().getSelectedItem().equals("Paga")){
            EncomendaBLL.editEstadoEncomenda(id, "Paga");

        }
        if (estadoComboBox.getSelectionModel().getSelectedItem().equals("Entregue")){
            EncomendaBLL.editEstadoEncomenda(id, "Entregue");

        }
        if (estadoComboBox.getSelectionModel().getSelectedItem().equals("Cancelada")){
            EncomendaBLL.editEstadoEncomenda(id, "Cancelada");

        }if (estadoComboBox.getSelectionModel().getSelectedItem().equals("Recebida")){
            EncomendaBLL.editEstadoEncomenda(id, "Recebida");

        }
        initialize(null, null);
        successAlert(id);
    }
    @FXML
    void voltar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menuAdmin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        estadoComboBox.setItems(estadoEnc);
        idcol.setCellValueFactory(new PropertyValueFactory<Encomenda, Integer>("numencomenda"));
        datecol.setCellValueFactory(new PropertyValueFactory<Encomenda, Date>("data"));
        valorcol.setCellValueFactory(new PropertyValueFactory<Encomenda, Float>("valortotal"));
        estadocol.setCellValueFactory(new PropertyValueFactory<Encomenda, String>("est"));
        encomendas.setItems(getEncomendas());
        idFornCol.setCellValueFactory(new PropertyValueFactory<Fornecedor, Integer>("codfornecedor"));
        nomeFornCol.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("nome"));
        forns.setItems(getForns());
    }

    @FXML
    void selectedRow(MouseEvent event) {
        Encomenda clickedEnc = encomendas.getSelectionModel().getSelectedItem();
        id = clickedEnc.getNumencomenda();
        dataTextField1.setText(String.valueOf(clickedEnc.getValortotal()));
        dataTextField.setText(String.valueOf(clickedEnc.getData()));
        if (clickedEnc.getEst().equals("Recebida")){
            estadoComboBox.getSelectionModel().select("Recebida");
        }
        if (clickedEnc.getEst().equals("Paga")){
            estadoComboBox.getSelectionModel().select("Paga");
        }
        if (clickedEnc.getEst().equals("Cancelada")){
            estadoComboBox.getSelectionModel().select("Cancelada");
        }
        if (clickedEnc.getEst().equals("Entregue")){
            estadoComboBox.getSelectionModel().select("Entregue");
        }
    }
    @FXML
    void selectForn(MouseEvent event) {
        Fornecedor clickedForn= forns.getSelectionModel().getSelectedItem();
        idF = clickedForn.getCodfornecedor();
    }
    @FXML
    void selectTec(MouseEvent event) {
        Fornecedor clickedTec= forns.getSelectionModel().getSelectedItem();
        idT = clickedTec.getCodfornecedor();
    }
    @FXML
    void criar(ActionEvent event) throws IOException {
        Encomenda e = new Encomenda();
        e.setData(java.sql.Date.valueOf(String.valueOf(dataTextField.getText())));
        e.setValortotal(BigDecimal.valueOf(Long.parseLong(dataTextField1.getText())));
        e.setEst("Recebida");
        e.setCodfornecedor(Integer.valueOf(idF));
        EncomendaBLL.create(e);
        dataTextField.setText("");
        dataTextField1.setText("");
        estadoComboBox.getSelectionModel().select("Estado");
        initialize(null, null);
        CreatesuccessAlert(e.getNumencomenda());
    }
    @FXML
    void limpar(ActionEvent event) {
        dataTextField.setText("");
        dataTextField1.setText("");
    }

    public void successAlert(int tec){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Encomenda editada com sucesso");
        alert.setContentText("A Encomenda com ID: " + tec + " foi editada com sucesso");
        alert.show();
    }

    public void CreatesuccessAlert(int tec){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Encomenda criada com sucesso");
        alert.setContentText("A Encomenda com ID: " + tec + " foi criada com sucesso");
        alert.show();
    }

    public void noSuccessAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Não foi possível editar a Encomenda");
        alert.setContentText("Existem campos em branco que necessitam de estar preenchidos");
        alert.show();
    }
}