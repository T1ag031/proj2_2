package com.example.fx;

import com.example.bd.BLL.AdminBLL;
import com.example.bd.DAL.Admin;
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

public class geriradminscontroller implements Initializable {

    @FXML
    private TableView<Admin> funcs;

    @FXML
    private TableColumn<Admin, Integer> idcol;

    @FXML
    private TextField nifTextField1;

    @FXML
    private TableColumn<Admin, Integer> nifpcol;

    @FXML
    private TextField nomeTextField;

    @FXML
    private TableColumn<Admin, String> nomecol;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TableColumn<Admin, String> usernamecol;
    private Scene scene;
    private Stage stage;

    @FXML
    private PasswordField passwordField;
    private int id;

    public ObservableList<Admin> getAdmins(){
        ObservableList<Admin> admins = FXCollections.observableArrayList();
        List<Admin> admin = AdminBLL.findAdminEntities();
        admins.addAll(admin);

        return admins;
    }

    @FXML
    void editar(ActionEvent event) throws IOException {
        if (!(nomeTextField.getText().equals("") || nifTextField1.getText().equals("") || usernameTextField.getText().equals(""))){
            AdminBLL.editNomeAdmin(id, nomeTextField.getText());
            AdminBLL.editNifAdmin(id, Integer.parseInt(nifTextField1.getText()));
            AdminBLL.editUserAdmin(id, usernameTextField.getText());
            usernameTextField.setText("");
            nomeTextField.setText("");
            nifTextField1.setText("");
            successAlert(id);
        }else {
            noSuccessAlert();
        }
        initialize(null, null);
    }
    @FXML
    void criar(ActionEvent event) {
        Admin a = new Admin();

        a.setNome(nomeTextField.getText());
        a.setNif(Integer.parseInt(nifTextField1.getText()));
        a.setUsername(usernameTextField.getText());
        a.setPassword(passwordField.getText());

        AdminBLL.create(a);


        successAlertCreate(a.getCodadmin());

        usernameTextField.setText("");
        nomeTextField.setText("");
        nifTextField1.setText("");
        passwordField.setText("");
        
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idcol.setCellValueFactory(new PropertyValueFactory<Admin, Integer>("codadmin"));
        nomecol.setCellValueFactory(new PropertyValueFactory<Admin, String>("nome"));
        nifpcol.setCellValueFactory(new PropertyValueFactory<Admin, Integer>("nif"));
        usernamecol.setCellValueFactory(new PropertyValueFactory<Admin, String>("username"));
        funcs.setItems(getAdmins());
    }
    @FXML
    void selectedRow(MouseEvent event) {
        Admin clickedAdm = funcs.getSelectionModel().getSelectedItem();
        id = clickedAdm.getCodadmin();
        nomeTextField.setText(String.valueOf(clickedAdm.getNome()));
        nifTextField1.setText(String.valueOf(clickedAdm.getNif()));
        usernameTextField.setText(String.valueOf(clickedAdm.getUsername()));
    }

    @FXML
    void limpar(ActionEvent event) {
        nomeTextField.setText("");
        nifTextField1.setText("");
        usernameTextField.setText("");
        passwordField.setText("");
    }

    public void successAlert(int tec){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Admin editado com sucesso");
        alert.setContentText("O Admin com ID: " + tec + " foi editado com sucesso");
        alert.show();
    }

    public void successAlertCreate(int tec){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Admin criado com sucesso");
        alert.setContentText("O Admin com ID: " + tec + " foi criado com sucesso");
        alert.show();
    }

    public void noSuccessAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Não foi possível editar o Admin");
        alert.setContentText("Existem campos em branco que necessitam de estar preenchidos");
        alert.show();
    }
}