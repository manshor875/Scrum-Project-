/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mahdi Alizada
 */
public class FXMLRegisterController implements Initializable {

    @FXML
    private Button btnBack;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPhone;

    @FXML
    private Button btnRegister;
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    @FXML
    void chkBack(ActionEvent event) {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        Stage s = new Stage();
        s.setScene(scene);
        s.show();
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }

        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }

    @FXML
    void chkRegister(ActionEvent event) {
        try{
            conn = dbConnection.connect();
            
            String sql = "Insert into tblRegister(Name, USERNAME, PASSWORD, EMAIL, PHONE) values(?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtName.getText());
            pst.setString(2, txtUsername.getText());
            pst.setString(3, txtPassword.getText());
            pst.setString(4, txtEmail.getText());
            pst.setString(5, txtPhone.getText());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Success; You Can Login Now!");
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        txtName.setText(" ");
        txtUsername.setText(" ");
        txtPassword.setText(" ");
        txtEmail.setText(" ");
        txtPhone.setText(" ");

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
