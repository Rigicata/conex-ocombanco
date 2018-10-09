
import Controller.CandidatoController;
import Views.CandidatoView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Main{
        
/**
 *
 * @author aluno
 */
 public static void main (String[] args) {
      CandidatoView candy = new CandidatoView();
      candy.setVisible(true);
      CandidatoController cc = new CandidatoController(candy);
      
      
}

  
}