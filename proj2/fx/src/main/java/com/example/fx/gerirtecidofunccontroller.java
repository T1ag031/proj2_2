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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class gerirtecidofunccontroller implements Initializable {
    @FXML
    private TextArea descTextField;

    @FXML
    private TableColumn<Tecido, String> desccol;

    @FXML
    private ComboBox<Fornecedor> fornComboBox;

    @FXML
    private TableColumn<Tecido, String> forncol;

    @FXML
    private TableColumn<Tecido, Integer> idcol;

    @FXML
    private TableView<Tecido> tecidos;
    private Scene scene;
    private Stage stage;
    private int id;
    ObservableList<Fornecedor> forncedor = FXCollections.observableArrayList(FornecedorBLL.findFornecedorEntities());

    @FXML
    void editar(ActionEvent event) throws IOException {
        if (!(descTextField.getText().equals(""))){
            TecidoBLL.editDescTecido(id, descTextField.getText());
            descTextField.setText("");
            initialize(null, null);
            successAlert(id);
        }else {
            noSuccessAlert();
        }

    }
    public ObservableList<Tecido> getTecidos(){
        ObservableList<Tecido> tecs = FXCollections.observableArrayList();
        List<Tecido> tec = TecidoBLL.findTecidoEntities();
        tecs.addAll(tec);
        return tecs;
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
        idcol.setCellValueFactory(new PropertyValueFactory<Tecido, Integer>("idtecido"));
        desccol.setCellValueFactory(new PropertyValueFactory<Tecido, String>("descricao"));
        forncol.setCellValueFactory(new PropertyValueFactory<Tecido, String>("codfornecedor"));
        tecidos.setItems(getTecidos());
    }

    @FXML
    void selectedRow(MouseEvent event) {
        Tecido clickedtec = tecidos.getSelectionModel().getSelectedItem();
        id = clickedtec.getIdtecido();
        descTextField.setText(clickedtec.getDescricao());
    }
    @FXML
    void limpar(ActionEvent event) {
        descTextField.setText("");
    }

    public void successAlert(int tec){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Tecido editado com sucesso");
        alert.setContentText("O Tecido com ID: " + tec + " foi editado com sucesso");
        alert.show();
    }

    public void noSuccessAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Não foi possível editar o tecido");
        alert.setContentText("Existem campos em branco que necessitam de estar preenchidos");
        alert.show();
    }
}
