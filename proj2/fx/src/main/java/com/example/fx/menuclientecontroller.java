package com.example.fx;

import com.example.bd.BLL.VendaBLL;
import com.example.bd.DAL.Venda;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class menuclientecontroller implements Initializable{
    private Stage stage;
    private Scene scene;


    @FXML
    private TableColumn<Venda, Date> datecol;

    @FXML
    private TableColumn<Venda, String> nomepcol;
    @FXML
    private TableColumn<Venda, Integer> qtdcol;

    @FXML
    private TableColumn<Venda, Float> valorcol;

    @FXML
    private TableColumn<Venda, Integer> nvendacol;

    @FXML
    private TableView<Venda> vendas;

    @FXML
    private TextField nvendaTextField;

    @FXML
    private TextField qtdTextField;

    @FXML
    private TextField valorTextField;

    @FXML
    public void voltar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("menuPrincipalCliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void editar(ActionEvent event){

    }

    @FXML
    public void delete(ActionEvent event){

    }

    ObservableList<Venda> list = (ObservableList<Venda>) VendaBLL.findVendaEntities();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        /*nvendacol.setCellValueFactory(new PropertyValueFactory<Venda, Integer>("Nº Venda"));
        nomepcol.setCellValueFactory(new PropertyValueFactory<Venda, String>("Nome"));
        datecol.setCellValueFactory(new PropertyValueFactory<Venda, Date>("Data"));
        valorcol.setCellValueFactory(new PropertyValueFactory<Venda, Float>("Valor Total"));
        qtdcol.setCellValueFactory(new PropertyValueFactory<Venda, Integer>("Quantidade"));*/
        vendas.setItems(list);
    }
}
