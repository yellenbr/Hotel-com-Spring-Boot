/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dto;

import java.time.LocalDate;

public record PessoaDTO (String nome, String sexo, String email, LocalDate data_chegada, String qtd_noites, String qtd_hospedes, String mensagem ){
    
}
