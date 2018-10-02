/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Conexao {
    private ResultSet resultset;
    private Connection conexao;
    private Statement statement;
    
    
    public void conectar (){
        String servidor = "jdbc:mysql://localhost:3306/empresa";
        String usuario = "root";
        String senha = "cimatec";
        String driver = "com.mysql.jdbc.Driver";
        
        try {
            Class.forName(driver);
            this.conexao = DriverManager.getConnection(servidor, usuario, senha);
            this.statement = this.conexao.createStatement();
            
          
            
        } catch (Exception e) {
            System.out.println("Errinho básico"+e.getMessage()); 
        
        }
        
        
        
        
      
    }

      public boolean isConnected (){
          if(this.conexao!=null){
              return true;
          }else {
              return false;
          }     
       }
      
      
      
     public void cadastrarCliente(Cliente c){
        
           String telefone = c.getTelefone();
           String nome = c.getNome();
           int idade = c.getIdade();
           String script = "Insert into cliente (nome,telefone,idade) values ('"+nome+"','"+telefone+"',"+idade+")";
             
      
         try {
             this.statement.executeUpdate(script);
             
         } catch (Exception e) {
             
             System.out.println("Errinho"+e.getMessage());
         }
         
         
         
       
     }
     
public ArrayList<Cliente> buscarCliente(){
    String script = "Select*from cliente";
    ArrayList <Cliente> clientes = new ArrayList<>();
    try {
      this.resultset=  this.statement.executeQuery(script);
      
      while(this.resultset.next()){
      Cliente c = new Cliente();
      String telefone = resultset.getString("telefone");
      String nome = resultset.getString("nome");
      int idade = resultset.getInt("idade");
      c.setIdade(idade);
      c.setNome(nome);
      c.setTelefone(telefone);
      clientes.add(c);
          
      }
       
    } catch (Exception e) {
        System.out.println("Deu merda"+e.getMessage());
    }
    
    return clientes;
    
   
        
    }

 public void editarCliente (int id,Cliente cliente){
     String nome = cliente.getNome();
     String telefone = cliente.getTelefone();
     int idade = cliente.getIdade();
     String script = "update cliente set nome='"+nome+"', telefone = '"+telefone+"', idade = "+idade+" where idCliente="+id;
     try {
       this.statement.executeUpdate(script);
     } catch (Exception e) {
         System.out.println("Erro pae"+e.getMessage());
     
     
     }
     
    
     
     
}    
 
  public void excluirUsuario(int id){
         String script = "delete from cliente where idCliente="+id;
         try {
          this.statement.executeUpdate(script);
      } catch (Exception e) {
             System.out.println("Errinhopainho"+e.getMessage());
          
             
      }
         
     }
    
}
