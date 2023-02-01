package br.com.ggentile.gerenciador.modules.People.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.ggentile.gerenciador.modules.People.DTO.PeopleRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "pessoa", schema = "public")
@Data
@Builder
public class People {

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Integer id;

@Column(name = "Name", nullable = false)
private String name;

@Column(name = "Data Nascimento", nullable = false)
private LocalDate dataNascimento;

@Column(name = "Logradouro", nullable = false)
private String logradouro;

@Column(name = "CEP", nullable = false)
private String cep;

@Column(name= "Número", nullable = false)
private Integer numero;

@Column(name = "Cidade", nullable = false)
private String cidade;

@Column(name = "Created_at", nullable = false, updatable = false)
private LocalDateTime CreatedAt;



@PrePersist
public void PrePersist(){
    CreatedAt = LocalDateTime.now();
}

public static People of(PeopleRequest request){
    return People
            .builder()
            .name(request.getNome())
            .dataNascimento(request.getDataNascimento())
            .logradouro(request.getLogradouro())
            .numero(request.getNumero())
            .cep(request.getCEP())
            .cidade(request.getCidade())
            .build();
}

}
