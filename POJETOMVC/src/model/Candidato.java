/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aluno
 */
public class Candidato {
    private String nome;
    private int numero;
    private boolean fichalimpa;
    private int partido;
    private String cpf;
    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return this.cpf;
    }

    
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isFichalimpa() {
        return this.fichalimpa;
    }

    public void setFichalimpa(boolean fichalimpa) {
        this.fichalimpa = fichalimpa;
    }

    public int getPartido() {
        return this.partido;
    }

    public void setPartido(int partido) {
        this.partido = partido;
    }
    
}
