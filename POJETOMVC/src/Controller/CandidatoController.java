/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Views.CandidatoView;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Candidato;
import model.DAO.CandidatoDAO;

public class CandidatoController implements ActionListener{
  CandidatoView cv = new CandidatoView();
  CandidatoDAO cDao = new CandidatoDAO();
  
public CandidatoController(CandidatoView candidatoView){
   this.cv = candidatoView;
  cv.btn_cadastrar.addActionListener(this);
  cv.btn_buscar.addActionListener(this);
        

}

   @Override

    public void actionPerformed(ActionEvent ae){// Serve para ficar ouvindo o que o usuário vai fazer 
          if(ae.getSource() == cv.btn_cadastrar){
              Candidato c = new Candidato();
              c.setCpf(cv.txt_cpf.getText());
              c.setNome(cv.txt_nome.getText());
              c.setNumero(Integer.parseInt(cv.txt_numero.getText()));
              c.setPartido(Integer.parseInt(cv.txt_partido.getText()));
              if(cv.ck_sim.isSelected()){
                  c.setFichalimpa(true);
              }else {
                  c.setFichalimpa(false);
              }
              
              cDao.insereCandidato(c);
              JOptionPane.showMessageDialog(null, "CADASTROU CABEÇA");
             

              
          }
          
           if(ae.getSource()==cv.btn_buscar){
                   preencheTabela(cv.table_cand);
              }
             
    }
          

public void preencheTabela(JTable tabela){
    
    DefaultTableModel tabelado = new DefaultTableModel();
    tabela.setModel(tabelado);
    tabelado.addColumn("ID");
    tabelado.addColumn("Nome");
    tabelado.addColumn("Número");
    tabelado.addColumn("Partido");
    tabelado.addColumn("CPF");
    tabelado.addColumn("FichaLimpa");
    Object[] coluna = new Object[6];
    ArrayList<Candidato> candidatos = cDao.buscarCandidato();
    for(int i=0;i<candidatos.size();i++){
       coluna[0] = candidatos.get(i).getId();
       coluna[1] = candidatos.get(i).getNome();
       coluna[2] = candidatos.get(i).getNumero();
       coluna[3] = candidatos.get(i).getPartido();
       coluna[4] = candidatos.get(i).getCpf();
       coluna[5] = candidatos.get(i).isFichalimpa();
       tabelado.addRow(coluna);
       
            
        }
    tabela.setModel(tabelado);
            
        }
        
    } 
   
    
    
    
    
    
    

  
  
 
          
          
    

    
    

