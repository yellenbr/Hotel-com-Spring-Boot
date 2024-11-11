/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.aula10;
import com.example.dto.PessoaDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.dao.PessoaDAO;

@RestController
@RequestMapping("/pessoas")
public class MeuController {
    
    
    @GetMapping
    public void busca(){
        PessoaDAO pd = new PessoaDAO();
        pd.exibePessoasConsole();
    }
    
     @PostMapping
    public boolean insere(@RequestBody PessoaDTO dados){
        PessoaDAO pd = new PessoaDAO();
        return pd.inserePessoa(dados);
    }

    
}
