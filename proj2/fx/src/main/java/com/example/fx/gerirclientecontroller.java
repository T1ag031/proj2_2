package com.example.fx;

import com.example.bd.BLL.ClienteBLL;
import com.example.bd.BLL.CodPostalBLL;
import com.example.bd.DAL.Cliente;
import com.example.bd.DAL.Codpostais;
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

public class gerirclientecontroller implements Initializable {

    @FXML
    private TextField codPostalTextField;
    @FXML
    private TextField ruaTextField2;
    @FXML
    private TextField emailTextField2;
    @FXML
    private TextField nifTextField1;
    @FXML
    private TextField nomeTextField;
    @FXML
    private TextField userTextField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private TextField nPortaTextField;
    @FXML
    private TableColumn<Cliente, Integer> idcol;

    @FXML
    private TableColumn<Cliente, String> mailcol;
    @FXML
    private TableColumn<Cliente, Integer> nifpcol;
    @FXML
    private TableColumn<Cliente, String> nomecol;

    @FXML
    private TableColumn<Cliente, String> ruacol;

    @FXML
    private TableView<Cliente> clientes;


    private Scene scene;
    private Stage stage;
    private int id;

    public ObservableList<Cliente> getClientes(){
        ObservableList<Cliente> encs = FXCollections.observableArrayList();
        List<Cliente> enc = ClienteBLL.findClienteEntities();
        encs.addAll(enc);
        return encs;
    }
    @FXML
    void editar(ActionEvent event) throws IOException {

        if (!(ruaTextField2.getText().equals("") ||
                nifTextField1.getText().equals("") || nomeTextField.getText().equals("") || emailTextField2.getText().equals(""))){
            ClienteBLL.editEmailCliente(id, emailTextField2.getText());
            ClienteBLL.editNomeCliente(id, nomeTextField.getText());
            ClienteBLL.editNifCliente(id, Integer.parseInt(nifTextField1.getText()));
            ClienteBLL.editRuaCliente(id, ruaTextField2.getText());
            emailTextField2.setText("");
            nomeTextField.setText("");
            nifTextField1.setText("");
            ruaTextField2.setText("");
            successAlert(id);
            initialize(null, null);
        }else {
            noSuccessAlert();
        }
    }
    @FXML
    void limpar(ActionEvent event) {
        emailTextField2.setText("");
        nifTextField1.setText("");
        ruaTextField2.setText("");
        nomeTextField.setText("");
        nPortaTextField.setText("");
        codPostalTextField.setText("");
        userTextField.setText("");
        confirmPasswordField.setText("");
    }
    @FXML
    void selectedRow(MouseEvent event) {
        Cliente clickedCli = clientes.getSelectionModel().getSelectedItem();
        id = clickedCli.getCodcliente();
        nomeTextField.setText(String.valueOf(clickedCli.getNome()));
        nifTextField1.setText(String.valueOf(clickedCli.getNif()));
        ruaTextField2.setText(String.valueOf(clickedCli.getRua()));
        emailTextField2.setText(String.valueOf(clickedCli.getEmail()));

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
        List<Codpostais> cpList = CodPostalBLL.findCodPostaisEntities();
        Cliente c = new Cliente();
        c.setNome(nomeTextField.getText());
        c.setNif(Integer.parseInt(nifTextField1.getText()));
        c.setEmail(emailTextField2.getText());
        c.setRua(ruaTextField2.getText());
        c.setCodpostal(codPostalTextField.getText());
        c.setNporta(Integer.parseInt(nPortaTextField.getText()));
        c.setUsername(userTextField.getText());
        c.setPassword(confirmPasswordField.getText());

        ClienteBLL.create(c);
        emailTextField2.setText("");
        nifTextField1.setText("");
        ruaTextField2.setText("");
        nomeTextField.setText("");
        nPortaTextField.setText("");
        codPostalTextField.setText("");
        userTextField.setText("");
        confirmPasswordField.setText("");
        createsuccessAlert(c.getCodcliente());
        initialize(null, null);
    }

    public void successAlert(int tec){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Cliente editado com sucesso");
        alert.setContentText("O Cliente com ID: " + tec + " foi editado com sucesso");
        alert.show();
    }

    public void noSuccessAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Não foi possível editar o Cliente");
        alert.setContentText("Existem campos em branco que necessitam de estar preenchidos");
        alert.show();
    }
    public void noSuccessAlertCod(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Não foi possível criar o Cliente");
        alert.setContentText("Não foi encontrado o Código-Postal");
        alert.show();
    }
    public void createsuccessAlert(int tec){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Cliente criado com sucesso");
        alert.setContentText("O Cliente com ID: " + tec + " foi criado com sucesso");
        alert.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idcol.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("codcliente"));
        nifpcol.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("nif"));
        mailcol.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));
        ruacol.setCellValueFactory(new PropertyValueFactory<Cliente, String>("rua"));
        nomecol.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        clientes.setItems(getClientes());
    }
}