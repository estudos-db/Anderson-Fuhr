package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pessoa {

    Documento endereco;

    @Autowired
    public Pessoa(Documento endereco) {
        this.endereco = endereco;
    }
    private Integer idade;

    public String menorMaiorIdade() {
        return idade < 18 ? "menor de idade" : "maior de idade";
    }

    public String buscarDocumento(int numeroDaRua){
        return "RG da Pessoa é: " + endereco.getDocumento(numeroDaRua) ;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}