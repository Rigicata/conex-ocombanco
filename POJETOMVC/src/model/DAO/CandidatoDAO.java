/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Candidato;
import model.Conexao;
public class CandidatoDAO{
    Conexao conexao;

    public CandidatoDAO() {
      conexao = new Conexao();
    
    }
              
    
   public void insereCandidato(Candidato candidato){
       
       try {
           Connection c = conexao.conectar();
           String sql = "INSERT INTO Candidato"+"(nome,numero,partido,cpf,fichalimpa)"+"values(?,?,?,?,?)";
           PreparedStatement pst = (PreparedStatement) c.prepareStatement(sql);  
           pst.setString(1, candidato.getNome());
           pst.setInt(2, candidato.getPartido());
           pst.setInt(3,candidato.getNumero());
           pst.setString(4, candidato.getCpf());
           pst.setBoolean(5, candidato.isFichalimpa());
           pst.execute();
       } catch (Exception e) {
           System.out.println("Erro: "+e.getMessage()); 
       }
   
       
       
    
   }
   
      public ArrayList<Candidato> buscarCandidato(){
           String script = "select*from candidato";
           ArrayList<Candidato> candidatos = new ArrayList<>();
           Candidato candidato;
           
           try {
             Connection c = this.conexao.conectar();
             PreparedStatement pst = (PreparedStatement) c.prepareStatement(script);               
             ResultSet rs = pst.executeQuery();
              while(rs.next()){
                candidato = new Candidato();
                candidato.setCpf(rs.getString("CPF"));
                candidato.setNome(rs.getString("nome"));
                candidato.setNumero(rs.getInt("numero"));
                candidato.setPartido(rs.getInt("partido"));
                candidato.setFichalimpa(rs.getBoolean("fichalimpa"));
                candidato.setId(rs.getInt("id"));
                candidatos.add(candidato);
                  
              }
             
             
             
             
           } catch (Exception e) {
               System.out.println("Erro: "+e.getMessage()); 
           }
           
           return candidatos;
       }
        
        
    
}
