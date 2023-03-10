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
public class CountryController {

    @Autowired
    CountryRepository countryRepository;   

@GetMapping("/hola")
public String hola(){
    return "hola";
}

@GetMapping("/country")

public List<Country> findAll(){
  return countryRepository.findAll();
}
@GetMapping("/country/{id}")
public Optional<Country> findById(@PathVariable Integer id){
    return countryRepository.findById(id);
}
    
}
