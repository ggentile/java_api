package br.com.ggentile.gerenciador.modules.People.Service;


import org.springframework.beans.factory.annotation.Autowired;

import br.com.ggentile.gerenciador.modules.People.DTO.PeopleRequest;
import br.com.ggentile.gerenciador.modules.People.DTO.PeopleResponse;
import br.com.ggentile.gerenciador.modules.People.Model.People;
import br.com.ggentile.gerenciador.modules.People.Repository.PeopleRepository;
import io.micrometer.common.lang.Nullable;


public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    public PeopleResponse save(PeopleRequest request){
        validatePeopleDataInformed(request);
        var person = peopleRepository.save(People.of(request));
        return PeopleResponse.of(person);

    }


    public PeopleResponse findByIdResponse(Integer id){
        return PeopleResponse.of(findById(id));
    }

    public PeopleResponse updatePeople(Integer id, PeopleRequest request){
        validatePeopleDataInformed(request);
        PeopleResponse person = findByIdResponse(request.getId());
        person.setId(id);
        peopleRepository.save(null)
        return person;
    }


    public People findById(Integer id){
        return peopleRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("There's no person with the id informed"));
    }



    private void validatePeopleDataInformed(PeopleRequest request){
        if(isEmpty(request.getNome()) || isEmpty(request.getDataNascimento()) || isEmpty(request.getLogradouro())
        || isEmpty(request.getNumero()) || isEmpty(request.getCEP()) || isEmpty(request.getCidade())) {
            throw new RuntimeException();
        }
    }
    

    public static boolean isEmpty(@Nullable Object obj){
        if(obj == null){
            return true;
        }
        return false;
    }
}
