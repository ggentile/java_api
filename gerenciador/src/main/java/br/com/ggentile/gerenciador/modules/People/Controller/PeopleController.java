package br.com.ggentile.gerenciador.modules.People.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ggentile.gerenciador.modules.People.DTO.PeopleRequest;
import br.com.ggentile.gerenciador.modules.People.DTO.PeopleResponse;
import br.com.ggentile.gerenciador.modules.People.Service.PeopleService;

@RestController
@RequestMapping("/api/people")
public class PeopleController {
    

    @Autowired
    private PeopleService peopleService;

    @GetMapping("/{id}")
    public PeopleResponse consultaPessoa(@PathVariable Integer id){
        return peopleService.findByIdResponse(id);
    }

    @PutMapping("/edit/{id}")
    public PeopleResponse editarPessoa(@PathVariable Integer id, @RequestBody PeopleRequest request){
        return peopleService.updatePeople(id, request);
    }

    @PostMapping
    public PeopleResponse save(@RequestBody PeopleRequest request){
        return peopleService.save(request);
    }

}
