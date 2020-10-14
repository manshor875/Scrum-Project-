/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp;

/**
 *
 * @author Mahdi Alizada
 */
import Models.mdlBook;
import Models.mdlIssue;
import Models.mdlReg;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

public class dbConnection {
    
    public static Connection connect() throws ClassNotFoundException{
    
        Connection conn = null;  
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
        
            String url = "jdbc:mysql://localhost:3306/dbRegister";
            String user = "root";
            String pass = "";
        
            conn = (Connection) DriverManager.getConnection(url, user, pass);
            
            System.out.println("Connected");
           
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        
        }
        return conn;
    }
    
    public static ObservableList<mdlReg> getInfo(){
    
        ObservableList<mdlReg> list = FXCollections.observableArrayList();
        try{
        Connection conn = connect();
        
        
        PreparedStatement pst = conn.prepareStatement("select * from tblregister");
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
            
            mdlReg m = new mdlReg();
            int ID = Integer.parseInt(rs.getString("ID"));
            String Name = rs.getString("NAME");
            String User = rs.getString("USERNAME");
            String Pass = rs.getString("PASSWORD");
            String Email = rs.getString("EMAIL");
            String Phone = rs.getString("PHONE");
            
            m.setID(ID);
            m.setName(Name);
            m.setUser(User);
            m.setPass(Pass);
            m.setEmail(Email);
            m.setPhone(Phone);
            
            list.add(m);
            
            
        
        }
        
        } catch(Exception ex){
        
        }
        
        return list;
        
    }
    
    public static ObservableList<mdlBook> getData(){
    
        ObservableList<mdlBook> listBook = FXCollections.observableArrayList();
        try{
        Connection conn = connect();
        
        
        PreparedStatement pst = conn.prepareStatement("select * from tblBooks");
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
            
            mdlBook b = new mdlBook();
            int BID = Integer.parseInt(rs.getString("BID"));
            String BName = rs.getString("BNAME");
            String Author = rs.getString("AUTHOR");
            String Genre = rs.getString("GENRE");
            
            
            b.setBID(BID);
            b.setBName(BName);
            b.setAuthor(Author);
            b.setGenre(Genre);
            
            
            listBook.add(b);
            
            
        
        }
        
        } catch(Exception ex){
        
        }
        
        return listBook;
        
    }
    
    public static ObservableList<mdlIssue> getBookData(){
    
        ObservableList<mdlIssue> listIssue = FXCollections.observableArrayList();
        try{
        Connection conn = connect();
        
        
        PreparedStatement pst = conn.prepareStatement("select * from tblIssued");
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
            
            mdlIssue i = new mdlIssue();
            int IID = Integer.parseInt(rs.getString("ISSUE_ID"));
            String UserID = rs.getString("USER_ID");
            String BookID = rs.getString("BOOK_ID");
            String IssueDate = rs.getString("ISSUE_DATE");
            String ReturnDate = rs.getString("RETURN_DATE");
            
            i.setIID(IID);
            i.setUserID(UserID);
            i.setBookID(BookID);
            i.setIssueDate(IssueDate);
            i.setReturnDate(ReturnDate);
            
            listIssue.add(i);
            
            
        
        }
        
        } catch(Exception ex){
        
        }
        
        return listIssue;
        
    }
    
}



