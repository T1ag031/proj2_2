package com.example.fx;


import com.example.bd.BLL.FuncionarioBLL;
import com.example.bd.DAL.Funcionario;
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

public class gerirfuncionariocontroller implements Initializable {

    @FXML
    private TableView<Funcionario> funcs;

    @FXML
    private TableColumn<Funcionario, Integer> idcol;

    @FXML
    private TextField nifTextField1;

    @FXML
    private TableColumn<Funcionario, Integer> nifpcol;

    @FXML
    private TextField nomeTextField;

    @FXML
    private TableColumn<Funcionario, String> nomecol;

    @FXML
    private TableColumn<Funcionario, String> usernamecol;

    @FXML
    private TextField userTextField;

    @FXML
    private PasswordField passwordField;

    private Scene scene;
    private Stage stage;
    private int id;

    @FXML
    void editar(ActionEvent event) {
        if (!((nomeTextField.getText().equals("")) && (String.valueOf(nifTextField1.getText()).equals("")) && userTextField.getText().equals(""))){
            FuncionarioBLL.editNomeFunc(id, nomeTextField.getText());
            FuncionarioBLL.editNifFunc(id, Integer.parseInt(nifTextField1.getText()));
            FuncionarioBLL.editUserFunc(id, userTextField.getText());
            nomeTextField.setText("");
            nifTextField1.setText("");
            userTextField.setText("");
            successAlert(id);
        }else {
            noSuccessAlert();
        }
        initialize(null, null);
    }

    @FXML
    void criar(ActionEvent event) {
        Funcionario f  = new Funcionario();

        f.setNome(nomeTextField.getText());
        f.setNif(Integer.parseInt(nifTextField1.getText()));
        f.setUsername(userTextField.getText());
        f.setPassword(passwordField.getText());

        FuncionarioBLL.create(f);
        nifTextField1.setText("");
        nomeTextField.setText("");
        userTextField.setText("");
        passwordField.setText("");
        successAlertCreate(f.getCodfuncionario());
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
    void despFuncionario(ActionEvent event) {
        FuncionarioBLL.deleteFunc(id);
        successAlertFire(id);
        initialize(null, null);
    }
    @FXML
    void limpar(ActionEvent event) {
        nifTextField1.setText("");
        nomeTextField.setText("");
        userTextField.setText("");
        passwordField.setText("");
    }

    @FXML
    void selectedRow(MouseEvent event) {
        Funcionario clickedFunc = funcs.getSelectionModel().getSelectedItem();
        id = clickedFunc.getCodfuncionario();
        nomeTextField.setText(clickedFunc.getNome());
        nifTextField1.setText(String.valueOf(clickedFunc.getNif()));
        userTextField.setText(clickedFunc.getUsername());
    }

    public ObservableList<Funcionario> getFuncs(){
        ObservableList<Funcionario> funcs = FXCollections.observableArrayList();
        List<Funcionario> func = FuncionarioBLL.findFuncionarioEntities();
        funcs.addAll(func);
        return funcs;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idcol.setCellValueFactory(new PropertyValueFactory<Funcionario, Integer>("codfuncionario"));
        nomecol.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nome"));
        nifpcol.setCellValueFactory(new PropertyValueFactory<Funcionario, Integer>("nif"));
        usernamecol.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("username"));
        funcs.setItems(getFuncs());
    }

    public void successAlertCreate(int tec){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Funcionário criado com sucesso");
        alert.setContentText("O Funcionário com ID: " + tec + " foi criado com sucesso");
        alert.show();
    }

    public void successAlert(int tec){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Funcionário editado com sucesso");
        alert.setContentText("O Funcionário com ID: " + tec + " foi criado com sucesso");
        alert.show();
    }

    public void noSuccessAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Não foi possível editar o funcionário");
        alert.setContentText("Existem campos em branco que necessitam de estar preenchidos");
        alert.show();
    }

    public void successAlertFire(int tec){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Funcionário despedido com sucesso");
        alert.setContentText("O Funcionário com ID: " + tec + " foi despedido com sucesso");
        alert.show();
    }
}
