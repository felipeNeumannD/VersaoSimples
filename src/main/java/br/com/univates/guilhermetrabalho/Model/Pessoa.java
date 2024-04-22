/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.guilhermetrabalho.Model;

/**
 *
 * 
 */
public class Pessoa {

    int id_pessoa;
    String nome;
    String senhar;
    String email;
    String cpf;
    String celular;

    public Pessoa(int id_pessoa, String nome, String senhar, String email, String cpf, String celular) {
        this.id_pessoa = id_pessoa;
        this.nome = nome;
        this.senhar = senhar;
        this.email = email;
        this.cpf = cpf;
        this.celular = celular;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenhar(String senhar) {
        this.senhar = senhar;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public String getSenhar() {
        return senhar;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    
}

