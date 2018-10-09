/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class Conexao {
    Connection conexao;
    
    
    
        public Connection conectar (){
        String servidor = "jdbc:mysql://localhost:3306/eleicao";
        String usuario = "root";
        String senha = "cimatec";
        String driver = "com.mysql.jdbc.Driver";
        
        
            try {
              Class.forName(driver);
              return DriverManager.getConnection(servidor,usuario ,senha);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "errinho na conexão"+e.getMessage());
            
            
            }
       
            
            
            
            return null;
       
        
        
        
        
      
    }

    
    

}
    


