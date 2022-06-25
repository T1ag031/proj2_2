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
public class gerirpecasfunccontroller implements Initializable {

    @FXML
    private TableColumn<Peca, Integer> idcol;

    @FXML
    private TableColumn<Peca, String> nomecol;

    @FXML
    private TableView<Peca> pecas;

    @FXML
    private TableColumn<Peca, Float> precocol;

    @FXML
    private TextField qtdTextField;

    @FXML
    private TableColumn<Peca, Integer> qtdcol;

    private Scene scene;
    private Stage stage;
    private int id;

    public ObservableList<Peca> getPecas(){
        ObservableList<Peca> pecas = FXCollections.observableArrayList();
        List<Peca> peca = PecaBLL.findPecaEntities();
        pecas.addAll(peca);
        return pecas;
    }
    @FXML
    void editar(ActionEvent event) throws IOException {

        if (!(qtdTextField.getText().equals(""))){
            PecaBLL.editQtdPeca(id, Integer.parseInt(qtdTextField.getText()));
            qtdTextField.setText("");
            initialize(null, null);
            successAlert(id);
        }else {
            noSuccessAlert();
        }
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
        idcol.setCellValueFactory(new PropertyValueFactory<Peca, Integer>("idpeca"));
        nomecol.setCellValueFactory(new PropertyValueFactory<Peca, String>("nome"));
        precocol.setCellValueFactory(new PropertyValueFactory<Peca, Float>("precopeca"));
        qtdcol.setCellValueFactory(new PropertyValueFactory<Peca, Integer>("qtd"));
        pecas.setItems(getPecas());
    }
    @FXML
    void limpar(ActionEvent event) {
        qtdTextField.setText("");
    }
    @FXML
    void selectedRow(MouseEvent event) {
        Peca clickedpeca = pecas.getSelectionModel().getSelectedItem();
        id = clickedpeca.getIdpeca();
        qtdTextField.setText(String.valueOf(clickedpeca.getQtd()));
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
}