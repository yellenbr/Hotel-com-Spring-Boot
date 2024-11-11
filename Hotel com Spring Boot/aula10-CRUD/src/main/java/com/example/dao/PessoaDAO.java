/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.aula10.ConnectionFactory;
import com.example.dto.PessoaDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDAO {

    ConnectionFactory conn = new ConnectionFactory();

    public Boolean inserePessoa(PessoaDTO pessoas) {
        try {
            PreparedStatement ps = conn.getConnectionFactory().prepareStatement("INSERT INTO pessoas VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, null);
            ps.setString(2, pessoas.nome());
            ps.setString(3, pessoas.sexo());
            ps.setString(4, pessoas.email());
            ps.setDate(5, java.sql.Date.valueOf(pessoas.data_chegada()));
            ps.setString(6, pessoas.qtd_noites());
            ps.setString(7, pessoas.qtd_hospedes());
            ps.setString(8, pessoas.mensagem());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public void exibePessoasConsole() {
        try {
            PreparedStatement ps = conn.getConnectionFactory()
                    .prepareStatement("select * from pessoas");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                var p = new PessoaDTO(rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5).toLocalDate(), rs.getString(6), rs.getString(7), rs.getString(8));
                System.out.println("Nome: " + p.nome());
                System.out.println("Sexo: " + p.sexo());
                System.out.println("Email: " + p.email());
                System.out.println("Data de chegada: " + p.data_chegada());
                System.out.println("Quantas noites?: " + p.qtd_noites());
                System.out.println("Quantos hospedes?: " + p.qtd_hospedes());
                System.out.println("Mensagem: " + p.mensagem());
                System.out.println("----------");

            }
        } catch (SQLException e) {

        }
    }
}
