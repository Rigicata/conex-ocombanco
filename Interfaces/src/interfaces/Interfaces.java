/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class Interfaces {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexao c = new Conexao();
       
        c.conectar();
        if(c.isConnected()){
        System.out.println("GG IZI PAE");    
        }else {
            System.out.println("Vai dar não");
        }
       
      String nome = "fran",telefone ="1516555616";
      int idade = 18;
      String script= "Insert into cliente (nome,telefone,idade) values ('"+nome+"','"+telefone+"',"+idade+")";

        
        System.out.println(script);
        
        Cliente cl = new Cliente();
       // String nome2 = JOptionPane.showInputDialog("Informe nome");
        //String telefone2 = JOptionPane.showInputDialog("Informe telefone");
        //int idade2 = 15;
        //cl.setIdade(idade2);
        //cl.setNome(nome2);
        //cl.setTelefone(telefone2);
        int id = Integer.parseInt(JOptionPane.showInputDialog("Informe seu id"));
        //c.cadastrarCliente(cl);
        //c.buscarCliente();
       // c.editarCliente(id, cl);
        c.excluirUsuario(id);
        
       ArrayList <Cliente>clientes = c.buscarCliente();
        
        for(int i=0;i<clientes.size();i++){
            System.out.println("Cliente"+( i+1));
            System.out.println("Nome: "+clientes.get(i).getNome());
            System.out.println("Telefone: "+clientes.get(i).getTelefone());
            System.out.println("Idade: "+clientes.get(i).getIdade());
            System.out.println("--------------------------------------------");
            
            
        }
     
        
        
        
        
        
        
        
        
    }
    
}
