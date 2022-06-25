package com.example.fx;

import com.example.bd.BLL.ClienteBLL;
import com.example.bd.BLL.CodPostalBLL;
import com.example.bd.DAL.Cliente;
import com.example.bd.DAL.Codpostais;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class registarcontroller {
    private Scene scene;
    private Stage stage;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private TextField codPostTextfield;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField nPortaTextField;

    @FXML
    private TextField nifTextField;

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField ruaTextField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Text label;

    @FXML
    private TextField localidadeTextField;

    @FXML
    public void voltar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("primeirapagina.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void registar(ActionEvent event) throws IOException {
        Cliente c = new Cliente();
        List<Codpostais> cpl= CodPostalBLL.findCodPostaisEntities();
        c.setNome(nomeTextField.getText());
        c.setNif(Integer.parseInt(nifTextField.getText()));
        c.setRua(ruaTextField.getText());
        c.setNporta(Integer.parseInt(nPortaTextField.getText()));
        c.setEmail(emailTextField.getText());
        for (Codpostais cp : cpl){
            if (cp.getCodpostal().equals(codPostTextfield.getText())){
                c.setCodpostal(codPostTextfield.getText());
            }else {
                //label.setText("Código Postal " + codPostTextfield.getText() + " não existe!\n Adicione uma Localidade ao campo Localidade em cima para registar este Código Postal");
                if (!(localidadeTextField.getText().equals(""))){
                    Codpostais cp1 = new Codpostais();
                    cp1.setCodpostal(codPostTextfield.getText());
                    cp1.setLocalidade(localidadeTextField.getText());
                    CodPostalBLL.create(cp1);

                }else {
                    label.setText("Indique uma localidade correta!");
                }
            }
        }
        c.setUsername(usernameTextField.getText());
        if (PasswordField.getText().equals(confirmPasswordField.getText())){
            c.setPassword(confirmPasswordField.getText());
        }else {
            label.setText("Passwords não Coicidem!");
            confirmPasswordField.setText("");
            PasswordField.setText("");
        }

        ClienteBLL.create(c);
        label.setText("Cliente " + c.getNome() + " registado com Sucesso!");

        nomeTextField.setText("");
        nifTextField.setText("");
        ruaTextField.setText("");
        codPostTextfield.setText("");
        nPortaTextField.setText("");
        usernameTextField.setText("");
        emailTextField.setText("");
        confirmPasswordField.setText("");
        PasswordField.setText("");
        label.setText("");
    }
}
