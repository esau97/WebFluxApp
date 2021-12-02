package com.nttdata.bootcamp.webfluxappmicro.service;

import com.nttdata.bootcamp.webfluxappmicro.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class PersonService {
    public Flux<Person> allPersons (){
        Flux<Person> flux = WebClient.create("http://localhost:8080/person-list-1").get().retrieve().bodyToFlux(Person.class);
        Flux<Person> flux1 = WebClient.create("http://localhost:8080/person-list-2").get().retrieve().bodyToFlux(Person.class);
        Flux<Person> flux2 = WebClient.create("http://localhost:8080/person-list-3").get().retrieve().bodyToFlux(Person.class);
        Flux<Person> flux3 = WebClient.create("http://localhost:8080/person-list-4").get().retrieve().bodyToFlux(Person.class);

        Flux<Person> allPerson = Flux.merge(flux,flux1,flux2,flux3);

        return allPerson;
    }
}
