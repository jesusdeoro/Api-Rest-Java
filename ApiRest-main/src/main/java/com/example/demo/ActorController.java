package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class ActorController {

    @Autowired
    ActorRepository actorRepository;   

@GetMapping("/actors")

public List<Actor> findAll(){
  return actorRepository.findAll();
}
@GetMapping("/actors/{id}")
public Optional<Actor> findById(@PathVariable Integer id){
    return actorRepository.findById(id);
}
    
}
