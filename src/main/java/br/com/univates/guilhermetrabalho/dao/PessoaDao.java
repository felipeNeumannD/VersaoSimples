/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.univates.guilhermetrabalho.dao;

import br.com.univates.guilhermetrabalho.Model.Pessoa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Felipe
 */
public class PessoaDao {
    public static Connection getConnection() {
         Connection con = null;
    try {
        // Carregar o driver PostgreSQL
        Class.forName("org.postgresql.Driver");
        // Estabelecer a conexão
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Pessoa", "postgres", "postgres");
    } catch (Exception e) {
        System.out.println(e);
    }
    return con;
    }
    
    
    public void adicionar(Pessoa pessoa) throws SQLException {
        String sql = "insert into pessoa (nome, senha, email, cpf, celular) values(?, ?, ?, ?, ?)";

        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setString(1, pessoa.getNome());
        statement.setString(2, pessoa.getSenhar());
        statement.setString(3, pessoa.getEmail());
        statement.setString(4, pessoa.getCpf());
        statement.setString(5, pessoa.getCelular());
        statement.execute();
        statement.close();
    }
    
    public Pessoa read(Integer numero) {
        String sql = "select id_pessoa, nome, senha, email, cpf, celular from pessoa where id_pessoa = ?";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, numero);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                int id = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                String senhar = resultSet.getString(3);
                String email =  resultSet.getString(4);
                String cpf = resultSet.getString(5);
                String celular = resultSet.getString(6);
                Pessoa pessoa = new Pessoa(id, nome, senhar, email, cpf, celular);
                
                preparedStatement.close();
                resultSet.close();
                return pessoa;
            } 
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public void alterar(Pessoa pessoa){
        String sql = String.format("update pessoa set nome = ?, senha = ?, email = ?, cpf = ?, celular = ?  where id_pessoa = %d", pessoa.getId_pessoa());
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, pessoa.getNome());
            statement.setString(2, pessoa.getSenhar());
            statement.setString(3, pessoa.getEmail());
            statement.setString(4, pessoa.getCpf());
            statement.setString(5, pessoa.getCelular());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public void excluir(Integer numero) {
        try {
            String sql = String.format("delete from pessoa where id_pessoa = %d", numero);
            Statement statement = getConnection().createStatement();
            statement.execute(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
    
}
