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

public class gerirtecidosAdmin implements Initializable {

    public ObservableList<Tecido> getTecidos(){
        ObservableList<Tecido> tecs = FXCollections.observableArrayList();
        List<Tecido> tec = TecidoBLL.findTecidoEntities();
        tecs.addAll(tec);

        return tecs;
    }

    @FXML
    private TextField descTextField;


    @FXML
    private TableColumn<Tecido, String> desccol;

    @FXML
    private TableColumn<Tecido, String> forncol;

    @FXML
    private TableColumn<Tecido, Integer> idcol;

    @FXML
    private TableView<Tecido> tecidos;

    @FXML
    private TableView<Fornecedor> fornecedores;

    @FXML
    private TableColumn<Fornecedor, Integer> idforncol;
    @FXML
    private TableColumn<Fornecedor, String> nomeforncol;
    private Scene scene;
    private Stage stage;
    private int id;
    private int idF;

    @FXML
    void editar(ActionEvent event) throws IOException {
        if (!(descTextField.getText().equals(""))){
            TecidoBLL.editDescTecido(id, descTextField.getText());
            descTextField.setText("");
            successAlert(id);
        }else {
            noSuccessAlert();
        }
        initialize(null, null);
    }
    public ObservableList<Fornecedor> getForns(){
        ObservableList<Fornecedor> forns = FXCollections.observableArrayList();
        List<Fornecedor> forn = FornecedorBLL.findFornecedorEntities();
        forns.addAll(forn);

        return forns;
    }
    @FXML
    void selectedRow(MouseEvent event) {
        Tecido clickedtec = tecidos.getSelectionModel().getSelectedItem();
        id = clickedtec.getIdtecido();
        descTextField.setText(clickedtec.getDescricao());
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
    void criar(ActionEvent event) throws IOException {
       Tecido t = new Tecido();

       t.setDescricao(descTextField.getText());
       t.setCodfornecedor(idF);

       TecidoBLL.create(t);
        descTextField.setText("");
       successAlertCreate(t.getIdtecido());
       initialize(null, null);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idcol.setCellValueFactory(new PropertyValueFactory<Tecido, Integer>("idtecido"));
        desccol.setCellValueFactory(new PropertyValueFactory<Tecido, String>("descricao"));
        forncol.setCellValueFactory(new PropertyValueFactory<Tecido, String>("codfornecedor"));
        tecidos.setItems(getTecidos());
        idforncol.setCellValueFactory(new PropertyValueFactory<Fornecedor, Integer>("codfornecedor"));
        nomeforncol.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("nome"));
        fornecedores.setItems(getForns());
    }
    @FXML
    void selectedForn(MouseEvent event) {
        Fornecedor clickedforn = fornecedores.getSelectionModel().getSelectedItem();
        idF = clickedforn.getCodfornecedor();
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

    public void successAlertCreate(int tec){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Tecido criado com sucesso");
        alert.setContentText("O Tecido com ID: " + tec + " foi criado com sucesso");
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