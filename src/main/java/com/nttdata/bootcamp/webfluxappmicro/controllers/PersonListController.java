package com.nttdata.bootcamp.webfluxappmicro.controllers;

import com.nttdata.bootcamp.webfluxappmicro.Person;
import com.nttdata.bootcamp.webfluxappmicro.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Controller
public class PersonListController {
    @Autowired
    PersonService personService;

    @GetMapping("/person-list")
    public String personList(final Model model){
        final Flux<Person> personlist = personService.allPersons();
        model.addAttribute("personlist",personlist);
        return "personlist";
    }
}
