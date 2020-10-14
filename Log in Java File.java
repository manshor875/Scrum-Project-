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
 *
 * @author Mahdi Alizada
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField txtUser;

    @FXML
    private TextField txtPass;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnSingUp;
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @FXML
    void chkLogin(ActionEvent event) {
        try{
            conn = dbConnection.connect();

            String sql = "Select * from tblRegister where USERNAME = ? and PASSWORD = ? ";

            pst = conn.prepareStatement(sql);
            pst.setString(1, txtUser.getText());
            pst.setString(2, txtPass.getText());

            rs = pst.executeQuery();

            if(rs.next() ==  true){
                
                
                try{
                Parent root = FXMLLoader.load(getClass().getResource("FXMLMain.fxml"));
                Scene scene = new Scene(root);
                Stage s = new Stage();
                s.setScene(scene);
                s.show();
               
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
                
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
            }
            
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.close();
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    @FXML
    void chkSignUp(ActionEvent event) {
        
        
        try{
        Parent root = FXMLLoader.load(getClass().getResource("FXMLRegister.fxml"));
        Scene scene = new Scene(root);
        Stage s = new Stage();
        s.setScene(scene);
        s.show();
        
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        Stage stage = (Stage) btnSingUp.getScene().getWindow();
        stage.close();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
