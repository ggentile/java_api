package br.com.ggentile.gerenciador.modules.People.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.ggentile.gerenciador.modules.People.Model.People;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PeopleResponse{

    private Integer id;

    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @JsonProperty("Endereço")
    private String mainAdress;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonProperty("criado às")
    private LocalDateTime createdAt;


    public static PeopleResponse of(People person){
        return PeopleResponse
                .builder()
                .id(person.getId())
                .nome(person.getName())
                .dataNascimento(person.getDataNascimento())
                .mainAdress(person.getLogradouro() + person.getNumero() + person.getCep() + person.getCidade())
                .createdAt(person.getCreatedAt())
                .build();
    }

}