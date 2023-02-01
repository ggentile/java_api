package br.com.ggentile.gerenciador.modules.People.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ggentile.gerenciador.modules.People.Model.People;

public interface PeopleRepository extends JpaRepository<People, Integer> {

}
