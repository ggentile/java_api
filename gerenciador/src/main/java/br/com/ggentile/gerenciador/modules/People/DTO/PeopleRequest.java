package br.com.ggentile.gerenciador.modules.People.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PeopleRequest {

    private Integer id;
    
    private String nome;

    private LocalDate dataNascimento;

    private String logradouro;

    private Integer numero;

    private String CEP;

    private String cidade;

}
