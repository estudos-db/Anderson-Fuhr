package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class Test {

    /* Cria um dublê de pessoa, sendo assim, não será necessário criar uma new Pessoa() e indica que deve injetar
    outros dubles nesta Instância */
    @InjectMocks
    Pessoa pessoa;

    // Indica que deve criar um dublê de Endereco
    @Mock
    Documento endereco;

    //Método que será executado antes de cada @Teste
    @BeforeEach
    void inicializar() {
        //Inicializa os dubles
        openMocks(this);

        //Faz o primeiro set em pessoa
        pessoa.setIdade(18);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Valida se e menor de Idade")
    void deveRetornarStringMaiorDeIdade() {

        pessoa.setIdade(10);
        String valorRetornado = pessoa.menorMaiorIdade();

        Assertions.assertEquals(10, pessoa.getIdade());
        Assertions.assertEquals("menor de idade", valorRetornado, "Deveria validar que idade é menor");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Valida se e maior de Idade")
    void deveRetornarStringMenorDeIdade() {
        String valorRetornado = pessoa.menorMaiorIdade();

        Assertions.assertEquals(18, pessoa.getIdade());
        Assertions.assertEquals("maior de idade", valorRetornado, "Deveria validar que idade é maior");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Teste que simula uma chamada em outro serviço")
    void deveRetornarARuaDaPessoa() {
        // Simula a chamada a outro serviço e retorna um valor pré definido após executar o método passado ao when
        final int parametro = 10;
        when(endereco.getDocumento(parametro)).thenReturn("008521452-50");

        // Excecuta o método de pessoa que irá consultar outro serviço e tratar os dados recebidos
        String valorRetornado = pessoa.buscarDocumento(parametro);

        /* Conforme a lógica inserida na classe Pessoa, ao invocar o método adicionarNumeroDaRua(),
        ela deve fazer uma chamada a outro serviço e buscar uma string */
        final String valorEsperado = "RG da Pessoa é: 008521452-50";

        Assertions.assertEquals(valorEsperado, valorRetornado, "Deve retornar a String: Rua do joao, numero: 235");
    }
}
