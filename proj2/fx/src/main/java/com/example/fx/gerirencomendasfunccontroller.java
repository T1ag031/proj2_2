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
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
public class gerirencomendasfunccontroller  implements Initializable {
    ObservableList<String> estadoEnc= FXCollections.observableArrayList("Paga", "Entregue", "Cancelada");
    //ObservableList<Fornecedor> forncedor = FXCollections.observableArrayList(FornecedorBLL.findFornecedorEntities());
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
    private TableColumn<Encomenda, String> estadocol;

    @FXML
    private ComboBox<String> fornComboBox;

    @FXML
    private TableColumn<Encomenda, Integer> idcol;

    @FXML
    private TableColumn<Encomenda, Float> valorcol;

    @FXML
    private TextField dateTextField;

    @FXML
    private TextField valortotalTextField;

    private Scene scene;
    private Stage stage;
    private int id;
    private int idF;

    @FXML
    void editar(ActionEvent event) throws IOException {
        if (!(valortotalTextField.getText().equals("") && dateTextField.getText().equals(""))){
            EncomendaBLL.editValorEncomenda(id, Float.parseFloat(valortotalTextField.getText()));
            EncomendaBLL.editDataEncomenda(id, dateTextField.getText());
            dateTextField.setText("");
            valortotalTextField.setText("");
        }else {
            noSuccessAlert();
        }
        if (fornComboBox.getSelectionModel().getSelectedItem().equals("Paga")){
            EncomendaBLL.editEstadoEncomenda(id, "Paga");

        }
        if (fornComboBox.getSelectionModel().getSelectedItem().equals("Entregue")){
            EncomendaBLL.editEstadoEncomenda(id, "Entregue");

        }
        if (fornComboBox.getSelectionModel().getSelectedItem().equals("Cancelada")){
            EncomendaBLL.editEstadoEncomenda(id, "Cancelada");

        }
        initialize(null, null);
        successAlert(id);
    }
    @FXML
    void voltar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menuFuncionario.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fornComboBox.setItems(estadoEnc);
        idcol.setCellValueFactory(new PropertyValueFactory<Encomenda, Integer>("numencomenda"));
        datecol.setCellValueFactory(new PropertyValueFactory<Encomenda, Date>("data"));
        valorcol.setCellValueFactory(new PropertyValueFactory<Encomenda, Float>("valortotal"));
        estadocol.setCellValueFactory(new PropertyValueFactory<Encomenda, String>("est"));
        encomendas.setItems(getEncomendas());
    }
    @FXML
    void selectedRow(MouseEvent event) {
        Encomenda clickedEnc = encomendas.getSelectionModel().getSelectedItem();
        id = clickedEnc.getNumencomenda();
        valortotalTextField.setText(String.valueOf(clickedEnc.getValortotal()));
        dateTextField.setText(String.valueOf(clickedEnc.getData()));
        if (clickedEnc.getEst().equals("Recebida")){
            fornComboBox.getSelectionModel().select("Recebida");
        }
        if (clickedEnc.getEst().equals("Paga")){
            fornComboBox.getSelectionModel().select("Paga");
        }
        if (clickedEnc.getEst().equals("Cancelada")){
            fornComboBox.getSelectionModel().select("Cancelada");
        }
        if (clickedEnc.getEst().equals("Entregue")){
            fornComboBox.getSelectionModel().select("Entregue");
        }
    }

    @FXML
    void limpar(ActionEvent event) {
        valortotalTextField.setText("");
        dateTextField.setText("");
        fornComboBox.getSelectionModel().select("Fornecedores");
    }

    public void successAlert(int tec){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Encomenda editada com sucesso");
        alert.setContentText("A Encomenda com ID: " + tec + " foi editada com sucesso");
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
